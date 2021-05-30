package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    List<Employer> getAll();
    Result add(Employer employer);
    List<String> getAllEmails();
}
