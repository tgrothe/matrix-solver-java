import java.util.ArrayList;
import java.util.List;

/** The GaussJordanResult class stores the result of the Gauss-Jordan algorithm. */
public class GaussJordanResult {
  private final List<String> lines = new ArrayList<>();
  private boolean solved = false;

  public void addLine(String s) {
    lines.add(s);
  }

  public void setSolvedTrue() {
    solved = true;
  }

  @Override
  public String toString() {
    return String.join("\n", lines) + "\nsolved: " + solved;
  }
}
