package DB;
import DB.DBconnect;
import DB.EmployeeModel;

import java.sql.*;
import java.util.*;
public class EDMimple implements EDM {
    private DBconnect dbconnect = new DBconnect();
    private static final String SHOW_ALL_EMPLOYEE = "select * from nhanvien where delete_employee != 1";
    private static final String SHOW_EMPLOYEE = "select * from where delete_employee !=1 and nv_ID = ?";
    private static final String ADD_EMPLOYEE = "insert into nhanvien (nv_Name, nv_DOB, nv_Address) values (?,?,?)";
    private static final String DELETE_EMPLOYEE = "update nhanvien set delete_employee where nv_ID = ? ";
    private static final String EDIT_EMPLOYEE = "update nhanvien set nv_Name = ?, nv_DOB = ?, nv_Address = ? where nv_ID = ?";
    private static final String JOIN_EMPLOYEE = "inset into thamgia (nv_ID,da_ID,tienluong) values (?,?,?)";
    public ArrayList<EmployeeModel> findall(){
        ArrayList<EmployeeModel> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedstatement = this.dbconnect.getConnection().prepareStatement(SHOW_ALL_EMPLOYEE);
            ResultSet resultSet = preparedstatement.executeQuery();
            EmployeeModel employee;
            while(resultSet.next()) {
                employee = new EmployeeModel();
                employee.setNv_Name(resultSet.getString("nv_Name"));
                employee.setNv_DOB(resultSet.getString("nv_DOB"));
                employee.setNv_Address(resultSet.getString("nv_Address"));

                employeeList.add(employee);
            }
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public EmployeeModel findEmployee (int id) {
        EmployeeModel employee = new EmployeeModel();
        try {
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(SHOW_EMPLOYEE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                employee.setNv_Name(resultSet.getString("nv_Name"));
                employee.setNv_DOB(resultSet.getString("nv_DOB"));
                employee.setNv_Address(resultSet.getString("nv_Address"));
            }
            resultSet.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void save (EmployeeModel employee){
        try {
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(ADD_EMPLOYEE);
            preparedStatement.setString(1,employee.getNv_Name());
            preparedStatement.setString(2,employee.getNv_DOB());
            preparedStatement.setString(3,employee.getNv_Address());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(EmployeeModel employee) {
        try {
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(EDIT_EMPLOYEE);
            preparedStatement.setString(1,employee.getNv_Name());
            preparedStatement.setString(2,employee.getNv_DOB());
            preparedStatement.setString(3,employee.getNv_Address());
            preparedStatement.setInt(4,employee.getNV_ID());

            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int id){
        try{
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void savej(int nid, int id, int luong){
        try{
            EmployeeModel employee = new EmployeeModel();
            ProjectModel project = new ProjectModel();
            PreparedStatement preparedStatement = this.dbconnect.getConnection().prepareStatement(JOIN_EMPLOYEE);
            preparedStatement.setInt(1,employee.getNV_ID());
            preparedStatement.setInt(2,project.getDa_ID());
            preparedStatement.setInt(3,employee.getNv_Salary());
            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
