package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateLengthAddition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_ExplicitTargetUnit_Feet
            () throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.FEET;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(2.0, Length.LengthUnit.FEET);

        assertEquals(expectedResult, actualResult);
    }

    // 2
    @Test
    public void testAddition_ExplicitTargetUnit_Inches

            () throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.INCHES;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(24.0, Length.LengthUnit.INCHES);

        assertEquals(expectedResult, actualResult);
    }

    // 3
    @Test
    public void testAddition_ExplicitTargetUnit_Yards


            () throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.YARD;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(0.667, Length.LengthUnit.YARD);

        assertEquals(expectedResult, actualResult);
    }

    // 4
    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.CM;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(5.08, Length.LengthUnit.CM);

        assertEquals(expectedResult, actualResult);
    }

    // 5
    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand () throws MyException {
        Length length1 = new Length(2.0, Length.LengthUnit.YARD);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);
        final Length.LengthUnit feet = Length.LengthUnit.YARD;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(3.0, Length.LengthUnit.YARD);

        assertEquals(expectedResult, actualResult);
    }

    // 6
    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() throws MyException {
        Length length1 = new Length(2.0, Length.LengthUnit.YARD);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);
        final Length.LengthUnit feet = Length.LengthUnit.FEET;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(9.0, Length.LengthUnit.FEET);

        assertEquals(expectedResult, actualResult);
    }

    // 7
    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity
            () throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.YARD;
        Length actualResult1 = demonstrateLengthAddition(length1, length2, feet);

        Length length3 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length4 = new Length(1.0, Length.LengthUnit.FEET);
        final Length.LengthUnit yard = Length.LengthUnit.YARD;
        Length actualResult2 = demonstrateLengthAddition(length3, length4, yard);

        assertEquals(actualResult1, actualResult2);
    }

    // 8
    @Test
    public void testAddition_ExplicitTargetUnit_WithZero
            () throws MyException {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(0.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.YARD;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(1.667, Length.LengthUnit.YARD);

        assertEquals(expectedResult, actualResult);
    }

    // 9
    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues

            () throws MyException {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(-2.0, Length.LengthUnit.FEET);
        final Length.LengthUnit feet = Length.LengthUnit.INCHES;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(36.0, Length.LengthUnit.INCHES);

        assertEquals(expectedResult, actualResult);
    }

    // 10
    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit

            () throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = null;

        MyException exception = assertThrows(MyException.class, () -> {
            demonstrateLengthAddition(length1, length2, feet);
        });

        boolean result = exception.getMessage().equals("Please enter target unit");
        assertEquals(true, result);
    }

    // 11
    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale


            () throws MyException {
        Length length1 = new Length(1000.0, Length.LengthUnit.FEET);
        Length length2 = new Length(500.0, Length.LengthUnit.FEET);
        final Length.LengthUnit feet = Length.LengthUnit.INCHES;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(18000.0, Length.LengthUnit.INCHES);

        assertEquals(expectedResult, actualResult);
    }

    // 12
    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale

            () throws MyException {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.YARD;

        Length actualResult = demonstrateLengthAddition(length1, length2, feet);
        Length expectedResult = new Length(0.667, Length.LengthUnit.YARD);

        assertEquals(expectedResult, actualResult);
    }

    // 13
    @Test
    public void testAddition_ExplicitTargetUnit_AllUnitCombinations
            () throws MyException {

        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.FEET);
        final Length.LengthUnit yard = Length.LengthUnit.YARD;
        Length actualResult1 = demonstrateLengthAddition(length1, length2, yard);
        Length expectedResult1 = new Length(4.333, Length.LengthUnit.YARD);
        assertEquals(expectedResult1, actualResult1);

        Length length3 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length4 = new Length(12.0, Length.LengthUnit.FEET);
        final Length.LengthUnit cm = Length.LengthUnit.CM;
        Length actualResult2 = demonstrateLengthAddition(length3, length4, cm);
        Length expectedResult2 = new Length(396.24, Length.LengthUnit.CM);
        assertEquals(expectedResult2, actualResult2);
    }

    // 14
    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionToleance

            () throws MyException {

        Length length1 = new Length(12.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.YARD);
        final Length.LengthUnit inches = Length.LengthUnit.INCHES;
        Length actualResult1 = demonstrateLengthAddition(length1, length2, inches);
        Length expectedResult1 = new Length(576, Length.LengthUnit.INCHES);
        assertEquals(expectedResult1, actualResult1);

        Length length3 = new Length(12.0, Length.LengthUnit.YARD);
        Length length4 = new Length(12.0, Length.LengthUnit.INCHES);
        final Length.LengthUnit feet = Length.LengthUnit.FEET;
        Length actualResult2 = demonstrateLengthAddition(length3, length4, feet);
        Length expectedResult2 = new Length(37.0, Length.LengthUnit.FEET);
        assertEquals(expectedResult2, actualResult2);
    }


}
