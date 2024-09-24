package Session5.Example.polymorphism.overloadingDemo;

public class Demo {
    public static void main(String[] args) {
        OverloadingDemo od = new OverloadingDemo();
        od.test(12, "name");
        Overridding2 o2 = new Overridding2();
        o2.talk();
    }
}
