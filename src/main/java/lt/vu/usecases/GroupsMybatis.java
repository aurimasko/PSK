package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Group;
import lt.vu.mybatis.dao.KidsGroupMapper;
import lt.vu.mybatis.model.KidsGroup;
import lt.vu.persistence.GroupsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class GroupsMybatis {

    @Inject
    private KidsGroupMapper kidsGroupMapper;

    @Getter
    @Setter
    private List<KidsGroup> allGroups;

    @PostConstruct
    public void init() {
        loadAllGroups();
    }

    private void loadAllGroups(){
        allGroups = kidsGroupMapper.selectAll();
    }
}
