import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employeeList;
    private FileManager fileManager;
    private String filePath = "employee_data.csv";
    private ConsoleUI consoleUI;

    public EmployeeManager() {
        this.employeeList = new ArrayList<>();
        this.fileManager = new FileManager(filePath);
        this.consoleUI = new ConsoleUI();
    }
    
    public void printEmployeeList() {
        consoleUI.printEmployeeList(fileManager.getAllEmployees());
    }

    public void addEmployee() {
        Employee employee = consoleUI.addEmployee();
        employee.setId(fileManager.getLastId() + 1);
        fileManager.saveEmployee(employee);
    }
}
