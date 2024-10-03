package Session7.Example.Generic;

public class Demo {
    public static void main(String[] args) {
        // khoi tao doi tuong tu lop ClassGenetic
        ClassGeneric<String, String> cg1 = new ClassGeneric<>("Study", "Hoc");
        ClassGeneric<Integer, String> cg2 = new ClassGeneric<>(1, "Mot");
        System.out.printf("Nghia cua tu %s la %s\n", cg1.getKey(), cg1.getValue());
        System.out.printf("Phien am cua $d la %s\n", cg2.getKey(), cg2.getValue());
        GeneticIngeritance1 gi1 = new GeneticIngeritance1();
        GenericInheritance2<Integer> gi2 = new GenericInheritance2<>();
        GenericInheritance3<Float, Double, Integer> gi3 = new GenericInheritance3<>();

    }
}
