package service;

import buiseness_logic.Util;
import dao.Address_DAO;
import entity.Address;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements Address_DAO {
    Connection connection = getConnection();
    PreparedStatement preparedStatement = null;
    @Override
    public void add(Address address) {

        String sql = "INSERT INTO ADRESS(ID,COUNTRY,CITY,STREET,POST_CODE) VALUES(?,?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostcode());

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
    public List<Address> getAll() {
        List<Address> addressList = new ArrayList<>();
        String sql = "SELECT ID,COUNTRY,CITY,STREET,POST_CODE FROM ADRESS";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultset =preparedStatement.executeQuery();
            System.out.println(resultset==null);
            while(resultset.next()){
                Address address = new Address();
                address.setId(resultset.getLong("ID"));
                address.setCountry(resultset.getString("COUNTRY"));
                address.setCity(resultset.getString("CITY"));
                address.setStreet(resultset.getString("STREET"));
                address.setPostcode(resultset.getString("POST_CODE"));
                addressList.add(address);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(preparedStatement!=null){
                try{preparedStatement.close();
                   } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
             if(connection!=null){
                 try{connection.close();} catch (SQLException e) {
                     e.printStackTrace();
                 }
             }

            }

        return addressList;
    }

    @Override
    public Address getByID(long ID) {
        Address address = null;
        String sql = "SELECT ID, COUNTY,CITY, STREET,POST_CODE FROM ADRESS WHERE ID = ?";
             try{preparedStatement=connection.prepareStatement(sql);
                 preparedStatement.setLong(1,ID);
                 address = new Address();
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    address.setId(resultSet.getLong("ID"));
                    address.setCountry(resultSet.getString("COUNTRY"));
                    address.setCity(resultSet.getString("CITY"));
                    address.setStreet(resultSet.getString("STREET"));
                    address.setPostcode(resultSet.getString("POST_CODE"));
                }
             }
            catch (SQLException e) {
            e.printStackTrace();
        }
             finally {
                 try {
                     preparedStatement.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
                 try {
                     connection.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }

        return address;
    }

    @Override
    public void update(Address address) {
        String sql = "UPDATE ADRESS SET COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID =?";
       try {
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setLong(5, address.getId());
           preparedStatement.setString(1, address.getCountry());
           preparedStatement.setString(2, address.getCity());
           preparedStatement.setString(3, address.getStreet());
           preparedStatement.setString(4, address.getPostcode());
           preparedStatement.executeUpdate();
       }
       catch (SQLException e) {
           e.printStackTrace();
       }

    }

    @Override
    public void remove(Address address) {
        String sql = "DELETE FROM ADRESS WHERE ID = ?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, address.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
