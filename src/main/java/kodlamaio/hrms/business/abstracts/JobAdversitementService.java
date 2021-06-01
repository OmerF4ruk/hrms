package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;


public interface JobAdversitementService {
    public DataResult<List<JobAdvertisement>> getAll();
    public DataResult<List<JobAdvertisement>> getByIsActiveOrderByCreationDateDesc();
    public Result add(JobAdvertisement jobAdvertisement);

    public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName);

    public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(String companyName);

    public DataResult changeStatus(String companyName,int advertisementId);

}
