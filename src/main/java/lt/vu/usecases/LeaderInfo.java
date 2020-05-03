package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Group;
import lt.vu.entities.Kid;
import lt.vu.entities.Leader;
import lt.vu.interceptors.LoggedInvocation;
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

@Model
public class LeaderInfo implements Serializable {

    @Inject
    private LeadersDAO leadersDAO;

    @Inject
    private GroupsDAO groupsDAO;

    @Getter
    @Setter
    private Leader leader;

    @Getter @Setter
    private Group groupToCreate = new Group();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer leaderId = Integer.parseInt(requestParameters.get("leaderId"));
        this.leader = leadersDAO.findOne(leaderId);
    }

    @Transactional
    @LoggedInvocation
    public String createGroup() {

        List<Leader> leadersList = new ArrayList<>();
        leadersList.add(this.leader);
        groupToCreate.setLeaderList(leadersList);

        List<Group> groupsList = this.leader.getGroupList();
        groupsList.add(groupToCreate);
        this.leader.setGroupList(groupsList);

        groupsDAO.persist(groupToCreate);
        return "leaderInfo?faces-redirect=true&leaderId=" + this.leader.getId();
    }


}
