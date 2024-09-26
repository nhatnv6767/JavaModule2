package Session6.Example.Ex5;

public class Main {
    public static void main(String[] args) {
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee("None", 15000, 6);
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("LilLuyen", 500000);

        System.out.println(partTimeEmployee.getName() + " - lương: " + partTimeEmployee.calculateSalary());
        System.out.println(fullTimeEmployee.getName() + " - lương: " + fullTimeEmployee.calculateSalary());
    }
}
