package Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import Method.Arcsin;

import java.util.Random;

public class ArcsinTest {

    @Test
    void testZero(){
        assertEquals(0.0,Arcsin.arcsin(0,10),1e-10);
    }

    @Test
    void testHalf(){
        double actual = Math.asin(0.5);
        double except = Arcsin.arcsin(0.5,10);
        assertEquals(except,actual,1e-5);
    }

    @Test
    void testNegativeHalf(){
        double actual = Math.asin(-0.5);
        double except = Arcsin.arcsin(-0.5,10);
        assertEquals(except,actual,1e-5);
    }

    @Test
    void testRandom(){
        double[] arr = new double[]{-0.2,-0.3,-0.4,-0.7,0.2,0.3,0.4,0.7};
        for (double array : arr){
            double actual = Math.asin(array);
            double except = Arcsin.arcsin(array,15);
            assertEquals(except,actual,1e-5);
        }
    }

    @Test
    void testOddFunctionProperty() {
        double x = 0.4;
        double positive = Arcsin.arcsin(x, 10);
        double negative = Arcsin.arcsin(-x, 10);

        assertEquals(-positive, negative, 1e-10);
    }
}
