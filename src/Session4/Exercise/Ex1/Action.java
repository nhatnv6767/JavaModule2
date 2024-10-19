package Session4.Exercise.Ex1;

public class Action {
    public static void main(String[] args) {
        Circle myCircle = new Circle();
        myCircle.inputData();
        myCircle.displayData();

        System.out.println("Chu vi: " + myCircle.chuVi());
        System.out.println("Diện tích: " + myCircle.dienTich());
    }
}
