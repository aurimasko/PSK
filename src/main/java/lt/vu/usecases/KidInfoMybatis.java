package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.KidMapper;
import lt.vu.mybatis.model.Kid;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class KidInfoMybatis  {

    @Inject
    private KidMapper kidMapper;

    @Getter
    @Setter
    private Kid kid;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer kidId = Integer.parseInt(requestParameters.get("kidId"));
        this.kid = kidMapper.selectByPrimaryKey(kidId);
    }
}
