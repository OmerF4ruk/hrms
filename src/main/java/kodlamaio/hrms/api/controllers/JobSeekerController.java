package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;

    }
    @GetMapping("/getall")
     List<JobSeeker> getAll(){
        return this.jobSeekerService.getAll();
    }

    @PostMapping("/add")
    Result add(@RequestBody JobSeeker jobSeeker){
        return this.jobSeekerService.add(jobSeeker);

    }

}
