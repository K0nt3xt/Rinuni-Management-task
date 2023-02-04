package DB;

import java.util.*;
public class ProjectModel {
    private String da_Name;
    private String da_DOS;//date of start
    private int da_ID;
    public ProjectModel(String da_Name, String da_DOS,int da_ID) {
        this.da_Name = da_Name;
        this.da_DOS = da_DOS;
    }
    public ProjectModel() {
        // TODO Auto-generated constructor stub
    }

    ProjectModel(String da_Name, String da_DOS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int getDa_ID(){
        return da_ID;
    }
    /**
     * @return the da_ID
     */
    public String getDa_Name() {
        return da_Name;
    }
    /**
     * @param da_Name the da_Name to set
     */
    public void setDa_Name(String da_Name) {
        this.da_Name = da_Name;
    }
    /**
     * @return the da_DOS
     */
    public String getDa_DOS() {
        return da_DOS;
    }
    /**
     * @param da_DOS the da_DOS to set
     */
    public void setDa_DOS(String da_DOS) {
        this.da_DOS = da_DOS;
    }
}
