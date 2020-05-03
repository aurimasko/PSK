package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Group;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.mybatis.dao.KidsGroupLeaderMapper;
import lt.vu.mybatis.dao.KidsGroupMapper;
import lt.vu.mybatis.dao.LeaderMapper;
import lt.vu.mybatis.model.KidsGroup;
import lt.vu.mybatis.model.Leader;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
public class LeaderInfoMybatis  {

    @Inject
    private LeaderMapper leaderMapper;

    @Inject
    private KidsGroupMapper kidsGroupMapper;

    @Inject
    KidsGroupLeaderMapper kidsGroupLeaderMapper;

    @Getter
    @Setter
    private lt.vu.mybatis.model.Leader leader;

    @Getter @Setter
    private KidsGroup groupToCreate = new KidsGroup();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer leaderId = Integer.parseInt(requestParameters.get("leaderId"));
        this.leader = leaderMapper.selectByPrimaryKey(leaderId);
    }

    @Transactional
    @LoggedInvocation
    public String createGroup() {

        List<KidsGroup> groupsList = leader.getGroupList();
        groupsList.add(groupToCreate);
        leader.setGroupList(groupsList);

        List<Leader> leadersList = new ArrayList<>();
        leadersList.add(leader);
        groupToCreate.setLeadersList(leadersList);

        kidsGroupLeaderMapper.insert(leader.getId(), groupToCreate.getId());

        kidsGroupMapper.insert(groupToCreate);
        return "leaderInfo?faces-redirect=true&leaderId=" + this.leader.getId();
    }


}
