import java.util.List;

public class EmployeeManager {
    private List<Employee> employeeList;
    private FileManager fileManager;
    private String filePath = "employee_data.csv";
    private ConsoleUI consoleUI;

    public EmployeeManager() {
        this.fileManager = new FileManager(filePath);
        this.consoleUI = new ConsoleUI();
        this.employeeList = fileManager.getAllEmployees();

    }

    public Employee findById(int id) {
        Employee resultEmployee = employeeList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        System.out.println(resultEmployee);
        return resultEmployee;
    }

    public List<String> findPhoneNumber(String name) {
        List<String> result = employeeList.stream().filter(e -> e.getName().equals(name)).map(Employee::getPhoneNumber).toList();
        System.out.println(result);
        return result;
    }

    public List<Employee> findByYearsOfExperience(int yearsOfExperience) {
        employeeList = employeeList.stream().filter(e -> e.getYearsOfExperience() == yearsOfExperience).toList();
        printEmployeeList(employeeList);
        return employeeList;
    }
    
    public void printEmployeeList() {
        consoleUI.printEmployeeList(fileManager.getAllEmployees());
    }

    public void printEmployeeList(List<Employee> employees) {
        consoleUI.printEmployeeList(employees);
    }

    public void addEmployee() {
        Employee employee = consoleUI.addEmployee();
        employee.setId(fileManager.getLastId() + 1);
        fileManager.saveEmployee(employee);
    }
}
