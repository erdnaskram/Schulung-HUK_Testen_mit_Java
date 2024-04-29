package de.sample.garage.domain;

import de.sample.garage.domain.exception.ShiftNotPossibleException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GearTransmissionTest {

    @Test
    void shouldInitializeGearTransmissionCorrectly() {
        //Arrange
        //Act
        var gt = new GearTransmission(5);
        //Assert
        Assertions.assertEquals(5, gt.getMaxGear(), "inncorrect max gear");
        Assertions.assertNull(gt.getCurrentGear(), "current gear should be null");
    }

    @Test
    void shuoldNotAccaptMaximumGearLessThanOne() {
        //Arrange
        //Act
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> new GearTransmission(0));
    }

    @Test
    void shouldShiftUpOnce() {
        //Arrange
        var gt = new GearTransmission(3);
        //Act
        //Assert
        Assertions.assertDoesNotThrow(gt::shiftUp);
        Assertions.assertEquals(1, gt.getCurrentGear());
    }

    @Test
    void shouldNotShiftUpMoreThanMaxGear() {
        //Arrange
        var gt = new GearTransmission(1);
        //Act
        //Assert
        Assertions.assertDoesNotThrow(gt::shiftUp);
        Assertions.assertThrows(ShiftNotPossibleException.class, gt::shiftUp);
    }

    @Test
    void shouldNotShiftUpTwice() {
        //Arrange
        var gt = new GearTransmission(3);
        //Act
        //Assert
        Assertions.assertDoesNotThrow(gt::shiftUp);
        Assertions.assertDoesNotThrow(gt::shiftUp);
        Assertions.assertEquals(2, gt.getCurrentGear());
    }

    @Test
    void shouldNotShiftUpMoreThanOnce() {
        //Arrange
        var gt = new GearTransmission(1);
        //Act
        //Assert
        Assertions.assertDoesNotThrow(gt::shiftUp);
        Assertions.assertThrows(ShiftNotPossibleException.class, gt::shiftUp);
        Assertions.assertThrows(ShiftNotPossibleException.class, gt::shiftUp);
    }
    @Test
    void getMaxGear() {
        //Arrange
        var gt1 = new GearTransmission(1);
        var gt2 = new GearTransmission(5);
        //Act
        //Assert
        Assertions.assertEquals(1, gt1.getMaxGear());
        Assertions.assertEquals(5, gt2.getMaxGear());
    }
}