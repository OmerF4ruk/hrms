package kodlamaio.hrms.entities.concretes.resumes;

import kodlamaio.hrms.entities.concretes.Resume;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="work_experience")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="company_name")
    private String companyName;

    @Column(name="position")
    private String position;

    @Column(name="starting_date")
    private Date startingDate;

    @Column(name="exit_date")
    private Date exitDate;

    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;




}
