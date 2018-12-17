package models;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "workers")
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "department")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;
    @ManyToOne(
            cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER
    )
    private Department department;

    public Worker() {
    }

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
