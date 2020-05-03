package lt.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@NamedQuery(name = "Leader.findAll", query = "select l from Leader as l")
@Table(name = "LEADER")
@Entity
@Getter @Setter

public class Leader implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 40)
    @Column(nullable = false)
    private String name;

    @Size(max = 15)
    private String phoneNo;

    @Size(max = 40)
    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private Date birthDate;


    @ManyToMany(mappedBy = "leaderList")
    private List<Group> groupList = new ArrayList<Group>();

}
