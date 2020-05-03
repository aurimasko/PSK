package lt.vu.persistence;


import lt.vu.entities.Leader;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class LeadersDAO {

    @Inject
    private EntityManager em;

    public List<Leader> getAllLeaders(){
        return em.createNamedQuery("Leader.findAll", Leader.class).getResultList();
    }

    public void persist(Leader leader){
        em.persist(leader);
    }

    public Leader update(Leader leader){
        return em.merge(leader);
    }

    public Leader findOne(Integer id){
        return em.find(Leader.class, id);
    }
}