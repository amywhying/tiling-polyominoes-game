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
<<<<<<< HEAD
    game1.randGenSolution(2);
=======
    game1.randGenSolution(7);
>>>>>>> a3e0692397b13bcc0b6fdb5e02db2881fd284562
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
