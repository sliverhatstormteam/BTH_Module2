package Manager;

import model.Student;
import readwriteFile.ReadWrite;

import java.util.ArrayList;
import java.util.Scanner;

public class StudenManager {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Student> students = new ArrayList<Student>();
    public final String YNCHECK = "[NY]";
    ReadWrite readWrite = new ReadWrite();


    public Student createStudent() {

        System.out.println("Nhập mã sinh viên: ");
        String id = scanner.nextLine();

        System.out.println("Nhập tên sinh viên: ");
        String name = scanner.nextLine();

        System.out.println("Nhập tuổi sinh viên: ");
        int age = 0;
        do {
            while (true) {
                try {
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.err.println("Nhập số!");
                }
            }

            if (age < 0) {
                System.out.println("GPA phải lớn hơn 0");
            }
        } while (age <= 0);
        String gender = "";
        do {
            System.out.println("Nhập giới tính sinh viên: ");
            gender = scanner.nextLine();
        } while (!gender.equals("NAM") && !gender.equals("NU") && !gender.equals("nam") && !gender.equals("nu") && !gender.equals("Nam") && !gender.equals("Nu"));

        System.out.println("Nhập địa chỉ sinh viên: ");
        String address = scanner.nextLine();

        System.out.println("Nhập điểm trung bình sinh viên sinh viên: ");
        double GPA = 0;
        do {
            while (true) {
                try {
                    GPA = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.err.println("Nhập số!");
                }
            }

            if (GPA < 0) {
                System.out.println("GPA phải lớn hơn 0");
            }
        } while (GPA <= 0);
        Student newStudent = new Student(id, name, age, gender, address, GPA);
        System.out.println(newStudent);
        return newStudent;
    }

    public String checkString(String regex) {
        while (true) {
            String string = scanner.nextLine();
            if (string.matches(regex)) {
                return string;
            }
            System.err.println("Sai định dạng, vui lòng nhập lại.");
        }
    }

    public void show() {
        int dem=0;
        System.out.println("-----------------------------------------------Danh sách học sinh-----------------------------------------------");
        System.out.printf("| %-25s| %-15s| %-15s| %-15s| %-15s| %-15s", "Mã học sinh", "Tên", "Tuổi", "Giới tính", "Địa chỉ", "Điểm trung bình");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < students.size(); i++) {
            if (dem%5==0&&dem!=0){
                System.out.println("Ấn enter để tiếp tục");
                scanner.nextLine();
            }
            System.out.printf("| %-25s| %-15s| %-15s| %-15s| %-15s| %-15s", students.get(i).getID(), students.get(i).getName(), students.get(i).getAge(), students.get(i).getGender(), students.get(i).getAddress(), students.get(i).getGPA());
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            dem++;

        }
        if (students.size() <= 0) {
            System.out.println("Danh sách trống");
        }
        System.out.println("Enter để tiếp tục");
        scanner.nextLine();

    }

    public void add() {
        Student newStudent = createStudent();
        students.add(newStudent);
    }

    public void edit() {
        System.out.println("Nhập mã sinh viên bạn muốn sửa: ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID().equals(id)) {
                students.set(i, createStudent());
            }
        }
    }

    public void delete() {
        System.out.println("Nhập mã sinh viên bạn muốn xóa:  ");
        String code = scanner.nextLine();
        System.out.println("Bạn có chắc sẽ xóa sinh viên (yes:Y  no:N): ");
        String choice = checkString(YNCHECK);
        if (choice.equals("Y")) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getID().equalsIgnoreCase(code)) {
                    students.remove(i);
                    System.out.println("Xóa thành công");
                    break;
                }
            }
            System.out.println("Không tìm thấy sinh viên này");
        } else {
            System.out.println("Hủy bỏ xóa!");
        }
    }

    public void sort() {
        int choose = 3;
        System.out.println("-------------Sắp xếp sinh viên theo điểm trung bình------------------");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần.");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần.");
        System.out.println("3. Thoát.");
        System.out.println("Chọn chứuc năng: ");
        do {
            if (choose != 1 && choose != 2 && choose != 3) System.out.println("Nhập 1 trong số các chức năng");
            while (true) {
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                    break;
                }catch (NumberFormatException e1){
                    System.out.println("Nhập số!");
                }
            }
        } while (choose != 1 && choose != 2 && choose != 3);

        switch (choose) {
            case 1 -> ascSort();
            case 2 -> decSort();
            case 3 -> System.out.println("Thoát");
        }
    }

    public void ascSort() {
        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getGPA() > students.get(j).getGPA()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        show();

    }

    public void decSort() {

        Student temp;
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).getGPA() < students.get(j).getGPA()) {
                    temp = students.get(i);
                    students.set(i, students.get(j));
                    students.set(j, temp);
                }
            }
        }
        show();
    }
    public void ReadFromFile() {
        System.out.println("Đọc từ File sẽ mất dữ liệu hiện tại, tiếp tục?(yes:Y  no:N) : ");
        String choice = checkString(YNCHECK);
        if (choice.equals("Y")) {
            students = readWrite.read();
            System.out.println("Đọc file thành công");
        }
    }
    public void WriteToFile() {
        System.out.println("Ghi vào File sẽ mất dữ liệu đang lưu, tiếp tục?(yes:Y  no:N): ");
        String choice = checkString(YNCHECK);
        if (choice.equals("Y")) {
            readWrite.write(students);
            System.out.println("Ghi file thành công");
        }
    }

}
