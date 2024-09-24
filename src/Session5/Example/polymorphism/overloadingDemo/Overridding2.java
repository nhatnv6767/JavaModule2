package Session5.Example.polymorphism.overloadingDemo;

public class Overridding2 extends Overridding1 {
    public void talk() {
        System.out.println("Nói giọng miền bắc");
    }

    public String toString() {
        return "Thông tin của đối tượng Overridding 2";
    }
}
