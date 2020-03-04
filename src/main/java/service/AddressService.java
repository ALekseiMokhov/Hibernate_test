package service;

import buiseness_logic.SessionUtil;
import dao.Address_DAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressService extends SessionUtil implements Address_DAO {
    @Override
    public void add(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.save(address);
        closeTransactionSession();
    }

    @Override
    public List<Address> getAll() {
        openTransactionSession();
        String sql = "SELECT * FROM ADRESS";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address>addressList=query.list();
        closeTransactionSession();
        return addressList;
    }

    @Override
    public Address getByID(long ID) {
        openTransactionSession();
        String sql =" SELECT * FROM ADRESS WHERE ID =:id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id",ID);
        Address address=(Address)query.getSingleResult();
        closeTransactionSession();
        return address;
    }

    @Override
    public void update(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.update(address);
        closeTransactionSession();

    }

    @Override
    public void remove(Address address) {
        openTransactionSession();
        Session session= getSession();
        session.remove(address);
        closeTransactionSession();

    }
}
