package ram.viewer.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ram.gui.GUI;
import ram.model.Elements.Survivor;
import ram.model.Position;

import static org.mockito.Mockito.*;

public class SurvivorViewerTest {
    SurvivorViewer svmock;
    Survivor smock;
    GUI gmock;

    @BeforeEach
    void setUp() {
        svmock = mock(SurvivorViewer.class);
        smock = mock(Survivor.class);
        gmock = mock(GUI.class);
    }
    @Test
    public void drawTest() {
        svmock.draw(smock,gmock);
        verify(svmock,times(1)).draw(smock,gmock);
    }
}
