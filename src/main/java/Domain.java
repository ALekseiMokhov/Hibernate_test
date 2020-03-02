import entity.Address;
import entity.EmplProject;
import entity.Employee;
import entity.Project;
import service.AddressService;
import service.EmplProjectService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.SQLException;
import java.util.List;

public class Domain
{
    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjectService emplProjectService = new EmplProjectService();

        List<Address> addressList=addressService.getAll();
        System.out.println(addressList.size());
        for (Address address : addressList) {
            System.out.println(address);

        }List<Employee> employeeList=employeeService.getAll();
        System.out.println(employeeList.size());
        for (Employee employee : employeeList) {
            System.out.println(employee);

        }

    }
}
