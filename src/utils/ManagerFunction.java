package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.Student;
import model.Teacher;

public class ManagerFunction {
    public static void main(String[] args) {
        List<Object> peopleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        enterPeopleInformation(peopleList, scanner);

        for (Object person : peopleList) {
            if (person instanceof Student) {
                System.out.println("Student Information: ");
                System.out.println(((Student) person).getStudentID());
                System.out.println(((Student) person).getStudentName());
                System.out.println(((Student) person).getNumberPhone());
                System.out.println(((Student) person).getAddress());
                System.out.println(((Student) person).getBatch());
                System.out.println(((Student) person).getMark1());
                System.out.println(((Student) person).getMark2());
                System.out.println("-----------------------------------");
                Student student = (Student) person;
                System.out.println("Sinh viên: " + student.getStudentName());
                System.out.println("Điểm trung bình: " + student.calculateAverageMark());
                System.out.println();
            } else if (person instanceof Teacher) {
                System.out.println("Teacher Information: ");
                System.out.println(((Teacher) person).getTeacherID());
                System.out.println(((Teacher) person).getTeacherName());
                System.out.println(((Teacher) person).getNumberPhone());
                System.out.println(((Teacher) person).getAddress());
                System.out.println(((Teacher) person).getNumberWorkDay());
                Teacher teacher = (Teacher) person;
                System.out.println("Giảng viên: " + teacher.getTeacherName());
                System.out.println("Lương: " + teacher.calculateSalary() + " VND");
            }
        }
        int choice = 0;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự newline sau khi đọc số

            switch (choice) {
                case 1:
                    enterPeopleInformation(peopleList, scanner);
                    break;
                case 2:
                    sortByNameAndDisplay(peopleList);
                    break;
                case 3:
                    // sắp xếp điểm trung bình theo thứ tự tăng dần của các bạn sinh viên
                    break;
                case 4:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        } while (choice != 4);
    }

    public static void displayMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1. Nhập thông tin người");
        System.out.println("2. Sắp xếp theo tên");
        System.out.println("3. Gọi phương thức khác");
        System.out.println("4. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");

    }

    public static void enterPeopleInformation(List<Object> peopleList, Scanner scanner) {
        int numPeople;

        System.out.print("Nhập số người muốn thêm: ");
        numPeople = scanner.nextInt();

        for (int i = 0; i < numPeople; i++) {
            System.out.println("Nhập thông tin người thứ " + (i + 1) + ":");
            System.out.print("Loại người (1: Student, 2: Teacher): ");
            int personType = scanner.nextInt();
            scanner.nextLine();

            if (personType == 1) {
                Student student = new Student();
                System.out.print("Nhập studentID: ");
                student.setStudentID(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Nhập studentName: ");
                student.setStudentName(scanner.nextLine());

                System.out.print("Nhập numberPhone: ");
                student.setNumberPhone(scanner.nextLine());

                System.out.print("Nhập address: ");
                student.setAddress(scanner.nextLine());

                System.out.print("Nhập Batch: ");
                student.setBatch(scanner.nextLine());

                System.out.print("Nhập Mark1: ");
                student.setMark1(scanner.nextDouble());

                System.out.print("Nhập Mark2: ");
                student.setMark2(scanner.nextDouble());

                peopleList.add(student);
            } else if (personType == 2) {
                Teacher teacher = new Teacher();
                System.out.print("Nhập teacherId: ");
                teacher.setTeacherID(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Nhập teacherName: ");
                teacher.setTeacherName(scanner.nextLine());

                System.out.print("Nhập numberPhone: ");
                teacher.setNumberPhone(scanner.nextLine());

                System.out.print("Nhập address: ");
                teacher.setAddress(scanner.nextLine());

                System.out.print("Nhập numberWorkDay: ");
                teacher.setNumberWorkDay(scanner.nextInt());

                peopleList.add(teacher);
            }
        }
    }

    // Viết phương thức sắp xếp điểm trung bình theo thứ tự tăng dần của các bạn
    // sinh viên
    public static void sortStudentsByAverageMark(List<Object> peopleList) {
        Collections.sort(peopleList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    Student s1 = (Student) o1;
                    Student s2 = (Student) o2;
                    double averageMark1 = s1.calculateAverageMark();
                    double averageMark2 = s2.calculateAverageMark();
                    return Double.compare(averageMark1, averageMark2);
                }
                return 0;
            }
        });
    }

    // Viết phương thức sắp xếp theo tên (Aphabetical) ABC
    public static void sortByNameAndDisplay(List<Object> peopleList) {
        Collections.sort(peopleList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                String name1 = "";
                String name2 = "";
                if (o1 instanceof Teacher) {
                    Teacher teacher = (Teacher) o1;
                    name1 = teacher.getTeacherName();
                } else if (o1 instanceof Student) {
                    Student student = (Student) o1;
                    name1 = student.getStudentName();
                }
                if (o2 instanceof Teacher) {
                    Teacher teacher = (Teacher) o2;
                    name2 = teacher.getTeacherName();
                } else if (o2 instanceof Student) {
                    Student student = (Student) o2;
                    name2 = student.getStudentName();
                }
                return name1.compareToIgnoreCase(name2);
            }
        });
    }

    public static void displayPeopleList(List<Object> peopleList) {
        System.out.println("Danh sách người:");
        for (Object person : peopleList) {
            if (person instanceof Teacher) {
                Teacher teacher = (Teacher) person;
                System.out.println("Giảng viên: " + teacher.getTeacherName());
            } else if (person instanceof Student) {
                Student student = (Student) person;
                System.out.println("Sinh viên: " + student.getStudentName());
            }
        }
    }
}