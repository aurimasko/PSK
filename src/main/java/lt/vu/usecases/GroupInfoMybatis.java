package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.mybatis.dao.KidMapper;
import lt.vu.mybatis.dao.KidsGroupLeaderMapper;
import lt.vu.mybatis.dao.KidsGroupMapper;
import lt.vu.mybatis.dao.LeaderMapper;
import lt.vu.mybatis.model.Kid;
import lt.vu.mybatis.model.KidsGroup;
import lt.vu.mybatis.model.Leader;

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
public class GroupInfoMybatis {

    @Inject
    private LeaderMapper leaderMapper;

    @Inject
    private KidsGroupMapper groupMapper;

    @Inject
    private KidMapper kidMapper;

    @Inject
    private KidsGroupLeaderMapper kidsGroupLeaderMapper;

    @Getter
    @Setter
    private KidsGroup group;

    @Getter @Setter
    private Kid kidToCreate = new Kid();

    @Getter @Setter
    private Leader leaderToCreate = new Leader();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer groupId = Integer.parseInt(requestParameters.get("groupId"));
        this.group = groupMapper.selectByPrimaryKey(groupId);
    }

    @Transactional
    @LoggedInvocation
    public String createKid() {
        kidToCreate.setGroupid(this.group.getId());
        kidMapper.insert(kidToCreate);
        return "groupInfo?faces-redirect=true&groupId=" + this.group.getId();
    }


    @Transactional
    @LoggedInvocation
    public String createLeader() {
        List<KidsGroup> groupsList = new ArrayList<>();
        groupsList.add(this.group);
        leaderToCreate.setGroupList(groupsList);

        List<Leader> leadersList = this.group.getLeadersList();
        leadersList.add(leaderToCreate);
        this.group.setLeadersList(leadersList);

        kidsGroupLeaderMapper.insert(leaderToCreate.getId(), group.getId());
        leaderMapper.insert(leaderToCreate);
        return "groupInfo?faces-redirect=true&groupId=" + this.group.getId();
    }
}
