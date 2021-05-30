package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Department;
import java.util.List;

public interface DepartmentService {
    List<Department> getAll();
    Result add(Department department);
}
