package com.dolnikova;

public class User {

    @Column(info = "full_name")
    private String fullName;

    private String age;

    @Override
    public String toString() {
        return "User{" +
                "fullName = '" + fullName + '\'' +
                ", age = " + age +
                '}';
    }
}
