package com.apps.quantitymeasurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality_SameValue(){
        QuantityMeasurementApp.Feet obj1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet obj2 = new QuantityMeasurementApp.Feet(1.0);
        boolean expectedResult = true;
        boolean actualResult = obj1.equals(obj2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFeetEquality_DifferentValue(){
        QuantityMeasurementApp.Feet obj1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet obj2 = new QuantityMeasurementApp.Feet(2.0);
        boolean expectedResult = false;
        boolean actualResult = obj1.equals(obj2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFeetEquality_NullComparison(){
        QuantityMeasurementApp.Feet obj1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet obj2 = null;
        boolean expectedResult = false;
        boolean actualResult = obj1.equals(obj2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFeetEquality_DifferentClass(){
        QuantityMeasurementApp.Feet obj1 = new QuantityMeasurementApp.Feet(1.0);
        Integer obj2 = 1;
        boolean expectedResult = false;
        boolean actualResult = obj1.equals(obj2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFeetEquality_SameReference(){
        QuantityMeasurementApp.Feet obj1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet obj2 = obj1;
        boolean expectedResult = true;
        boolean actualResult = obj1.equals(obj2);
        assertEquals(expectedResult, actualResult);
    }
}
