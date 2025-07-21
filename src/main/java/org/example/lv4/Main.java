package org.example.lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 버거 메뉴 아이템 리스트 생성 및 추가
        List<MenuItem> burgerItems = new ArrayList<>();
        burgerItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        // 드링크 메뉴 아이템 리스트 생성 및 추가
        List<MenuItem> drinkItems = new ArrayList<>();
        drinkItems.add(new MenuItem("콜라", 1.8, "일반 코카콜라"));
        drinkItems.add(new MenuItem("제로콜라", 1.8, "제로 코카콜라"));
        drinkItems.add(new MenuItem("사이다", 6.9, "사이다"));
        drinkItems.add(new MenuItem("환타(파인)", 5.4, "파인애플맛 환타"));

        // 메뉴 객체 생성
        Menu burgerMenu = new Menu("Burgers", burgerItems);
        Menu drinkMenu = new Menu("Drinks", drinkItems);

        // 메뉴 리스트 만들기
        List<Menu> menuList = new ArrayList<>();
        menuList.add(burgerMenu);
        menuList.add(drinkMenu);


        // Kiosk 객체 생성 후 menuItems의 값들을 넘겨주고 start() 메서드 실행
        Kiosk k1 = new Kiosk(menuList);
        k1.start();

    }
}
