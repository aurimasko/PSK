package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Group;
import lt.vu.entities.Leader;
import lt.vu.persistence.GroupsDAO;
import lt.vu.persistence.LeadersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class Leaders implements Serializable {

    @Inject
    private LeadersDAO leadersDAO;

    @Getter
    @Setter
    private List<Leader> allLeaders;


    @PostConstruct
    public void init() {
      loadAllLeaders();
    }

    private void loadAllLeaders(){
        allLeaders = leadersDAO.getAllLeaders();
    }
}
