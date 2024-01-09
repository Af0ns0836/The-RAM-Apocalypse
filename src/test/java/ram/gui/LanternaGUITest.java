package ram.gui;

import ram.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    public void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    public void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        verify(tg, times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        verify(tg, times(1)).putString(1, 1, "Hello World");
    }

    @Test
    public void drawSurvivorTest() {
        gui.drawSurvivor(new Position(1,1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#23BCDE"));
        verify(tg, times(1)).putString(1, 1 + 1, "" + "$");
    }

    @Test
    public void drawWallTest(){
        gui.drawWall(new Position(1,1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#8D6840"));
        verify(tg, times(1)).putString(1, 1 + 1, "" + "&");
    }

    @Test
    public void drawTreeTest(){
        gui.drawTree(new Position(1,1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#4FBD3B"));
        verify(tg, times(1)).putString(1, 1 + 1, "" + "~" );
    }
    @Test
    public void drawBushTest(){
        gui.drawBush(new Position(1,1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#b3ff7f"));
        verify(tg, times(1)).putString(1, 1 + 1, "" + "|");
    }
    @Test
    public void drawCoinTest(){
        gui.drawCoin(new Position(1,1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#DED023"));
        verify(tg, times(1)).putString(1, 1 + 1, "" + "%");
    }

    @Test
    public void drawNukeTest(){
        gui.drawNuke(new Position(1,1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#E1512B"));
        verify(tg, times(1)).putString(1, 1 + 1, "" + "!");
    }

    @Test
    public void drawZombieTest(){
        gui.drawZombie(new Position(1,1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#126300"));
        verify(tg, times(1)).putString(1, 1 + 1, "" + "#");
    }

    @Test
    public void CRCTest() throws IOException { //Clear Refresh Close
        gui.clear();
        verify(screen,times(1)).clear();
        gui.refresh();
        verify(screen,times(1)).refresh();
        gui.close();
        verify(screen,times(1)).close();
    }

    @Test
    public void getNextActionTest() throws IOException {
        gui.getNextAction();
        verify(screen,times(1)).pollInput();
    }

}