package demo;

class Parent {
    int i = 200;

    public Parent() {
        test();
    }

    public void test() {
        System.out.println(i);
    }
}

class Child extends Parent {
    int i = 100;

    public void test() {
        System.out.println(i);
    }
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.test();
    }
}
