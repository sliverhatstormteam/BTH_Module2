package View;

import Manager.StudenManager;

import java.util.Scanner;

public class Menu {
    StudenManager studenManager = new StudenManager();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        int choice;
        do {
            String menu = """
                    ---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----
                    Chọn chức năng theo số (để tiếp tục)
                    1. Xem danh sách sinh viên
                    2. Thêm mới
                    3. Cập nhật
                    4. Xóa
                    5. Sắp xếp
                    6. Đọc từ file
                    7. Ghi vào file
                    8. Thoát     
                    Chọn chức năng:
                    """;
            System.out.println(menu);
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Lựa chọn phải là số:");
                }
            }


            switch (choice) {
                case 1 -> studenManager.show();
                case 2 -> studenManager.add();
                case 3 -> studenManager.edit();
                case 4 -> studenManager.delete();
                case 5 -> studenManager.sort();
                case 6 -> studenManager.ReadFromFile();
                case 7 -> studenManager.WriteToFile();
                case 8 -> System.exit(0);
                default -> System.out.println("Không có chức năng này");
            }
        } while (true);
    }
}
