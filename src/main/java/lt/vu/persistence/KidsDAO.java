package lt.vu.persistence;

import lt.vu.entities.Kid;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class KidsDAO {

    @Inject
    private EntityManager em;

    public void persist(Kid kid){
        this.em.persist(kid);
    }

    public Kid findOne(Integer id){
        return em.find(Kid.class, id);
    }

    public Kid update(Kid kid){
        return em.merge(kid);
    }
}
