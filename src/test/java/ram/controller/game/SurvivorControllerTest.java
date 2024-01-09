package ram.controller.game;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ram.Game;
import ram.gui.GUI;
import ram.model.Elements.Survivor;
import ram.model.Elements.Wall;
import ram.model.Position;
import ram.model.realm.Realm;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SurvivorControllerTest {
    private SurvivorController controller, controllermock;

    private Survivor survivor;
    private Realm realm;

    private Game game;

    private long time;
    private GUI.ACTION up, down, left, right;

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

        controller = new SurvivorController(realm);
        controllermock = mock(SurvivorController.class);

        up=GUI.ACTION.UP;
        down=GUI.ACTION.DOWN;
        left=GUI.ACTION.LEFT;
        right=GUI.ACTION.RIGHT;

        time = 1;
        game = mock(Game.class);
    }

    @Test
    void moveSurvivorRightEmpty() {
        controller.moveSurvivorRight();
        assertEquals(new Position(6, 5), survivor.getPosition());
    }

    @Test
    void moveSurvivorRightNotEmpty() {
        realm.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.moveSurvivorRight();
        assertEquals(new Position(5, 5), survivor.getPosition());
    }

    @Test
    void moveSurvivorLeftEmpty() {
        controller.moveSurvivorLeft();
        assertEquals(new Position(4, 5), survivor.getPosition());
    }

    @Test
    void moveSurvivorLeftNotEmpty() {
        realm.setWalls(Arrays.asList(new Wall(4, 5)));
        controller.moveSurvivorLeft();
        assertEquals(new Position(5, 5), survivor.getPosition());
    }

    @Test
    void moveSurvivorUpEmpty() {
        controller.moveSurvivorUp();
        assertEquals(5, survivor.getPosition().getX());
        assertEquals(survivor.getPosition().getY() + 1  , survivor.getPosition().getX());
    }

    @Test
    void moveSurvivorUpNotEmpty() {
        realm.setWalls(Arrays.asList(new Wall(5, 6)));
        controller.moveSurvivorUp();
        assertEquals(5, survivor.getPosition().getX());
        assertEquals(5, survivor.getPosition().getX());
    }
    @Test
    void moveSurvivorDownEmpty() {
        controller.moveSurvivorDown();
        assertEquals(5, survivor.getPosition().getX());
        assertEquals(survivor.getPosition().getY()-1, survivor.getPosition().getX());
    }

    @Test
    void moveSurvivorDownNotEmpty() {
        realm.setWalls(Arrays.asList(new Wall(5, 4)));
        controller.moveSurvivorDown();
        assertEquals(5, survivor.getPosition().getX());
        assertEquals(5, survivor.getPosition().getX());
    }

    @Test
    void stepUP(){
        controllermock.step(game,up,time);
        verify(controllermock).step(game,up,time);
    }

    @Test
    void stepDOWN(){
        controllermock.step(game,down,time);
        verify(controllermock).step(game,down,time);
    }

    @Test
    void stepRIGHT(){
        controllermock.step(game,right,time);
        verify(controllermock).step(game,right,time);
    }

    @Test
    void stepLEFT(){
        controllermock.step(game,left,time);
        verify(controllermock).step(game,left,time);
    }

}
