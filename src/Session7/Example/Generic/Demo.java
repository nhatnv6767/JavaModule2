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

        // method generic
        MethodGeneric mg = new MethodGeneric();
        Integer[] arrInt = {1, 3, 5, 7};
        Float[] arrFloat = {1.2f, 5.6f, 6.6f};
        String[] arrString = {"Mot", "Hai", "Ba"};
        mg.printElementOfArray(arrInt);
        mg.printElementOfArray(arrFloat);
        mg.printElementOfArray(arrString);

    }
}
