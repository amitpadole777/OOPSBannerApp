package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static Length demonstrateLengthAddition(Length length1, Length length2, Length.LengthUnit targetUnit) throws MyException {
        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) throws MyException {
        Length length1 = new Length(2.0, Length.LengthUnit.FEET);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        Length length3 = demonstrateLengthAddition(length1, length2, Length.LengthUnit.FEET);
        System.out.println(length3.equals(new Length(3.0, Length.LengthUnit.FEET)));
    }
}
