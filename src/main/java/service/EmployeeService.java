package service;

import buiseness_logic.SessionUtil;
import dao.Employee_DAO;
import entity.Address;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService extends SessionUtil implements Employee_DAO {
    @Override
    public void add(Employee employee) {
        openTransactionSession();
        Session session = getSession();
        session.save(employee);
        closeTransactionSession();
    }

    @Override
    public List<Employee> getAll() {
        openTransactionSession();
        String sql = "SELECT * FROM EMPLOYEE";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee>employeeList=query.list();
        closeTransactionSession();
        return employeeList;
    }

    @Override
    public Employee getByID(long ID) {
        openTransactionSession();
        String sql =" SELECT * FROM EMPLOYEE WHERE ID =:id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id",ID);
        Employee employee=(Employee) query.getSingleResult();
        closeTransactionSession();
        return employee;
    }

    @Override
    public void update(Employee employee) {
        openTransactionSession();
        Session session=getSession();
        session.update(employee);
        closeTransactionSession();
    }

    @Override
    public void remove(Employee employee) {
        openTransactionSession();
        Session session = getSession();
        session.remove(employee);

    }
}
