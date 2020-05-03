package lt.vu.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

@Mapper
public interface KidsGroupLeaderMapper {
    int insert(@Param("leaderId") Integer leaderId, @Param("groupId") Integer groupId);
}
