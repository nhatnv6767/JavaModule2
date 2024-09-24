package Session5.Exercise.Ex2;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        Point3D point3D = new Point3D();

        point2D.setXY(33, 55);
//        point3D.setXYZ(5, 6, 7);
        point3D.setXY(5, 6);
        System.out.println(point2D);
        System.out.println(point3D);
    }
}
