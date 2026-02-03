package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    public enum LengthUnit{
        FEET(12.0),INCHES(1.0);

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

    //length -> base unit (INCHES)
    private double convertToBaseUnit(){
        return 12.0;
    }

    public boolean compare(Length thatLength){

        double thatCF = thatLength.unit.conversionFactor;
        double thisCF = this.unit.conversionFactor;

        // converting into base unit.
        thatLength.value = thatLength.value * thatCF;
        this.value = this.value * thisCF;

        return Double.compare(this.value, thatLength.value) == 0;
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
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(24.0, null);
        System.out.println(length1.equals(length2));
    }
}
