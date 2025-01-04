import java.util.ArrayList;
import java.util.List;

/** The GaussJordanResult class stores the result of the Gauss-Jordan algorithm. */
public class GaussJordanResult {
  private final List<String> lines = new ArrayList<>();
  private boolean solved = false;

  /**
   * Adds a line to the result.
   *
   * @param s the line to add
   */
  public void addLine(String s) {
    lines.add(s);
  }

  /** Sets the solved flag to true. */
  public void setSolvedTrue() {
    solved = true;
  }

  /**
   * Returns the result as a string.
   *
   * @return the result as a string
   */
  @Override
  public String toString() {
    return String.join("\n", lines) + "\nsolved: " + solved;
  }
}
