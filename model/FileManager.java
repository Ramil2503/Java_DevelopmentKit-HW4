package model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private String filePath;
    
    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveEmployee(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(employee.getId() + "," + employee.getPhoneNumber() + ","
                    + employee.getName() + "," + employee.getYearsOfExperience());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");                
                int id = Integer.parseInt(data[0]);
                String phoneNumber = data[1];
                String name = data[2];
                int yearsOfExperience = Integer.parseInt(data[3]);
                Employee employee = new Employee(id, phoneNumber, name, yearsOfExperience);
                employeeList.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public int getLastId() {
        int id = -1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                id = Integer.parseInt(data[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id;
    }
}
