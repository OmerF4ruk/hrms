package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    List<JobSeeker> getAll();
    Result add(JobSeeker jobSeeker);
    List<String> getAllEmails();
    List<String> getAllIdentityNumber();

}
