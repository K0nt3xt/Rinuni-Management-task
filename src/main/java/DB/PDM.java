package DB;
import java.util.*;
public interface PDM {
    ArrayList<ProjectModel> findall();
    ProjectModel findProject(int id);
    void save(ProjectModel project);
    void update(ProjectModel project);
    void delete(int id);
}

