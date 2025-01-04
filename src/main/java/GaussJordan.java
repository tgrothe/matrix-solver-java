import java.util.Locale;

/** The GaussJordan class solves linear equation systems using the Gauss-Jordan algorithm. */
public class GaussJordan {
  private final double[][] matrix;
  private final int rows;
  private final int cols;
  private final GaussJordanResult result = new GaussJordanResult();

  private GaussJordan(double[][] matrix) {
    this.matrix = matrix;
    this.rows = matrix.length;
    this.cols = matrix[0].length;
    for (int i = 0; i < rows; i++) {
      if (matrix[i].length != rows + 1) {
        result.addLine("Invalid matrix dimensions");
        return;
      }
    }
    solve();
  }

  private void print() {
    for (int i = 0; i < rows; i++) {
      StringBuilder s = new StringBuilder();
      for (int j = 0; j < cols; j++) {
        s.append(String.format(Locale.ENGLISH, "%.2f  ", matrix[i][j]));
      }
      result.addLine(s.toString());
    }
    result.addLine("");
  }

  private boolean reduceRow(double[] r1, double[] r2, int pos) {
    if (r1.length != r2.length) {
      return false;
    }

    double factor = r2[pos] / r1[pos];
    for (int i = pos; i < r1.length; i++) {
      r2[i] -= factor * r1[i];
    }
    return true;
  }

  private void solve() {
    int k; // pivot
    double[] swapTemp;

    for (int i = 0; i < rows; i++) {
      k = i;

      for (int j = i + 1; j < rows; j++) {
        if (matrix[j][i] > matrix[k][i]) {
          k = j;
        }
      }

      if (matrix[k][i] == 0) {
        result.addLine("System of equations contains free variables");
        return;
      }

      // Swap the rows i and k
      swapTemp = matrix[i];
      matrix[i] = matrix[k];
      matrix[k] = swapTemp;

      // Iterate over all subsequent rows
      for (int j = 0; j < rows; j++) {
        // Reduce row by row
        if (i != j && !reduceRow(matrix[i], matrix[j], i)) {
          result.addLine("System of equations cannot be solved");
          return;
        }
      }

      print();
    }

    divideAllRows();
    print();
    result.setSolvedTrue();
  }

  private void divideAllRows() {
    final int defaultPrecision = 5;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols - 1; j++) {
        double a = matrix[i][j];
        double b = matrix[i][cols - 1];
        if (!(areEqualDouble(a, 0, defaultPrecision) || areEqualDouble(a, 1, defaultPrecision))) {
          matrix[i][j] = 1;
          matrix[i][cols - 1] = b / a;
        }
      }
    }
  }

  @Override
  public String toString() {
    return result.toString();
  }

  public static String getGaussJordanResult(double[][] matrix) {
    return new GaussJordan(matrix).toString();
  }

  /**
   * @param precision number of decimal digits
   */
  public static boolean areEqualDouble(double a, double b, int precision) {
    return Math.abs(a - b) <= Math.pow(10, -precision);
  }
}
