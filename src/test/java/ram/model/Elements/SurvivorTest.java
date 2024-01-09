package ram.model.Elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ram.model.realm.Realm;

import static org.mockito.Mockito.*;

public class SurvivorTest {
    private Survivor survivor;
    private Survivor smock;

    @BeforeEach
    void setUp() {
        survivor = new Survivor(5, 5);
        smock = mock(Survivor.class);
    }

    @Test
    void decreaseHealthTest(){
        survivor.decreaseHealth();
        Assertions.assertEquals(9,survivor.getHealth());
    }

    @Test
    void getHealthTest(){
        smock.getHealth();
        verify(smock,times(1)).getHealth();
    }

    @Test
    void NukeNotCaughtTest(){
        Assertions.assertFalse(survivor.getNuke());
    }

    @Test
    void NukeCaughtTest(){
        survivor.NukeCaught();
        Assertions.assertTrue(survivor.getNuke());
    }

    @Test
    void decCoinsTest(){
        survivor.decreaseCoins();
        Assertions.assertEquals(4,survivor.getCoins());
    }
}
