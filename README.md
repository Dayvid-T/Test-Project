

---

# Project ReadMe

## Project Overview

This project involves developing and testing utility methods for various functionalities. It includes detailed instructions on setting up and running tests, measuring code coverage, and performing mutation testing to ensure the robustness of the code.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed.
- IntelliJ IDEA (or any Java IDE) installed.

### Running the Project

1. **Clone the Repository**: 
   ```sh
   git clone <https://github.com/Dayvid-T/Test-Project.git>
   ```

2. **Open the Project**: Open the cloned repository in your IDE.

3. **Build the Project**: Ensure all dependencies are resolved and the project builds successfully.

## Testing

### Running Tests

1. **Run All Tests**: Execute the test suite by right-clicking on the test directory and selecting "Run All Tests".

2. **Test Coverage**: 
   - To run with coverage, navigate to `Run > Edit Configurations` and select your test configuration.
   - Click `Modify Options` and enable `Branch Coverage and Test Tracking`.
   - Run your tests again to see detailed coverage reports.

### Code Coverage

- **Class and Method Coverage**: Ensure all classes and methods are covered.
- **Line Coverage**: Verify which lines were executed during tests. Green indicates executed lines, red indicates non-executed lines, and yellow indicates partial execution.
- **Branch Coverage**: Ensure each conditional branch in your code is tested.

### Mutation Testing

- **PITest Integration**: Install the PITest plugin in IntelliJ.
- **Run Mutation Tests**: Right-click on the target class and select `Run Mutation Tests`.
- **Analyze Reports**: Open the generated HTML report to review which mutants were killed or survived.

## Additional Information

- **Coverage Annotations**: Colored blocks in the gutter (left of the code lines) indicate coverage status.
- **MC/DC**: Ensure Modified Condition/Decision Coverage by manually tracing code behavior.
- **Mutation Testing Philosophy**: Tests should fail if code is mutated to ensure robustness.


## Contributing

Feel free to fork the repository and submit pull requests. Ensure all new features are covered by tests and adhere to the project's coding standards.



---
