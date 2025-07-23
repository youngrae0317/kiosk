package org.example.c_lv2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    // MenuItem 리스트 필드 및 입력받을 Scanner 객체와 장바구니 객체
    private final List<Menu> menus;
    private Scanner sc = new Scanner(System.in);
    private final Order cart = new Order();

    // 생성자
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }


    public void start() {
        // 반복문
        while (true) {
            try {
                System.out.println("\n[ MAIN MENU ]");
                // 리스트 별 아이템 출력 (각 메뉴 출력)
                for (int i = 0; i < menus.size(); i++) {
                    System.out.println((i + 1) + ". " + menus.get(i).getName());
                }
                System.out.println("0. 종료      | 종료");

                // 장바구니가 비어있지 않을 때, 즉 장바구니 리스트에 아이템이 있을 경우 출력
                if (!this.cart.isEmpty()) {
                    System.out.println("\n[ ORDER MENU ]");
                    System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                    System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
                } else {
                    System.out.print("메뉴를 고르세요 : ");
                }


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

                    // 서브 메뉴를 위한 새로운 반복문
                    while (true) {
                        try { // 서브 메뉴의 내부 try-catch
                            // 헤더 출력하기
                            System.out.println("\n[ " + selectedMenu.getName().toUpperCase() + " MENU ] ");

                            // 선택한 메뉴의 아이템 출력하기
                            for (int i = 0; i < selectedMenu.getMenuItems().size(); i++) {
                                System.out.println((i + 1) + ". " + menuItems.get(i).getName() + "   | W " + menuItems.get(i).getPrice() + " | " + menuItems.get(i).getDescription());
                            }
                            System.out.println("0. 뒤로가기");
                            System.out.print("메뉴를 고르세요 : ");

                            int selectedMenuItem = sc.nextInt();
                            if (selectedMenuItem == 0) {
                                break; // 내부 루프를 탈출해야 하므로 continue가 아닌 break 사용
                            } else if (selectedMenuItem > 0 && selectedMenuItem <= menuItems.size()) {
                                MenuItem selectedItem = menuItems.get(selectedMenuItem - 1);
                                System.out.println("선택한 메뉴: " + selectedItem.getName() + "   | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
                                // 장바구니 기능
                                System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인        2. 취소");
                                int orderAdd = sc.nextInt();
                                if (orderAdd == 1) {
                                    this.cart.addItem(selectedItem);
                                    System.out.println("\n" + selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.");
                                } else if (orderAdd == 2) {
                                    continue;
                                }

                            } else {
                                throw new IllegalArgumentException("숫자를 잘못 선택 하셨습니다.");
                            }
                        } catch (IllegalArgumentException e) { // 서브 메뉴의 예외 처리 (숫자 범위 초과)
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) { // 숫자가 아닌 다른 문자 입력 시 예외 처리
                            System.out.println("숫자로 입력하세요 !! ");
                            sc.next(); // 버퍼 비우기
                        }
                    }
                } else if (menuselect == 4 && !this.cart.isEmpty()) {
                    System.out.println("\n아래와 같이 주문 하시겠습니까?\n");

                    // 주문 목록 출력
                    System.out.println("[ Orders ]");
                    for (int i = 0; i < cart.getItems().size(); i++) {
                        System.out.println(cart.getItems().get(i).getName() + "   | W " + cart.getItems().get(i).getPrice() + " | " + cart.getItems().get(i).getDescription());
                    }

                    // 총금액 출력
                    System.out.println("\n[ Total ]");
                    System.out.println("W " + this.cart.getTotalPrice() + "\n");

                    // 사용자 확인 (최종적으로 주문할 지, 메뉴판으로 돌아갈 지에 대한 선택)
                    System.out.println("1. 주문        2. 메뉴판");
                    int finalSelect = sc.nextInt();

                    if (finalSelect == 1) {
                        // 할인 정보 제공
                        System.out.println("\n할인 정보를 입력해주세요.");
                        System.out.printf("1. 국가유공자 : %.0f%%\n", UserType.NATIONALMERIT.getdiscountRate() * 100.0);
                        System.out.printf("2. 군인 : %.0f%%\n", UserType.SOLDIER.getdiscountRate() * 100.0);
                        System.out.printf("3. 학생 : %.0f%%\n", UserType.STUDENT.getdiscountRate() * 100.0);
                        System.out.printf("4. 일반 : %.0f%%\n", UserType.NORMAL.getdiscountRate() * 100.0);
                        int discountSelect = sc.nextInt();

                        UserType selectedUserType; // 선택된 사용자 유형을 담을 enum

                        switch (discountSelect) {
                            case 1:
                                selectedUserType = UserType.NATIONALMERIT;
                                break;
                            case 2:
                                selectedUserType = UserType.SOLDIER;
                                break;
                            case 3:
                                selectedUserType = UserType.STUDENT;
                                break;
                            case 4:
                                selectedUserType = UserType.NORMAL;
                                break;
                            default:
                                System.out.println("그 외의 숫자는 할인율이 적용되지 않습니다..!");
                                selectedUserType = UserType.NORMAL; // 할인율이 적용되지 않는 일반 유형 설정
                                break;
                        }

                        // 할인율 계산
                        double totalPrice = this.cart.getTotalPrice() * (1 - selectedUserType.getdiscountRate());

                        System.out.printf("\n주문이 완료되었습니다. 금액은 W " + totalPrice + "입니다.\n");
                        this.cart.clearCart(); // 장바구니 비우기
                    } else if (finalSelect == 2) { // 메뉴판으로 돌아갈 시 반복문 처음으로 돌아감.
                        continue;
                    }

                } else if (menuselect == 5 && !this.cart.isEmpty()) {
                    System.out.println("\n진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    System.out.print("메뉴를 고르세요 : ");
                    int cancelSelect = sc.nextInt();
                    if (cancelSelect == 1) {
                        this.cart.clearCart();
                        System.out.println("\n진행하던 주문이 취소되었습니다.\n");
                    }
                } else {
                    throw new IllegalArgumentException("숫자를 잘못 선택 하셨습니다.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력하세요 !! ");
                sc.next();
            }
        }
    }
}
