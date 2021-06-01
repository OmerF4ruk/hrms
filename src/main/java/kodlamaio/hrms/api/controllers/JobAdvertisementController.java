package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdversitementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementController {

    private JobAdversitementService jobAdversitementService;

    @Autowired
    public JobAdvertisementController(JobAdversitementService jobAdversitementService) {
        this.jobAdversitementService = jobAdversitementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdversitementService.getAll();
    }

    @GetMapping("/getByIsActiveOrderByCreationDateDesc")
    public DataResult<List<JobAdvertisement>> getByIsActiveOrderByCreationDateDesc(){
        return this.jobAdversitementService.getByIsActiveOrderByCreationDateDesc();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdversitementService.add(jobAdvertisement);
    }
    @GetMapping("/getByIsActiveAndCompanyName")
    public DataResult<List<JobAdvertisement>> getByIsActiveAndEmployer_CompanyName(@RequestParam("companyName") String companyName) {
        return this.jobAdversitementService.getByIsActiveAndEmployer_CompanyName( companyName);
    }

    @GetMapping("/getByCompanyName")
    public DataResult<List<JobAdvertisement>>getByEmployer_CompanyName(@RequestParam String companyName){
        return this.jobAdversitementService.getByEmployer_CompanyName(companyName);
    }

    @GetMapping("/changeStatus")
    public DataResult<JobAdvertisement> changeStatus(@RequestParam String companyName,@RequestParam int advertisementId) {
        return this.jobAdversitementService.changeStatus(companyName, advertisementId);
    }
}
