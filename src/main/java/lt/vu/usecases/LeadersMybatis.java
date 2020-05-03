package lt.vu.usecases;


import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.LeaderMapper;
import lt.vu.mybatis.model.Leader;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class LeadersMybatis {

    @Inject
    private LeaderMapper leaderMapper;

    @Getter
    @Setter
    private List<Leader> allLeaders;


    @PostConstruct
    public void init() {
      loadAllLeaders();
    }

    private void loadAllLeaders(){
        allLeaders = leaderMapper.selectAll();
    }
}
