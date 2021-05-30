package kodlamaio.hrms.core.utilities.EmailServices.concretes;

import kodlamaio.hrms.core.utilities.EmailServices.abstracts.EmailCheckService;
import org.springframework.stereotype.Service;

@Service
public class FakeEmailCheckManager implements EmailCheckService {

    @Override
    public boolean emailCheck(String email){
        return true;
    }
}
