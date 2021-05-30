package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private List<String> emails=new ArrayList<String>();
    private Result result;
    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public List<Employer> getAll() {
        return this.employerDao.findAll();
    }

    @Override
    public Result add(Employer employer) {
        if(isAllFieldFilled(employer)==null && emailIsItUsed(employer.getEmail()) && isEmailandWebsiteDomainSame(employer)==null) {
            this.employerDao.save(employer);
            return result = new SuccessResult("iş veren eklendi");
        }
        return result;
    }

    @Override
    public List<String> getAllEmails() {
        for(int i=0 ; i <getAll().size();i++){
            emails.add(getAll().get(i).getEmail());
        }
        return emails;
    }
    private boolean emailIsItUsed(String email){
        if(getAllEmails().contains(email)){
            result = new ErrorResult("email daha önce kullanılmış");
            return false;
        }
        return true;
    }


    private Result isAllFieldFilled(Employer employer){
        if(employer.getCompanyName().equals("") || employer.getPhoneNumber().equals("") || employer.getWebSite().equals("") || employer.getEmail().equals("") ||
                employer.getPassword().equals("") )
            return result = new ErrorResult("Tüm Alanlar Dolu Olmalıdır.");
        return null;
    }
    private Result isEmailandWebsiteDomainSame(Employer employer) {
        String email = employer.getEmail();
        String[] emailSplit = email.split("@");
        if(!emailSplit[1].equals(employer.getWebSite()))
            return result = new ErrorResult("E-posta adresinizin domaini web siteniz ile aynı olmalıdır.");
        return null;
    }
}
