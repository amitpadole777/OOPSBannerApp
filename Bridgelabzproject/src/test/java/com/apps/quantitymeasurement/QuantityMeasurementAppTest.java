package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuantityMeasurementAppTest {

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(3.0, Length.LengthUnit.FEET);

        assertEquals(expectedResult, actualResult);
    }

    // 2
    @Test
    public void testAddition_SameUnit_InchPlusInch() throws MyException {
        Length length1 = new Length(6.0, Length.LengthUnit.FEET);
        Length length2 = new Length(6.0, Length.LengthUnit.FEET);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(12.0, Length.LengthUnit.FEET);;
        assertEquals(expectedResult, actualResult);
    }

    // 3
    @Test
    public void testAddition_CrossUnit_FeetPlusInches() throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(2.0, Length.LengthUnit.FEET);
        assertEquals(expectedResult, actualResult);
    }

    // 4
    @Test
    public void testAddition_CrossUnit_InchPlusFeet() throws MyException {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(1.0, Length.LengthUnit.FEET);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(24.0, Length.LengthUnit.INCHES);
        assertEquals(expectedResult, actualResult);
    }

    // 5
    @Test
    public void testAddition_CrossUnit_YardPlusFeet() throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.YARD);
        Length length2 = new Length(3.0, Length.LengthUnit.FEET);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(2.0, Length.LengthUnit.YARD);;
        assertEquals(expectedResult, actualResult);
    }

    // 6
    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() throws MyException {
        Length length1 = new Length(2.54, Length.LengthUnit.CM);
        Length length2 = new Length(1.0, Length.LengthUnit.INCHES);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(5.08, Length.LengthUnit.CM);
        assertEquals(expectedResult, actualResult);
    }

    // 7
    @Test
    public void testAddition_Commutativity() throws MyException {
        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length length3 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length4 = new Length(1.0, Length.LengthUnit.FEET);

        Length result1 =  length1.add(length2);
        Length result2 =  length3.add(length4);

        assertEquals(result1, result2);
    }

    // 8
    @Test
    public void testAddition_WithZero() throws MyException {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(0.0, Length.LengthUnit.INCHES);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(5.0, Length.LengthUnit.FEET);
        assertEquals(expectedResult, actualResult);
    }

    // 9
    @Test
    public void testAddition_NegativeValues() throws MyException {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = new Length(-2.0, Length.LengthUnit.FEET);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(3.0, Length.LengthUnit.FEET);
        assertEquals(expectedResult, actualResult);
    }

    // 10
    @Test
    public void testAddition_NullSecondOperand() throws MyException {
        Length length1 = new Length(5.0, Length.LengthUnit.FEET);
        Length length2 = null;
        MyException exception = assertThrows(MyException.class, () -> {
            length1.add(length2);
        });
        boolean result = exception.getMessage().equals("Please enter source and target");
        assertEquals(true, result);
    }

    // 11
    @Test
    public void testAddition_LargeValues() throws MyException {
        Length length1 = new Length(1e6, Length.LengthUnit.FEET);
        Length length2 = new Length(1e6, Length.LengthUnit.FEET);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(2e6, Length.LengthUnit.FEET);
        assertEquals(expectedResult, actualResult);
    }

    // 12
    @Test
    public void testAddition_SmallValues() throws MyException {
        Length length1 = new Length(0.001, Length.LengthUnit.FEET);
        Length length2 = new Length(0.002, Length.LengthUnit.FEET);
        Length actualResult =  length1.add(length2);
        Length expectedResult = new Length(0.003, Length.LengthUnit.FEET);
        assertEquals(expectedResult, actualResult);
    }
}
