package dao;

import entity.EmplProject;

import java.util.List;

public interface Empl_Project_DAO {
    public void add(EmplProject emplProject);
    public List<EmplProject> getAll();
    public EmplProject getByID(long EmployeeID,long projectID);
    public void update(EmplProject emplProject);
    public void remove(EmplProject emplProject);
}
