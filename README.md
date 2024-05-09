

# CSC2620 Final Project - Building Details GUI

## Overview

This project is a JavaFX application developed for the CSC2620 course final project. It provides a graphical user interface (GUI) for viewing detailed information about buildings on a college campus, including images and captions.

## Workflow

The project's workflow and progress were managed using Trello. For information on the project's workflow, tasks, and progress, please refer to the [Trello board](https://trello.com/b/U4Ok63HV/csc2620finalbrownmcnulty).

## System Requirements
To use this program, your system needs to have the following:

Java Development Kit (JDK): Ensure that the system has JDK 21 installed.
JavaFX SDK: Your system should have JavaFX SDK version 22.0.1 installed. Set the JAVA_FX_SDK system environment variable to point to the JavaFX SDK path. For example: C:\Program Files\javafx-sdk-22.0.1.
```plaintext
JAVA_FX_SDK=C:\Program Files\javafx-sdk-22.0.1
```
Dependencies: The project relies on various JavaFX modules (javafx-controls, javafx-fxml, javafx-base, javafx-graphics, javafx-media) and org.json. Make sure these dependencies are available to the project. The json-20240303.jar file should be located in the lib directory relative to the project's base directory.
Operating System: The program should be compatible with any operating system that supports Java and JavaFX, including Windows, macOS, and Linux.

## Maven Configuration
The project is built and managed using Apache Maven. The pom.xml file contains the necessary configurations and dependencies.

## Maven Dependencies
The project's dependencies are listed in the pom.xml file. Maven will automatically download these dependencies when building the project.
## Usage

1. Clone or download the project repository.
2. Set up your system variable `{JAVA_FX_SDK}` as described above.
3. Initialize the main class in the College Tour Login.
4. Upon launching, you will be presented with an option to log in or exit. Enter your information or choose to exit.
5. After logging in, choose which campus you want to explore.
6. Navigate through the buildings using the provided navigation buttons.
7. To return to the building options, click the "Return to Building Options" button.
8. On the Computer Program Details and Main Campus, there is an autoplay feature. Press the pause button to manually navigate through the photos without interruption. Press the play button to restart the automatic slideshow.

## Contributors

- Emily Brown
- Erin McNulty

## License

This project is licensed under an Educational License.

