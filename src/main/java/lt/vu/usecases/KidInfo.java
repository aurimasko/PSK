package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Group;
import lt.vu.entities.Kid;
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
import java.util.Map;

@Model
public class KidInfo implements Serializable {

    @Inject
    private KidsDAO kidsDAO;

    @Getter
    @Setter
    private Kid kid;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer kidId = Integer.parseInt(requestParameters.get("kidId"));
        this.kid = kidsDAO.findOne(kidId);
    }
}
