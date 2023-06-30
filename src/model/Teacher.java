package model;

/**
 * Teacher
 */
public class Teacher {
    private int teacherID;
    private String teacherName;
    private String numberPhone;
    private String address;
    private double salary;
    private int numberWorkDay;

    public Teacher() {
    }

    public Teacher(int teacherID, String teacherName, String numberPhone, String address, double salary,
            int numberWorkDay) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.numberPhone = numberPhone;
        this.address = address;
        this.salary = salary;
        this.numberWorkDay = numberWorkDay;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getNumberWorkDay() {
        return numberWorkDay;
    }

    public void setNumberWorkDay(int numberWorkDay) {
        this.numberWorkDay = numberWorkDay;
    }

    public double calculateSalary() {
        double salary = numberWorkDay * 800000;
        return salary;
    }
}