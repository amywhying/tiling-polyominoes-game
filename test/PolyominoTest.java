import org.junit.Test;

import java.util.ArrayList;

import model.Polyomino;
import model.PolyominoImpl;
import model.Posn;

import static junit.framework.TestCase.assertEquals;

public class PolyominoTest {
  private Polyomino game1 = new PolyominoImpl();

  @Test
  public void test() {
    assertEquals("_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ ", game1.getState());
  }

  @Test
  public void testRandom() {
    ArrayList<Posn> mt = new ArrayList<>();
    mt.add(new Posn(3, 3));
    mt.add(new Posn(3, 4));
    mt.add(new Posn(3, 5));
    game1.randGenSolution(2);
    assertEquals("_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ \n" +
            "_ _ _ _ _ _ _ _ ", game1.getState());
  }
}
