package ram.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    Menu menu;

    @BeforeEach
    public void setUp(){
        menu = new Menu();
    }

    @Test
    public void menuTest(){
        Assertions.assertEquals(3,menu.getNumberEntries());
    }

    @Test
    public void nextEntryTest(){
        menu.nextEntry();
        Assertions.assertEquals(1,menu.getEntry());
    }

    @Test
    public void nextEntryLimitTest(){
        menu.setEntry(3);
        menu.nextEntry();
        Assertions.assertEquals(0,menu.getEntry());
    }

    @Test
    public void prevEntryTest(){
        menu.setEntry(1);
        menu.previousEntry();
        Assertions.assertEquals(0,menu.getEntry());
    }

    @Test
    public void prevEntryLimitTest(){
        menu.previousEntry();
        Assertions.assertEquals(2,menu.getEntry());
    }

    @Test
    public void getEntryStringTest(){
        Assertions.assertEquals("Start".charAt(0),menu.getEntry(0).charAt(0));
    }

    @Test
    public void isSelectedTrueTest(){
        Assertions.assertTrue(menu.isSelected(0));
    }

    @Test
    public void isSelectedFalseTest(){
        Assertions.assertFalse(menu.isSelected(1));
    }

    @Test
    public void isSelectedStartTest(){
        Assertions.assertTrue(menu.isSelectedStart());
    }

    @Test
    public void isSelectedControlsTest(){
        menu.setEntry(1);
        Assertions.assertTrue(menu.isSelectedControls());
    }

    @Test
    public void isSelectedExitTest(){
        menu.setEntry(2);
        Assertions.assertTrue(menu.isSelectedExit());
    }
}
