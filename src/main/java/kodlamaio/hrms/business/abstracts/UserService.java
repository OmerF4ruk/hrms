package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    Result add(User user);
}
