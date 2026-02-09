package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static void main(String[] args) throws MyException {

           double value = Length.convert(0.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARD);
           System.out.println(value);
    }
}
