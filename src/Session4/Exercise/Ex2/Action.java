package Session4.Exercise.Ex2;

public class Action {
    public static void main(String[] args) {
        Employee myEmployee = new Employee();
        myEmployee.inputData();
        myEmployee.displayData();

        System.out.println("Chu vi: " + myEmployee.chuVi());
        System.out.println("Diện tích: " + myEmployee.dienTich());
    }
}
