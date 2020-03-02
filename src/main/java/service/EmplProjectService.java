package service;

import buiseness_logic.Util;
import dao.Empl_Project_DAO;
import entity.EmplProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmplProjectService extends Util implements Empl_Project_DAO {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    @Override
    public void add(EmplProject emplProject) {
        String sql ="INSERT INTO EMPL_PROJECT(ID,EMPLOYEE_ID,PROJECT_ID)VALUES(?,?,?)";
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setLong(1,emplProject.getID());
            preparedStatement.setLong(2,emplProject.getEmployeeId());
            preparedStatement.setLong(3,emplProject.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public List<EmplProject> getAll() {
        List<EmplProject>list = new ArrayList<>();
        String sql = " SELECT EMPLOYEE_ID,PROJECT_ID FROM EMPL_PROJECT WHERE ID =?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                EmplProject emplProject = new EmplProject();
                emplProject.setEmployeeId(resultSet.getLong(1));
                emplProject.setProjectId(resultSet.getLong(2));
                list.add(emplProject);
            }
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
        return list;
    }

    @Override
    public EmplProject getByID(long employeeID, long projectID) {
        EmplProject emplProject = new EmplProject();
        String sql = "SELECT ID FROM EMPL_PROJECT WHERE EMPLOYEE_ID=? AND PROJECT_ID=? ";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,employeeID);
            preparedStatement.setLong(2,projectID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                emplProject.setID(resultSet.getLong("ID"));
            }
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

        return emplProject;
    }

    @Override
    public void update(EmplProject emplProject) {
        String sql = "UPDATE EMPL_PROJECT SET EMPLOYEE_ID=?, PROJECT_ID=? WHERE ID=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,emplProject.getEmployeeId());
            preparedStatement.setLong(2,emplProject.getProjectId());
            preparedStatement.setLong(3,emplProject.getID());
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
    public void remove(EmplProject emplProject) {
        String sql =" DELETE FROM EMPL_PROJECT WHERE ID=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,emplProject.getID());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
