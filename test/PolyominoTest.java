import org.junit.Test;

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
