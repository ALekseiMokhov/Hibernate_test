package dao;

import entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface Project_DAO {
    public void add(Project project);
    public List<Project> getAll();
    public Project getByID(long ID) throws SQLException;
    public void update(Project project) throws SQLException;
    public void remove(Project project) throws SQLException;
}
