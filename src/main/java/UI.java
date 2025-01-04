import java.awt.*;
import java.util.Arrays;
import java.util.function.Predicate;
import javax.swing.*;

/** The UI class creates and displays the user interface for the application. */
public class UI {
  /**
   * The showUI method initializes and displays the user interface. It sets up the main frame, input
   * and output text areas, and buttons. It also defines the event listeners for the buttons.
   */
  public static void showUI() {
    SwingUtilities.invokeLater(
        () -> {
          // Create the main frame
          JFrame jf = new JFrame("Gauss-Jordan Solver");
          jf.setLayout(new BorderLayout());

          // Create panels for input/output text areas and buttons
          JPanel p1 = new JPanel(new GridLayout(1, 2));
          JPanel p2 = new JPanel(new FlowLayout());

          // Create input and output text areas
          JTextArea jtaInput = new JTextArea();
          JTextArea jtaOutput = new JTextArea();

          // Create buttons
          JButton jbSolve = new JButton("=> Solve =>");
          JButton jbClear = new JButton("Clear");

          // Add text areas to the panel
          p1.add(new JScrollPane(jtaInput));
          p1.add(new JScrollPane(jtaOutput));

          // Add buttons to the panel
          p2.add(jbSolve);
          p2.add(jbClear);

          // Add panels to the frame
          jf.add(p1, BorderLayout.CENTER);
          jf.add(p2, BorderLayout.SOUTH);

          // Set frame properties
          jf.setSize(600, 400);
          jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          jf.setVisible(true);

          // Set default input text
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

          // Define the action listener for the solve button
          jbSolve.addActionListener(
              e -> {
                try {
                  // Parse input, solve the system, and display the result
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
                  // Handle exceptions and display error messages
                  jtaOutput.setText(ex.getMessage());
                }
              });

          // Define the action listener for the clear button
          jbClear.addActionListener(e -> jtaInput.setText(""));
        });
  }
}
