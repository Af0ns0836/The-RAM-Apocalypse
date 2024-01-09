package ram.controller.game;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ram.Game;
import ram.gui.GUI;
import ram.model.Elements.Survivor;
import ram.model.Elements.Zombies;
import ram.model.Position;
import ram.model.realm.Realm;


import java.io.IOException;

import java.util.Arrays;
import static org.mockito.Mockito.*;

public class ZombieControllerTest {

    private ZombieController controllermock;
    private Realm realm;

    private Game game;

    private long time;
    private Survivor survivor;

    private Position position;

    private Zombies zombies;

    private long lastMovement = 0L;
    private GUI.ACTION action;

    @BeforeEach
    void setUp() {
        realm = new Realm(10, 10);

        survivor = new Survivor(5, 5);
        realm.setSurvivor(survivor);

        realm.setWalls(Arrays.asList());
        realm.setZombies(Arrays.asList());
        realm.setCoins(Arrays.asList());
        realm.setBushes(Arrays.asList());
        realm.setTrees(Arrays.asList());

        zombies = new Zombies(7,8);

        position = new Position(8,8);

        lastMovement = 0L;

        controllermock = mock(ZombieController.class);

        action = GUI.ACTION.UP;
        time = 600;
        game = mock(Game.class);
    }

    @Test
    public void ZombieControllerTest() {

    }

    @Test
    public void step() throws IOException { //NH for not hit (no collision with player)

        controllermock.step(game,action,time);
        Assertions.assertEquals(0,controllermock.getLastMovement());
    }
}
