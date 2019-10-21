import com.whynot.zio.Zad1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Zad3Spec {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private Zad1 zad1;

    @Before
    public final void before() {
        zad1 = new Zad1();
        zad1.clearBoard();
    }

    @Test
    public void winInRows() {
        zad1.setValue(Zad1.PLAYER_X, 0,0);
        zad1.setValue(Zad1.PLAYER_X, 0,1);
        zad1.setValue(Zad1.PLAYER_X, 0,2);
        Assert.assertTrue(zad1.isWon());
        zad1.setValue(Zad1.PLAYER_X, 1,0);
        zad1.setValue(Zad1.PLAYER_X, 1,1);
        zad1.setValue(Zad1.PLAYER_X, 1,2);
        Assert.assertTrue(zad1.isWon());
        zad1.setValue(Zad1.PLAYER_X, 2,0);
        zad1.setValue(Zad1.PLAYER_X, 2,1);
        zad1.setValue(Zad1.PLAYER_X, 2,2);
        Assert.assertTrue(zad1.isWon());
    }


    @Test
    public void winInCols() {
        zad1.setValue(Zad1.PLAYER_X, 0,0);
        zad1.setValue(Zad1.PLAYER_X, 1,0);
        zad1.setValue(Zad1.PLAYER_X, 2,0);
        Assert.assertTrue(zad1.isWon());
        zad1.setValue(Zad1.PLAYER_X, 0,1);
        zad1.setValue(Zad1.PLAYER_X, 1,1);
        zad1.setValue(Zad1.PLAYER_X, 2,1);
        Assert.assertTrue(zad1.isWon());
        zad1.setValue(Zad1.PLAYER_X, 0,2);
        zad1.setValue(Zad1.PLAYER_X, 1,2);
        zad1.setValue(Zad1.PLAYER_X, 2,2);
        Assert.assertTrue(zad1.isWon());
    }

    @Test
    public void winOnAxis() {
        zad1.setValue(Zad1.PLAYER_X, 0,0);
        zad1.setValue(Zad1.PLAYER_X, 1,1);
        zad1.setValue(Zad1.PLAYER_X, 2,2);
        Assert.assertTrue(zad1.isWon());
        zad1.setValue(Zad1.PLAYER_X, 0,2);
        zad1.setValue(Zad1.PLAYER_X, 1,1);
        zad1.setValue(Zad1.PLAYER_X, 2,0);
        Assert.assertTrue(zad1.isWon());
    }

    @Test
    public void noWin() {
        zad1.setValue(Zad1.PLAYER_X, 0,0);
        zad1.setValue(Zad1.PLAYER_O, 1,1);
        zad1.setValue(Zad1.PLAYER_X, 2,2);
        Assert.assertFalse(zad1.isWon());
    }
}

