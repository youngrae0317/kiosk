package org.example.lv2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuList = new ArrayList<>();

        menuList.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            // 리스트 별 아이템 출력 (각 햄버거 출력)
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i+1) + ". " + menuList.get(i).getName() +  "   | W " +  menuList.get(i).getPrice() + " | " + menuList.get(i).getDescription());
            }
            System.out.println("0. 종료      | 종료");
            System.out.print("메뉴를 고르세요 : ");

            int select = sc.nextInt();

            if (select == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            } else if (select > 0 && select <= menuList.size()) {
                // 사용자가 선택한 메뉴 가져오기 (단, 리스트는 0부터 시작이므로 select에서 1을 빼야됨.)
                MenuItem selectItem = menuList.get(select-1);
                System.out.println(selectItem.getName() + "을(를) 선택하셨습니다.\n");
            } else {
                throw new IllegalArgumentException("숫자를 잘못 선택 하셨습니다.\n");
            }
        }

    }
}
