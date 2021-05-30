package kodlamaio.hrms.core.utilities.EmailServices.concretes;

import kodlamaio.hrms.core.utilities.EmailServices.abstracts.EmailCheckService;

public class EmailCheckManager implements EmailCheckService {

    @Override
    public boolean emailCheck(String email) {
       return true;
    }
}
