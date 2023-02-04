package DB;

import java.util.*;
public class EmployeeModel {
    private int nv_ID;
    private String nv_Name;
    private String nv_DOB;
    private String nv_Address;
    private int nv_Salary;
    public EmployeeModel() {
    }
    public EmployeeModel(String nv_Name, String nv_DOB,String nv_Address,int nv_ID) {
        this.nv_Name = nv_Name;
        this.nv_DOB = nv_DOB;
        this.nv_Address = nv_Address;
        this.nv_ID = nv_ID;
    }

    EmployeeModel(String nv_Name, String nv_DOB, String nv_Address) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int getNV_ID(){
        return nv_ID;
    }
    public int getNv_Salary(){
        return nv_Salary
    }
    /**
     * @return the nv_Name
     */
    public String getNv_Name() {
        return nv_Name;
    }
    /**
     * @param nv_Name the nv_Name to set
     */
    public void setNv_Name(String nv_Name) {
        this.nv_Name = nv_Name;
    }
    /**
     * @return the nv_DOB
     */
    public String getNv_DOB() {
        return nv_DOB;
    }
    /**
     * @param nv_DOB the nv_DOB to set
     */
    public void setNv_DOB(String nv_DOB) {
        this.nv_DOB = nv_DOB;
    }
    /**
     * @return the nv_ID
     */
    public String getNv_Address() {
        return nv_Address;
    }
    /**
     * @param nv_Address the nv_Address to set
     */
    public void setNv_Address(String nv_Address) {
        this.nv_Address = nv_Address;
    }

    public Object[] toArray(){
        return new Object[]{ nv_ID, nv_Name, nv_DOB, nv_Address};
    }

}
