package org.example.lv4;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Kiosk {
    // MenuItem 리스트 필드 및 입력받을 Scanner 객체
    private final List<Menu> menus;
    Scanner sc = new Scanner(System.in);

    // 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }


    public void start() {
        // 반복문
        while (true) {
            try {
                System.out.println("[ MAIN MENU ]");
                // 리스트 별 아이템 출력 (각 메뉴 출력)
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getName());
                }
                System.out.println("0. 종료      | 종료");
                System.out.print("메뉴를 고르세요 : ");

                // 메뉴 입력받기
                int menuselect = sc.nextInt();

                // 메뉴 로직
                if (menuselect == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                } else if (menuselect > 0 && menuselect <= menus.size()) {
                    // 사용자가 선택한 메뉴 가져오기 (단, 리스트는 0부터 시작이므로 select에서 1을 빼야됨.)
                    Menu selectedMenu = this.menus.get(menuselect - 1);
                    List<MenuItem> menuItems = selectedMenu.getMenuItems();

                    // 헤더 출력하기
                    System.out.println("\n[ " + selectedMenu.getName().toUpperCase() + " MENU ] ");

                    // 선택한 메뉴의 아이템 출력하기
                    for (int i = 0; i < selectedMenu.getMenuItems().size(); i++) {
                        System.out.println((i + 1) + ". " + menuItems.get(i).getName() + "   | W " + menuItems.get(i).getPrice() + " | " + menuItems.get(i).getDescription());
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.print("메뉴를 고르세요 : ");

                    int selectedMenuItem =  sc.nextInt();
                    if (selectedMenuItem == 0) {
                        continue;
                    } else if (selectedMenuItem > 0 && selectedMenuItem <= menuItems.size()) {
                        MenuItem selectedItem = menuItems.get(selectedMenuItem - 1);
                        System.out.println("선택한 메뉴: " + selectedItem.getName() + "   | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription() + "\n");
                    } else {
                        throw new IllegalArgumentException("숫자를 잘못 선택 하셨습니다.\n");
                    }
                } else {
                    throw new IllegalArgumentException("숫자를 잘못 선택 하셨습니다.\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력하세요 !! \n");
                sc.next();
            }
        }
    }
}
