package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    private static void demonstrateLengthComparison(double v, Length.LengthUnit lengthUnit, double v1, Length.LengthUnit lengthUnit1) {
        Length length1 = new Length(v, lengthUnit);
        Length length2 = new Length(v1, lengthUnit1);
        System.out.println(length1.equals(length2));
    }

    public static void main(String[] args) {

         // demonstrate feet and inches comparison
         demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 36.0, Length.LengthUnit.INCHES);

         // demonstrate yard and inches comparison
         demonstrateLengthComparison(1.0, Length.LengthUnit.YARD, 36.0, Length.LengthUnit.INCHES);

         // demonstrate cm and inches comparison
         demonstrateLengthComparison(100.0, Length.LengthUnit.CM, 39.3701, Length.LengthUnit.INCHES);

         // demonstrate feet and yards comparison
         demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARD);

         // demonstrate cm and feet comparison
        demonstrateLengthComparison(30.48, Length.LengthUnit.CM, 1.0, Length.LengthUnit.FEET);
    }
}
