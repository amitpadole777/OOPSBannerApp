package com.apps.quantitymeasurement;

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


        public void convertToBaseUnit(double value){

        }

        public void convertFromBaseUnit(double value){

        }
}