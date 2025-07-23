package org.example.c_lv2;

public enum UserType {
    // 열거 상수 정의
    NATIONALMERIT("국가유공자", 0.1),
    SOLDIER("군인", 0.05),
    STUDENT("학생", 0.03),
    NORMAL("일반", 0);

    private final String person;
    private final double discountRate;


    UserType(String person, double discountRate) {
        this.person = person;
        this.discountRate = discountRate;
    }

    public String getPerson() {
        return person;
    }

    public double getdiscountRate() {
        return discountRate;
    }
}
