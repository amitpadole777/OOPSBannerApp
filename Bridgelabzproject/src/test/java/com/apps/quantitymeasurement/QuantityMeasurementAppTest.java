package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.Length.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityMeasurementAppTest {

    @Test
    public void testConversion_FeetToInches() throws MyException {
        double actualResult = convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double expectedResult = 12.0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testConvertestConversion_InchesToFeetsion_FeetToInches() throws MyException {
        double actualResult = convert(24.0, Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        double expectedResult = 2.0;
        assertEquals(expectedResult, actualResult);
    }

    // 3
    @Test
    public void testConversion_YardsToInches() throws MyException {
        double actualResult = convert(1.0, Length.LengthUnit.YARD, Length.LengthUnit.INCHES);
        double expectedResult = 36.0;
        assertEquals(expectedResult, actualResult);
    }

    // 4
    @Test
    public void testConversion_InchesToYards() throws MyException {
        double actualResult = convert(72.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARD);
        double expectedResult = 2.0;
        assertEquals(expectedResult, actualResult);
    }

    // 5
    @Test
    public void testConversion_CentimetersToInches() throws MyException {
        double actualResult = Length.convert(2.54, Length.LengthUnit.CM, Length.LengthUnit.INCHES);
        double expectedResult = 1.0;
        assertEquals(expectedResult, actualResult);
    }

    // 6
    @Test
    public void testConversion_FeatToYard() throws MyException {
        double actualResult = convert(6.0, Length.LengthUnit.FEET, Length.LengthUnit.YARD);
        double expectedResult = 2.0;
        assertEquals(expectedResult, actualResult);
    }

    // 7
    @Test
    public void testConversion_RoundTrip_PreservesValue() throws MyException {
        // convert(convert(v, A, B), B, A) ≈ v
        double expectedResult = 1.0;
        double actualResult = convert(convert(1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES),Length.LengthUnit.INCHES, Length.LengthUnit.FEET);
        assertEquals(expectedResult, actualResult);
    }

    // 8
    @Test
    public void testConversion_ZeroValue() throws MyException {
        double actualResult = convert(0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double expectedResult = 0.0;
        assertEquals(expectedResult, actualResult);
    }

    // 9
    @Test
    public void testConversion_NegativeValue() throws MyException {
        double actualResult = convert(-1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        double expectedResult = -12;
        assertEquals(expectedResult, actualResult);
    }

    // 10
    @Test
    public void testConversion_InvalidUnit_Throws() throws MyException {
        MyException exception = assertThrows(MyException.class, () -> {
            convert(1.0, Length.LengthUnit.FEET, null);
        });
        boolean result = exception.getMessage().equals("Please enter source and target");
        assertEquals(true, result);
    }

    // 11
    @Test
    public void testConversion_NaNOrInfinite_Throws() throws MyException {
        MyException exception = assertThrows(MyException.class, () -> {
            convert(Double.POSITIVE_INFINITY, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);
        });
        boolean result = exception.getMessage().equals("Please enter a finite value");
        assertEquals(true, result);
    }

    // 12
    @Test
    public void testConversion_PrecisionTolerance() throws MyException {
        MyException exception = assertThrows(MyException.class, () -> {
            convert(1.0, Length.LengthUnit.FEET, null);
        });
        boolean result = exception.getMessage().equals("Please enter source and target");
        assertEquals(true, result);
    }
}
