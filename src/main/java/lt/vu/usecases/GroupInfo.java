package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Group;
import lt.vu.entities.Kid;
import lt.vu.entities.Leader;
import lt.vu.persistence.GroupsDAO;
import lt.vu.persistence.KidsDAO;
import lt.vu.persistence.LeadersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lt.vu.interceptors.LoggedInvocation;

@Model
public class GroupInfo implements Serializable {

    @Inject
    private LeadersDAO leadersDAO;

    @Inject
    private GroupsDAO groupsDAO;

    @Inject
    private KidsDAO kidsDAO;

    @Getter
    @Setter
    private Group group;

    @Getter @Setter
    private Kid kidToCreate = new Kid();

    @Getter @Setter
    private Leader leaderToCreate = new Leader();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer groupId = Integer.parseInt(requestParameters.get("groupId"));
        this.group = groupsDAO.findOne(groupId);
    }

    @Transactional
    @LoggedInvocation
    public String createKid() {
        kidToCreate.setGroup(this.group);

        kidsDAO.persist(kidToCreate);
        return "groupInfo?faces-redirect=true&groupId=" + this.group.getId();
    }


    @Transactional
    @LoggedInvocation
    public String createLeader() {
        List<Group> groupsList = new ArrayList<>();
        groupsList.add(this.group);
        leaderToCreate.setGroupList(groupsList);

        List<Leader> leadersList = this.group.getLeaderList();
        leadersList.add(leaderToCreate);
        this.group.setLeaderList(leadersList);

        leadersDAO.persist(leaderToCreate);
        return "groupInfo?faces-redirect=true&groupId=" + this.group.getId();
    }
}
