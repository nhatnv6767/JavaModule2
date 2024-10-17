package Session5.Exercise.Ex1;

public class Cylinder extends Circle {
    private double height;


    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "Hình trụ [bán kính = " + getRadius() + ", màu sắc = " + getColor() + ", chiều cao = " + getHeight() + ", diện tích đáy = " + getArea() + ", thể tích = " + getVolume() + "]";
    }
}
