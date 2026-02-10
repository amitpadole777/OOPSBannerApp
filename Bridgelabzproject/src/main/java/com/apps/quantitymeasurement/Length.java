package com.apps.quantitymeasurement;

import java.text.DecimalFormat;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit{
        FEET(12.0),INCHES(1.0), YARD(36), CM(0.393701);

        private final double conversionFactor;

        //constructor
        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // constructor
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length add(Length thatLength) throws MyException {

        final LengthUnit unit = this.unit;

        if( thatLength == null){
            throw new MyException("Please enter source and target");
        }

        double thatCF = thatLength.unit.conversionFactor;
        double thisCF = this.unit.conversionFactor;

        // converting into base unit.
        double value1 = thatLength.value;
        double value2 = this.value;
        value1 = value1 * thatCF;
        value2 = value2 * thisCF;

        // addition in base unit inches
        double baseValue = value1 + value2;

        // convert base unit to the first unit provided
        double convertedBaseValue = baseValue/thisCF;

        // keep values up to three decimals only
        DecimalFormat df = new DecimalFormat("#.###");
        convertedBaseValue = Double.parseDouble(df.format(convertedBaseValue));

        new Length(convertedBaseValue, unit);

        return new Length(convertedBaseValue, unit);
    }

    public static double convert(Double value, LengthUnit sourceUnit, LengthUnit targetUnit) throws MyException {

        if (value.isInfinite()){
            throw new MyException("Please enter a finite value");
        }

        if( sourceUnit != null && targetUnit == null){
            throw new MyException("Please enter source and target");
        }

        if(!(sourceUnit instanceof LengthUnit && targetUnit instanceof LengthUnit) ){
            throw new MyException("Either source or target is invalid");
        }

        double sourceUnitCF = sourceUnit.getConversionFactor();
        double targetUnitCF = targetUnit.getConversionFactor();
        double result1 = value * (sourceUnitCF/targetUnitCF);

        // keep values upto two decimals only
        DecimalFormat df = new DecimalFormat("#.00");
        double result = Double.parseDouble(df.format(result1));

        return result;
    }

    //length -> base unit (INCHES)
    private double convertToBaseUnit(){
        return 12.0;
    }

    public boolean compare(Length thatLength){

        double thatCF = thatLength.unit.conversionFactor;
        double thisCF = this.unit.conversionFactor;

        // converting into base unit.
        double value1 = thatLength.value;
        double value2 = this.value;
        value1 = value1 * thatCF;
        value2 = value2 * thisCF;

        // keep values up to two decimals only
        DecimalFormat df = new DecimalFormat("#.00");
        value1 = Double.parseDouble(df.format(value1));
        value2 = Double.parseDouble(df.format(value2));

        return Double.compare(value2, value1) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        if(length.unit == null){
            return false;
        }
        return compare(length);
    }

    // main for standalone testing
    public static void main(String[] args) {
        Length length1 = new Length(3.0, LengthUnit.FEET);
        Length length2 = new Length(1.0, LengthUnit.YARD);
        System.out.println(length1.equals(length2) + " validation");
    }
}
