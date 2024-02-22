package model;
public class Employee {
    private int id;
    private String phoneNumber;
    private String name;
    private int yearsOfExperience;

    public Employee(int id, String phoneNumber, String name, int yearsOfExperience) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", phoneNumber=" + phoneNumber + ", name=" + name + ", yearsOfExperience="
                + yearsOfExperience + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
