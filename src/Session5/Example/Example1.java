package Session5.Example;

public class Example1 {
    public static void main(String[] args) {
        // khoi tao 1 lan duy nhat view = 0
        RikkeiAcademy guest1 = new RikkeiAcademy();
        guest1.visited();
        System.out.println("Số lượt view hiện tại sau khi guest 1 thăm: " + guest1.getView());
        RikkeiAcademy guest2 = new RikkeiAcademy();
        guest2.visited();
        System.out.println("Số lượt view hiện tại sau khi guest 2 thăm: " + guest2.getView());
        RikkeiAcademy guest3 = new RikkeiAcademy();
        guest3.visited();
        System.out.println("Số lượt view hiện tại sau khi guest 3 thăm: " + guest3.getView());
    }

}
