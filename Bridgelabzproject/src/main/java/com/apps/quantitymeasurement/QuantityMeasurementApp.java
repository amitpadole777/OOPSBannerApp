package com.apps.quantitymeasurement;
import java.util.Scanner;

public class QuantityMeasurementApp {

    public static class Feet{

        private final Double value;

        public Feet(Double value){
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Feet feet = (Feet) o;
            return Double.compare(this.value, ((Feet) o).value) == 0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first value");
        Double value1 = sc.nextDouble();

        System.out.println("Enter first value");
        Double value2 = sc.nextDouble();

        Feet obj1 = new Feet(value1);
        Feet obj2 = new Feet(value2);

        System.out.println(obj1.equals(obj2));
    }
}
