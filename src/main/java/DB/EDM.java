package DB;

import java.util.*;
public interface EDM {
    ArrayList<EmployeeModel> findall();
    EmployeeModel findEmployee(int id);
    void save(EmployeeModel employee);
    void update(EmployeeModel employee);
    void delete(int id);
}
