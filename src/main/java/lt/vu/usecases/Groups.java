package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Group;
import lt.vu.persistence.GroupsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class Groups implements Serializable {

    @Inject
    private GroupsDAO groupsDAO;

    @Getter
    @Setter
    private List<Group> allGroups;


    @PostConstruct
    public void init() {
      loadAllGroups();
    }

    private void loadAllGroups(){
        allGroups = groupsDAO.getAllGroups();
    }
}
