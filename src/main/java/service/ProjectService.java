package service;

import buiseness_logic.Util;
import dao.Project_DAO;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService extends Util implements Project_DAO {
    Connection connection=getConnection();
    PreparedStatement preparedStatement = null;
    @Override
    public void add(Project project) {
        String sql="INSERT INTO PROJECT(ID,TITLE) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,project.getId());
            preparedStatement.setString(2,project.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Project> getAll() {
        List<Project>list=new ArrayList<>();
        String sql ="SELECT ID, TITLE FROM PROJECT";
        try{
            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Project project=new Project();
                project.setId(resultSet.getLong(1));
                project.setTitle(resultSet.getString(2));
                list.add(project);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Project getByID(long ID) throws SQLException {
        Project project = new Project();
        String sql = "SELECT TITLE FROM PROJECT WHERE ID = ?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setLong(1,ID);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())project.setTitle(resultSet.getString("TITLE"));
        if(connection!=null)connection.close();
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        String sql = "UPDATE PROJECT SET TITLE =? WHERE ID=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,project.getTitle());
        preparedStatement.setLong(2,project.getId());
        preparedStatement.executeUpdate();
        if(connection!=null)connection.close();

    }

    @Override
    public void remove(Project project) throws SQLException {
        String sql = " DELETE FROM PROJECT WHERE ID =?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setLong(1,project.getId());
        preparedStatement.executeUpdate();
        if(connection!=null)connection.close();

    }
}
