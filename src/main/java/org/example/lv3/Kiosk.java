package org.example.lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // MenuItem 리스트 필드 및 입력받을 Scanner 객체
    private final List<MenuItem> menuItems;
    Scanner sc = new Scanner(System.in);

    // 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        while (true) {
            try {
                System.out.println("[ SHAKESHACK MENU ]");
                // 리스트 별 아이템 출력 (각 햄버거 출력)
                for (int i = 0; i < menuItems.size(); i++) {
                    System.out.println((i + 1) + ". " + menuItems.get(i).getName() + "   | W " + menuItems.get(i).getPrice() + " | " + menuItems.get(i).getDescription());
                }
                System.out.println("0. 종료      | 종료");
                System.out.print("메뉴를 고르세요 : ");

                int select = sc.nextInt();

                if (select == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                } else if (select > 0 && select <= menuItems.size()) {
                    // 사용자가 선택한 메뉴 가져오기 (단, 리스트는 0부터 시작이므로 select에서 1을 빼야됨.)
                    MenuItem selectItem = menuItems.get(select - 1);
                    System.out.println(selectItem.getName() + "을(를) 선택하셨습니다.\n");
                } else {
                    throw new IllegalArgumentException("숫자를 잘못 선택 하셨습니다.\n");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
