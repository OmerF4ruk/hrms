package kodlamaio.hrms.core.utilities.mernis.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public interface MernisCheckService {
    public boolean checkIfRealPerson(JobSeeker jobSeeker);

}
