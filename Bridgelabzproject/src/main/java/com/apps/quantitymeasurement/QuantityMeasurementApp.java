package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static Length demonstrateLengthAddition() throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        return length1.add(length2);
    }

    public static void main(String[] args) throws MyException {

        Length len = demonstrateLengthAddition();
        System.out.println(len);
    }
}
