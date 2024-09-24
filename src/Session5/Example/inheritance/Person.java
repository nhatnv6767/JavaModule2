package Session5.Example.inheritance;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private boolean sex;
    private String address;

    public Person() {
    }

    public Person(String name, int age, boolean sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập vào tên: ");
        this.name = scanner.nextLine();
        System.out.print("Nhập vào tuổi: ");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập vào giới tính: ");
        this.sex = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Nhập vào địa chỉ: ");
        this.address = scanner.nextLine();
    }
}
