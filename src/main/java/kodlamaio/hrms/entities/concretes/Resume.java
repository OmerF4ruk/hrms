package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.entities.concretes.resumes.WorkExperience;
import kodlamaio.hrms.entities.concretes.resumes.Education;
import kodlamaio.hrms.entities.concretes.resumes.ForeignLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "educations", "hibernateLazyInitializer", "handler", "workExperiences", "hibernateLazyInitializer", "handler", "foreignLanguages"})
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="job_seeker_id")
    private JobSeeker jobSeeker;

    @OneToMany(mappedBy = "resume")
    private List<Education> educations;

    @OneToMany(mappedBy = "resume")
    private List<WorkExperience> workExperiences;

    @OneToMany(mappedBy = "resume")
    private List<ForeignLanguage> foreignLanguages;

    @Column(name="github_link")
    private String github;

    @Column(name="linkedin_link")
    private String linkedin;

    @Column(name="technology")
    private String technology;

    @Column(name="summary")
    private String Summary;



}
