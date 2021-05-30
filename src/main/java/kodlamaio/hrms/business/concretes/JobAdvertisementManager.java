package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdversitementService;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdversitementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"iş listesi listelendi ");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"creationDate");
        return new SuccessDataResult<List<JobAdvertisement>>( this.jobAdvertisementDao.findAll(sort));
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
       this.jobAdvertisementDao.save(jobAdvertisement);
       return new SuccessResult("iş İlanı listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementDao.getByIsActiveTrueAndEmployer_CompanyName(companyName),"listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEmployer_CompanyName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>
                (this.jobAdvertisementDao.getByEmployer_CompanyName(companyName));
    }

    @Override
    public DataResult<JobAdvertisement> changeStatus(String companyName,int advertisementId, boolean status) {

        List<JobAdvertisement> advertisements = this.jobAdvertisementDao.getByEmployer_CompanyName(companyName);

        for (JobAdvertisement jobAdvertisement : advertisements) {
            if (advertisementId == jobAdvertisement.getId()) {
                jobAdvertisement.setActive(status);
                this.jobAdvertisementDao.save(jobAdvertisement);
                return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(advertisementId));
            }
        }

        return new ErrorDataResult<JobAdvertisement>();
    }

}
