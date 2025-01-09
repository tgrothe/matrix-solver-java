# matrix-solver-java

Solve linear equitation systems with Gauss-Jordan algorithm.

### How to use

Download and start the jar file located under [releases](https://github.com/tgrothe/matrix-solver-java/releases) with `java -jar matrix-solver.jar`.

Its use is largely self-explanatory.

### Screenshot

![Screenshot-1.png](Screenshot-1.png)

### Dependencies

This project uses the following dependencies:

### Build Process

To build the project, use the following command:
```
./gradlew build
```

### Contributing

To contribute to this project, please fork the repository and create a pull request with your changes.

### License

This project is licensed under the MIT License. See the LICENSE file for details.

### Project Structure

- `src/main/java`: Contains the source code of the project.
  - `GaussJordan.java`: Solves linear equation systems using the Gauss-Jordan algorithm.
  - `GaussJordanResult.java`: Stores the result of the Gauss-Jordan algorithm.
  - `Main.java`: Contains the main method to start the application.
  - `UI.java`: Creates and displays the user interface for the application.
- `build.gradle`: Contains the build configuration for the project.
- `dependencies.gradle`: Contains the dependencies for the project.
- `gradlew` and `gradlew.bat`: Scripts to run Gradle on Unix and Windows systems.
- `gradle/wrapper/gradle-wrapper.properties`: Configuration for the Gradle wrapper.
- `.github/workflows`: Contains the GitHub Actions workflows for CI/CD.

### CI/CD Setup

This project uses GitHub Actions for CI/CD. The workflows are defined in the `.github/workflows` directory.

To run tests, use the following command:
```
./gradlew test
```

### Detailed Explanation

#### How the Repository Works

This repository contains a Java application that solves linear equation systems using the Gauss-Jordan algorithm. The main components of the application are:

- `GaussJordan.java`: This class implements the Gauss-Jordan algorithm to solve linear equation systems. It includes methods to reduce rows, solve the system, and print the current state of the matrix.
- `GaussJordanResult.java`: This class stores the result of the Gauss-Jordan algorithm, including the solved flag and the lines of the result.
- `Main.java`: This class contains the main method to start the application. It initializes the user interface.
- `UI.java`: This class creates and displays the user interface for the application. It sets up the main frame, input and output text areas, and buttons. It also defines the event listeners for the buttons.

#### How to Use the GUI

1. **Start the Application**: Download and start the jar file located under [releases](https://github.com/tgrothe/matrix-solver-java/releases) with `java -jar matrix-solver.jar`.
2. **Input the Matrix**: In the input text area, enter the matrix you want to solve. Each row of the matrix should be on a new line, and the elements of each row should be separated by commas or spaces.
3. **Solve the Matrix**: Click the "=> Solve =>" button to solve the matrix. The result will be displayed in the output text area.
4. **Clear the Input**: Click the "Clear" button to clear the input text area.

The GUI is designed to be user-friendly and intuitive. The default input text provides an example of how to format the matrix.
