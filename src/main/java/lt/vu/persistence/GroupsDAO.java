package lt.vu.persistence;

import lt.vu.entities.Group;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GroupsDAO {

    @Inject
    private EntityManager em;

    public List<Group> getAllGroups(){
        return em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }

    public void persist(Group group){
        this.em.persist(group);
    }

    public Group findOne(Integer id){
        return em.find(Group.class, id);
    }

    public Group update(Group group){
        return em.merge(group);
    }
}
