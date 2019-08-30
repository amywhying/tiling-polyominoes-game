<<<<<<< HEAD
public final class Execute {
  public static void main(String[] args) {

=======
import control.PolyominoControl;
import control.PolyominoControlImpl;
import model.Polyomino;
import model.PolyominoImpl;
import view.PolyominoView;
import view.PolyominoViewImpl;

public final class Execute {
  public static void main(String[] args) {
    Polyomino model = new PolyominoImpl();
    PolyominoView view = new PolyominoViewImpl();
    PolyominoControl controller = new PolyominoControlImpl(model, view);
    controller.run();
>>>>>>> a3e0692397b13bcc0b6fdb5e02db2881fd284562
  }
}
