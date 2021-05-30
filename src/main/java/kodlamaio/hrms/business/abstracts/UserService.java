package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.abstracts.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Result add(User user);
}
