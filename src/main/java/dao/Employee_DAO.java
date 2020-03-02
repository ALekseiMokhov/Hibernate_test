package dao;

import entity.Employee;
import entity.Employee;

import java.util.List;

public interface Employee_DAO {
    public void add(Employee employee);
    public List<Employee> getAll();
    public Employee getByID(long ID);
    public void update(Employee employee);
    public void remove(Employee adress);
}

