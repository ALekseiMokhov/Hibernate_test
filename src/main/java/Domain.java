import buiseness_logic.Util;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import java.util.HashSet;
import java.util.Set;

public class Domain
{
    public static void main(String[] args) {
        Session session = (Session) Util.getSessionFactory().openSession();
        session.beginTransaction();

        Address address = new Address();
        address.setCountry("Tatuin");
        address.setCity("MoonCity");
        address.setStreet("NoNameStreet");
        address.setPostcode("000");

        Employee employee = new Employee();
        employee.setFirstName("c3pO");
        employee.setLastName("Skywalker");
        employee.setDate(java.sql.Date.valueOf("3546-03-17"));
        employee.setAdress(address);

        Project project = new Project();
        project.setTitle("Translation");

        Set<Project> projects=new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        session.save(address);
        session.save(employee);
        session.save(project);

        session.getTransaction().commit();
        Util.shutdown();


        }


}
