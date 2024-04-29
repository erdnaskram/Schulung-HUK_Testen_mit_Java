package de.sample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyFirstTest {

    @Test
    void testSth() {
        //Arrange
        int x = 1;
        int y = 1;

        //act
        int result = x + y;

        //assert
        Assertions.assertEquals(2, result);





//        System.out.println("Hello World");
//        throw new RuntimeException("I am a test exception");
    }
}
