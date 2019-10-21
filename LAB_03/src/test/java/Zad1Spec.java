import com.whynot.zio.Zad1;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Zad1Spec {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private Zad1 zad1;

    @Before
    public final void before() {
        zad1 = new Zad1();
        zad1.clearBoard();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        zad1.setValue(Zad1.PLAYER_X, 6,6);
    }


    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        exception.expect(RuntimeException.class);
        zad1.setValue(Zad1.PLAYER_X, 2,6);
    }

    @Test
    public void whenFieldOccupiedThenRuntimeException() {
        exception.expect(RuntimeException.class);
        zad1.setValue(Zad1.PLAYER_X, 2,2);
        zad1.setValue(Zad1.PLAYER_X, 2,2);
    }
}

