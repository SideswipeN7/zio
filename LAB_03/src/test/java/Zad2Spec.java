import com.whynot.zio.Zad1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.whynot.zio.Zad1.PLAYER_O;
import static com.whynot.zio.Zad1.PLAYER_X;

public class Zad2Spec {
    @Rule
    private Zad1 zad1;

    @Before
    public final void before() {
        zad1 = new Zad1();
        zad1.clearBoard();
    }

    @Test
    public void startFromX() {
        Assert.assertEquals(zad1.getCurrent(), PLAYER_X);
    }

    @Test
    public void afterXNextIsY() {
        zad1.setCurrent(PLAYER_X);
        zad1.setPosition(1,2);
        Assert.assertEquals(zad1.getCurrent(), PLAYER_O);
    }

    @Test
    public void afterYNextIsX() {
        zad1.setCurrent(PLAYER_O);
        zad1.setPosition(1,2);
        Assert.assertEquals(zad1.getCurrent(), PLAYER_X);
    }
}

