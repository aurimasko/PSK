package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Leader;
import org.mybatis.cdi.Mapper;

@Mapper
public interface LeaderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LEADER
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LEADER
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    int insert(Leader record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LEADER
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    Leader selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LEADER
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    List<Leader> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.LEADER
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    int updateByPrimaryKey(Leader record);
}