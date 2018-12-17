package models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="companies")
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "departments")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "company",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Department> departments = new ArrayList<Department>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }
}
