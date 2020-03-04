import buiseness_logic.Util;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain
{
    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();


        Address address = new Address();
        address.setCountry("Italy");
        address.setCity("Paduva");
        address.setStreet("piazza nihil");
        address.setPostcode("0");

        Employee employee = new Employee();
        employee.setFirstName("Darth");
        employee.setLastName("Vader");
        employee.setDate(java.sql.Date.valueOf("4861-02-04"));
        employee.setAdress(address);

        Project project = new Project();
        project.setTitle("AbsolutePower");

        Set<Project> projects=new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        List<Employee> listToPrint=employeeService.getAll();
        for (Employee employee1 : listToPrint) {
            System.out.println(employee1);
        }


        Util.shutdown();
        }


}
