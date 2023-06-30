package model;

public class Student {
    private int studentID;
    private String studentName;
    private String numberPhone;
    private String address;
    private String batch;
    private double mark1;
    private double mark2;

    public Student() {
    }

    public Student(int studentID, String studentName, String numberPhone, String address, String batch, double mark1,
            double mark2) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.numberPhone = numberPhone;
        this.address = address;
        this.batch = batch;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }


    // Phương thức tính điểm trung bình và trả về điểm trung bình của sinh viên
    public double calculateAverageMark() {
        double avgMark = (mark1 + mark2) / 2;
        return avgMark;
    }


}
