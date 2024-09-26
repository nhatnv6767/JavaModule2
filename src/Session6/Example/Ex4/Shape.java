package Session6.Example.Ex4;

abstract class Shape {
    private String color;

    public Shape() {
        this.color = "Đỏ";
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract double getArea();

    public void display() {
        System.out.println("Màu sắc của hình: " + this.color);
    }
}
