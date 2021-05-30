package kodlamaio.hrms.core.utilities.mernis.concretes;

import kodlamaio.hrms.core.utilities.mernis.abstracts.MernisCheckService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class FakeMernisCheckAdapter implements MernisCheckService {
    @Override
    public boolean checkIfRealPerson(JobSeeker jobSeeker) {
        return true;
    }
}
