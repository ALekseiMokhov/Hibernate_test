package dao;

import entity.Address;

import java.util.List;

public interface Address_DAO {
    public void add(Address address);
    public List<Address> getAll();
    public Address getByID(long ID);
    public void update(Address address);
    public void remove(Address address);

}
