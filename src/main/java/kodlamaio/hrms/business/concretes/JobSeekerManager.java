package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.EmailServices.abstracts.EmailSendService;
import kodlamaio.hrms.core.utilities.mernis.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private JobSeekerDao jobSeekerDao;
    private List<String> emails=new ArrayList<String>();
    private List<String> identityNumbers = new ArrayList<>();
    private Result result;
    private MernisCheckService mernisCheckService;
    private EmailSendService emailSendService;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisCheckService mernisCheckService,EmailSendService emailSendService) {
        this.jobSeekerDao = jobSeekerDao;
        this.mernisCheckService=mernisCheckService;
        this.emailSendService=emailSendService;
    }


    @Override
    public List<JobSeeker> getAll() {
        return this.jobSeekerDao.findAll();
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if(isAllFieldFilled(jobSeeker)==null && emailIsItUsed(jobSeeker.getEmail()) && identityNumIsItUsed(jobSeeker.getNationalityId())&& mernisCheckService.checkIfRealPerson(jobSeeker)){
            emailSendService.emailSend(jobSeeker.getEmail());
            this.jobSeekerDao.save(jobSeeker);
            return result=new SuccessResult("İş Arayan Eklendi");
        }
        return result ;

    }

    @Override
    public List<String> getAllEmails() {
        for(int i=0 ; i <getAll().size();i++){
            emails.add(getAll().get(i).getEmail());
        }
        return emails;

    }

    @Override
    public List<String> getAllIdentityNumber() {
        for(int i=0; i<getAll().size();i++){
            identityNumbers.add(getAll().get(i).getNationalityId());
        }
        return identityNumbers;
    }

    private boolean emailIsItUsed(String email){
        if(getAllEmails().contains(email)){
            result = new ErrorResult("email daha önce kullanılmış");
            return false;
        }
        return true;
    }
    private boolean identityNumIsItUsed(String identityNumber){
        if(getAllIdentityNumber().contains(identityNumber)){
            result = new ErrorResult("kimlik numarası daha önce kullanılmış");
            return false;
        }
        return true;
    }
    private Result isAllFieldFilled(JobSeeker jobSeeker){
        if ((jobSeeker.getNationalityId().equals("") || jobSeeker.getDateOfBirth().equals("") || jobSeeker.getFirstName().equals("") || jobSeeker.getLastName().equals(""))) {
            return result = new ErrorResult("Hiç bir alan boş bırakılmamalıdır.");
        }
        return null;
    }
}
