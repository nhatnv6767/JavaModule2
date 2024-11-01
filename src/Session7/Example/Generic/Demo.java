package Session7.Example.Generic;

import java.util.ArrayList;
import java.util.List;

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

        // wildcard ?: dai dien cho bat cu kieu du lieu nao
        Person person = new Person();
        Teacher teacher = new Teacher();
        Employee employee = new Employee();
//        List<?> list = new ArrayList<>();
//        list.add(person);


    }

    public List<?> getObject1() {
        // dai dien cho bat cu kieu du lieu nao
        return new ArrayList<Integer>();
    }

    public List<? extends Teacher> getObject2() {
        // extend dai dien cho tat ca cac kieu du lieu ke thua tu Teacher
        return new ArrayList<Employee>();
    }

    public List<? super Teacher> getObject3() {
        // extend dai dien cho tat ca cac kieu du lieu ma Teacher ke thua
        return new ArrayList<Person>();
    }
}
