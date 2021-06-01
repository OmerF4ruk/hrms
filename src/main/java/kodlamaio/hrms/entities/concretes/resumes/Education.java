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
@Table(name="education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="school_name")
    private String schoolName;

    @Column(name="department")
    private String department;

    @Column(name="start_of_school")
    private Date startofSchool;

    @Column(name="graduation_year")
    private Date graduationYear;

    @Column(name="is_graduated")
    private boolean isGraduated;

    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;


}

