# ☕ Java Kiosk Project

이 프로젝트는 Java의 기본적인 문법, 객체 지향 설계, 그리고 Enum, Stream 을 활용하여 개발된 콘솔 기반 키오스크 프로그램입니다.

\<br\>

## ✨ 주요 기능

  - **메뉴 기능**: 다계층 메뉴(메인 메뉴 \> 상품 메뉴)를 통해 버거 메뉴, 디저트 메뉴, 음료 메뉴 등 메인 메뉴와 서브 메뉴가 분리되어 있습니다.
  - **장바구니**: 원하는 메뉴를 장바구니에 추가하고, 삭제하고, 조회할 수 있습니다.
  - **주문 및 결제**: 장바구니의 총액을 계산하고, 사용자 유형에 따른 할인을 적용하여 최종 결제를 진행합니다.
  - **주문 취소**: 진행 중이던 주문을 초기화할 수 있습니다.


-----

## 🚀 프로젝트 개발 과정

### ⚙️ 필수 과제 (Lv.1 \~ Lv.5)

#### Lv. 1: 기본적인 키오스크 프로그래밍

  - **학습 목표**: `Scanner` 활용법, `while`, `switch` 등 기본 제어 흐름 복습
  - **구현 내용**: `System.out.println`으로 메뉴를 표시하고, 사용자 입력을 받아 간단한 응답을 출력합니다. `0` 입력 시 프로그램을 종료합니다.

#### Lv. 2: 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기

  - **학습 목표**: 객체 지향 개념을 학습하고 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법 학습
  - **구현 내용**: 메뉴 정보를 담는 `MenuItem` 클래스를 생성하였습니다. `List<MenuItem>`을 사용하여 메뉴 데이터를 관리하고, `for` 반복문으로 메뉴판을 출력합니다.

#### Lv. 3: 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기

  - **학습 목표**: 객체 지향 개념을 학습하고, 데이터를 구조적으로 관리하며 프로그램을 설계하는 방법 학습
  - **구현 내용**: 프로그램의 전체 흐름을 담당하는 `Kiosk` 클래스를 생성했습니다. `main` 메서드는 데이터 준비 및 `Kiosk` 실행 역할만 하도록 코드를 분리하였습니다.

#### Lv. 4: 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기

  - **학습 목표**: 더 복잡한 데이터 구조를 설계하고 관리하는 방법 익히기
  - **구현 내용**: "Burgers", "Drinks"와 같은 메뉴 카테고리를 표현하는 `Menu` 클래스를 생성하였습니다. `Kiosk`가 `List<Menu>`를, 각 `Menu`가 `List<MenuItem>`을 갖는 2단계 구조를 완성하였습니다.

#### Lv. 5: 캡슐화 적용

  - **학습 목표**: 캡슐화 원칙을 적용하기
  - **구현 내용**: 캡슐화의 원칙을 적용해야 될 필드를 `private`으로 변경하고, `public` getter 메서드를 통해서만 데이터에 접근하도록 하였습니다.

-----

### ✨ 도전 과제 (Lv.1 \~ Lv.2)

#### Lv. 1: 장바구니 및 구매하기 기능을 추가하기

  - **학습 목표**: 클래스 간 연계를 통해 객체 지향 프로그래밍의 기본적인 설계를 익히고, 사용자 입력에 따른 프로그램 흐름 제어와 상태 관리를 학습
  - **구현 내용**:
      - 장바구니 역할을 하는 `Order` 클래스를 생성했습니다.
      - 메뉴 선택 시 장바구니에 아이템을 추가하는 기능을 구현했습니다.
      - 장바구니가 비어있지 않을 때만 `[ORDER MENU]`가 동적으로 표시되도록 isEmpty() 메소드를 활용하였습니다.
      - 장바구니 조회, 총액 계산, 주문 확정, 주문 취소 등 장바구니의 기본적인 내용을 구현하였습니다.

#### Lv. 2: Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리 

  - **학습 목표**: 고급 자바 기능을 활용해 프로그램의 효율성과 코드의 가독성을 개선하는 것이 목표
  - **구현 내용**:
      - **Enum**: `UserType` Enum을 생성하여 사용자 유형별 할인율을 안전하게 관리하고, 주문 시 할인율을 적용하는 기능을 구현했습니다.
      - **Lambda & Stream**:
          - `for` 반복문 기반의 Menu의 MenuItem 출력을 `IntStream.range().forEach()`를 사용하는 스트림 방식으로 리팩토링하였습니다.
          - `stream().filter().findFirst().ifPresent()`를 활용하여 장바구니에서 특정 아이템 입력 시 그 아이템이 제거되도록 구현하였습니다.
      - **메서드 분리**: `Kiosk` 클래스의 `start()` 메서드가 너무 복잡해보이고 가독성이 떨어져보여 `displayMainMenu()`, `SubMenu()` 등 여러 개의 메서드로 분리하여 가독성을 높히도록 하였습니다.


-----

## 🛠️ 사용 기술

  - **Language**: `Java`
  - **Core Concepts**:
      - Object-Oriented Programming
      - `List`, `ArrayList`
      - `while`, `if-else`, `switch`, `try-catch-finally`
      - `Enum`, `Lambda`, `Stream`

