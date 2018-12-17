package models;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"company", "workers"})
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER
    )
    private Company company;
    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Worker> workers = new ArrayList<Worker>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }
}
