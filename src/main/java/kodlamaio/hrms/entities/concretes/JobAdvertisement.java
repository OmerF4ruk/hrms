package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="job_advertisement")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne()
    @JoinColumn(name="employer_id")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="department_id")
    private Department department;

    @Column(name="job_description")
    private String description;

    @Column(name="city")
    private String city;

    @Column(name="min_salary")
    private int minSalary;

    @Column(name="max_salary")
    private int maxSalary;

    @Column(name="number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="application_deadline")
    private Date applicationDeadline;

    @Column(name="is_active")
    private boolean isActive;
}
