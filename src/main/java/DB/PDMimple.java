package DB;
import DB.DBconnect;
import DB.ProjectModel;

import java.sql.*;
import java.util.*;
public class PDMimple implements PDM {
    private DBconnect dbconnect = new DBconnect();
    private static final String SHOW_ALL_PROJECT = "select * from duan where delete_employee != 1";
    private static final String SHOW_PROJECT = "select * from duan where delete_employee!= 1 and nv_ID = ?";
    private static final String ADD_PROJECT = "insert into duan (da_Name, da_DOS) values (?,?)";
    private static final String DELETE_PROJECT = "update duan set delete_employee where nv_ID = ? ";
    private static final String EDIT_PROJECT = "update nhanvien set da_Name = ?, da_DOS = ? where da_ID = ?";

    public ArrayList<ProjectModel> findall(){
        ArrayList<ProjectModel> projectList = new ArrayList<>();
        try {
            PreparedStatement preparedstatement = this.dbconnect.getConnection().prepareStatement(SHOW_ALL_PROJECT);
            ResultSet resultSet = preparedstatement.executeQuery();
            ProjectModel project;
            while(resultSet.next()) {
                project = new ProjectModel();
                project.setDa_Name(resultSet.getString("da_Name"));
                project.setDa_DOS(resultSet.getString("da_DOS"));

                projectList.add(project);
            }
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    public ProjectModel findProject (int id) {
        ProjectModel project = new ProjectModel();
        try {
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(SHOW_PROJECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                project.setDa_Name(resultSet.getString("da_Name"));
                project.setDa_DOS(resultSet.getString("da_DOS"));
            }
            resultSet.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    public void save (ProjectModel project){
        try {
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(ADD_PROJECT);
            preparedStatement.setString(1,project.getDa_Name());
            preparedStatement.setString(2,project.getDa_DOS());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ProjectModel project) {
        try {
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(EDIT_PROJECT);
            preparedStatement.setString(1,project.getDa_Name());
            preparedStatement.setString(2,project.getDa_DOS());
            preparedStatement.setInt(3,project.getDa_ID());
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try{
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(DELETE_PROJECT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

}
