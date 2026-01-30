package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void demonstrateFeetEquality(){

        Double value1 = 1.0;
        Double value2 = 1.0;

        Feet obj1 = new Feet(value1);
        Feet obj2 = new Feet(value2);

        System.out.println("Result for Feet class: " + obj1.equals(obj2));

    }
    public static void demonstrateInchesEquality(){
        Double value1 = 1.0;
        Double value2 = 1.0;

        Feet obj1 = new Feet(value1);
        Feet obj2 = new Feet(value2);

        System.out.println("Result for Inches class: " + obj1.equals(obj2));
    }

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

    public static class Inches{
        private final Double value;
        public Inches(Double value){
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Inches inches = (Inches) o;
            return Double.compare(this.value, ((Inches) o).value) == 0;
        }
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
