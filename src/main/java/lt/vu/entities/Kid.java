package lt.vu.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Entity // naudojama, jog keltų į duombazę objektą
@Table(name = "KID")  //Norint pakeisti lentelės pavadinimą
@Getter @Setter

public class Kid {

    @Id
    @Column(name = "id") // norint pakeisti stulpelio pavadinimą
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 40)
    @Column(nullable = false)
    private String firstName;

    @Size(max = 40)
    @Column(nullable = false)
    private String lastName;

    private Date birthDate;

    // One to many ryšys
    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "id")
    private Group group;
}
