import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    // Граничные значения
    @org.junit.jupiter.api.Test
    void shouCalculateForRegisterBeforeBorder(){
        BonusService service = new BonusService();

        long amount = 16_640;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForRegisterOnTheBorder(){
        BonusService service = new BonusService();

        long amount = 16_670;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForRegisterAfterTheBorder(){
        BonusService service = new BonusService();

        long amount = 16_700;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterBeforeBorder(){
        BonusService service = new BonusService();

        long amount = 49_990;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterOnTheBorder(){
        BonusService service = new BonusService();

        long amount = 50_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterAfterTheBorder(){
        BonusService service = new BonusService();

        long amount = 50100;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForRegisterAndMinAmount(){
        BonusService service = new BonusService();

        long amount = 1;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterAndMinAmount(){
        BonusService service = new BonusService();

        long amount = 1;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    //Негатив
    @org.junit.jupiter.api.Test
    void shouCalculateForRegisterAndZeroValue(){
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterAndZeroValue(){
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouCalculateForRegisterAndNegativeValue(){
        BonusService service = new BonusService();

        long amount = -10;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouCalculateForUnregisterAndNegativeValue(){
        BonusService service = new BonusService();

        long amount = -10;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }




}