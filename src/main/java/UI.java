import java.awt.*;
import java.util.Arrays;
import java.util.function.Predicate;
import javax.swing.*;

/** The UI class creates and displays the user interface for the application. */
public class UI {
  public static void showUI() {
    SwingUtilities.invokeLater(
        () -> {
          JFrame jf = new JFrame("Gauss-Jordan Solver");
          jf.setLayout(new BorderLayout());
          JPanel p1 = new JPanel(new GridLayout(1, 2));
          JPanel p2 = new JPanel(new FlowLayout());
          JTextArea jtaInput = new JTextArea();
          JTextArea jtaOutput = new JTextArea();
          JButton jbSolve = new JButton("=> Solve =>");
          JButton jbClear = new JButton("Clear");
          p1.add(new JScrollPane(jtaInput));
          p1.add(new JScrollPane(jtaOutput));
          p2.add(jbSolve);
          p2.add(jbClear);
          jf.add(p1, BorderLayout.CENTER);
          jf.add(p2, BorderLayout.SOUTH);
          jf.setSize(600, 400);
          jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          jf.setVisible(true);

          jtaInput.setText(
              """
              1, 1, 0, 0, 0, 0, 0, 47
              0, 1, 1, 0, 0, 0, 0, 39
              0, 0, 0, 1, 0, 0, 0, 12
              0, 0, 0, 0, 0, 0, 1, 5
              -1, 0, 0, 1, 1, 0, 0, 0
              0, -1, 0, 0, 1, 1, 0, 0
              0, 0, -1, 0, 0, 1, 1, 0
              """);
          jbSolve.addActionListener(
              e -> {
                try {
                  jtaOutput.setText(
                      GaussJordan.getGaussJordanResult(
                          jtaInput
                              .getText()
                              .lines()
                              .filter(Predicate.not(String::isBlank))
                              .map(
                                  l ->
                                      Arrays.stream(l.split("[ ,]+"))
                                          .filter(Predicate.not(String::isBlank))
                                          .mapToDouble(Double::parseDouble)
                                          .toArray())
                              .toArray(double[][]::new)));
                } catch (Exception ex) {
                  jtaOutput.setText(ex.getMessage());
                }
              });
          jbClear.addActionListener(e -> jtaInput.setText(""));
        });
  }
}
