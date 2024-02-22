import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;

    private int id;
    private String phoneNumber;
    private String name;
    private int yearsOfExperience;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public void print(String text) {
        System.out.println(text);
    }

    public void printEmployeeList(List<Employee> employeeList) {
        print("");
        print("------------------------EMPLOYEE LIST------------------------");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        print("");
    }

    public Employee addEmployee() {
        print("ADDING NEW EMPLOYEE");
        print("Enter the name of the employee: ");
        name = scanner.nextLine();
        print("Enter the phone number: ");
        phoneNumber = scanner.nextLine();
        print("Enter years of experience he/she have: ");
        yearsOfExperience = scanner.nextInt();
        return new Employee(id, phoneNumber, name, yearsOfExperience);
    }
}
