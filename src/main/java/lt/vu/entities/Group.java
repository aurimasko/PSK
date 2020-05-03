package lt.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "KIDS_GROUP")
@Getter @Setter
@NamedQueries({
        @NamedQuery(name = "Group.findAll", query = "select a from Group as a")
})

public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 40)
    @Column(nullable = false)
    private String name;

    @Size(max = 100)
    private String city;

    @OneToMany(mappedBy = "group")
    private List<Kid> kids = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GroupLeaders",
               joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"),
               inverseJoinColumns =  @JoinColumn(name = "leader_id", referencedColumnName = "id")
    )

    private List<Leader> leaderList = new ArrayList<Leader>();
}
