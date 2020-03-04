package service;

import buiseness_logic.SessionUtil;
import dao.Project_DAO;
import entity.Address;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ProjectService extends SessionUtil implements Project_DAO {
    @Override
    public void add(Project project) {
        openTransactionSession();
        Session session = getSession();
        session.save(project);
        closeTransactionSession();
    }

    @Override
    public List<Project> getAll() {
        openTransactionSession();
        String sql =" SELECT * FROM PROJECT";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        Project project=(Project)query.getSingleResult();
        List<Project>projectList = query.list();
        closeTransactionSession();
        return projectList;
    }

    @Override
    public Project getByID(long ID) throws SQLException {
        openTransactionSession();
        String sql =" SELECT * FROM PROJECT WHERE ID =:id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("id",ID);
        Project project=(Project)query.getSingleResult();
        closeTransactionSession();
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(project);
        closeTransactionSession();
    }

    @Override
    public void remove(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(project);
        closeTransactionSession();
    }
}
