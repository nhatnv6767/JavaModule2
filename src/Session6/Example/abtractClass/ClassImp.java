package Session6.Example.abtractClass;

public class ClassImp {
    public static void main(String[] args) {
        // khai bao doi tuong tu lop abstractclassdemo - khoi tao doi tuong gian tiep
        AbstractClassDemo ccd = new AbstractClassDemo() {
            @Override
            public void inputData() {
                System.out.println("Triển khai phương thức trừu tượng inputData");
            }

            @Override
            public void displayData() {
                System.out.println("Triển khai phương thức trừu tượng displayData");
            }
        };
    }
}
