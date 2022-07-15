package com.softserve.edu12set;

public class App {
    public static void main(String[] args) throws InterruptedException {
        /*
        String a0 = "Java"; // equals new String("Java");
        String a1 = "Java"; // set reference
        String a2 = new String("Java"); // create new object
        //String a2 = new String("Java").intern();
        //
        System.out.println("(a0 == a1) =  " + (a0 == a1)); // true
        System.out.println("(a0 == a2) =  " + (a0 == a2)); // false
        //
        System.out.println("a0.equals(a1) =  " + a0.equals(a1)); // true
        System.out.println("a0.equals(a2) =  " + a0.equals(a2)); // true
        //
        System.out.println("a0.compareTo(a1) =  " + a0.compareTo(a1)); // 0
        System.out.println("a0.compareTo(a2) =  " + a0.compareTo(a2)); // 0
        //
        System.out.println("a0.hashCode() =  " + a0.hashCode());
        System.out.println("a1.hashCode() =  " + a1.hashCode());
        System.out.println("a2.hashCode() =  " + a2.hashCode());
        */
        /*
        Employee em0 = new Employee(1,"Ivan");
        Employee em1 = new Employee(1,"Ivan");
        System.out.println("(a0 == a1) =  " + (em0 == em1)); // false
        System.out.println("em0.equals(em1) =  " + em0.equals(em1)); // ?
        System.out.println("em0.hashCode() =  " + em0.hashCode());
        System.out.println("em1.hashCode() =  " + em1.hashCode());
        */
        //
        for (int i = 0; i < 100; i++) {
            System.out.print("o");
            System.err.print("_");
            Thread.sleep(1);
        }
    }
}
