package lt.vu.mybatis.model;


import java.util.ArrayList;
import java.util.List;

public class KidsGroup {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.KIDS_GROUP.ID
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.KIDS_GROUP.CITY
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    private String city;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.KIDS_GROUP.NAME
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.KIDS_GROUP.ID
     *
     * @return the value of PUBLIC.KIDS_GROUP.ID
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.KIDS_GROUP.ID
     *
     * @param id the value for PUBLIC.KIDS_GROUP.ID
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.KIDS_GROUP.CITY
     *
     * @return the value of PUBLIC.KIDS_GROUP.CITY
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.KIDS_GROUP.CITY
     *
     * @param city the value for PUBLIC.KIDS_GROUP.CITY
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.KIDS_GROUP.NAME
     *
     * @return the value of PUBLIC.KIDS_GROUP.NAME
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.KIDS_GROUP.NAME
     *
     * @param name the value for PUBLIC.KIDS_GROUP.NAME
     *
     * @mbg.generated Mon May 04 00:06:01 EEST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<Kid> getKidsList(){ return kidsList; }
    public void setKidsList(List<Kid> kidsList){ this.kidsList = kidsList; }
    private List<Kid> kidsList = new ArrayList<>();

    public List<Leader> getLeadersList(){ return leadersList; }
    public void setLeadersList(List<Leader> leadersList){ this.leadersList = leadersList; }
    private List<Leader> leadersList = new ArrayList<>();

}