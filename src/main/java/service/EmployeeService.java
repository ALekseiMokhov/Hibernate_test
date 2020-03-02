package service;

import buiseness_logic.Util;
import dao.Employee_DAO;
import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Util implements Employee_DAO {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;

    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE(ID,FIRST_NAME,LAST_NAME,BIRTHDAY,ADRESS_ID) VALUES(?,?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,employee.getId());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setDate(4,employee.getDate());
            preparedStatement.setLong(5,employee.getAdressId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement!=null){
                try{preparedStatement.close();
                    connection.close();}
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee>list = new ArrayList<>();
        String sql = "SELECT ID,FIRST_NAME,LAST_NAME,BIRTHDAY,ADRESS_ID FROM EMPLOYEE";
        try {
            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getLong(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setDate(resultSet.getDate(4));
                employee.setAdressId(resultSet.getLong(5));
                list.add(employee);

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
    public Employee getByID(long ID) {
        String sql = "SELECT FIRST_NAME,LAST_NAME,BIRTHDAY,ADRESS_ID FROM EMPLOYEE WHERE ID =?";
        Employee employee = new Employee();
        try{
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employee.setFirstName(resultSet.getString("FIRST_NAME"));
                employee.setLastName(resultSet.getString("LAST_NAME"));
                employee.setDate(resultSet.getDate("BIRTHDAY"));
                employee.setAdressId(resultSet.getLong("ADRESS_ID"));
            }
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
        return employee;
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE EMPLOYEE SET FIRST_NAME =?,LAST_NAME=?,BIRTHDAY=?,ADRESS_ID=? WHERE ID=?";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.setDate(3,employee.getDate());
            preparedStatement.setLong(4,employee.getAdressId());
            preparedStatement.setLong(5,employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Employee employee) {
        String sql = "DELETE FROM EMPLOYEE WHERE ID=?";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,employee.getId());

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
}
