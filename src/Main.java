/**
 * @name JAVA The Builder
 *
 *@version 1.0*
 *
 *@since15/11/2017
 *
 *@lastmodfied Last Modified : 21/11/2017
 *
 *@author Anmol Singh, Deepti Singh, Mayank Bhotika and Hussain Abbas BW
 *
 *@Purpose Javafx Application used to build JAVA files as well as JAVA Projects by using windows command prompt as console window by the use of self created WINDOWS BATCH FILE(.bat) which is created at the runtime. It gives user a window on which two buttons are present :
 *
 *                      Button 1 : Single(To build a single JAVA file.)
 *                      Button 2 : Project(To build a whole JAVA Project.)
 *
 ** On selecting Button 1 a new window appears which has two blank text fields
 *                         (i.e.   1st for Source Directory Input.
 *                                 2nd for Destination Directory Input.
 *                                 3rd for Main class name of the project you wish to compile.)
 *                         and three different sized buttons
 *                         (i.e.   Button 1 : Browse(For File Path.)
 *                                 Button 2 : Browse(For Destination Directory, where you wish to save your class file.)
 *                                 Button 3 : Build(Build the JAVA File.)
 *                                 Button 4 : Back (Takes you back to Home window))
 *
 *                          Output : Output on console is same as we compile any JAVA code using command prompt.
 **********************************************************************************************************************
 **********************************************************************************************************************
 ** On selecting Button 2 a new window appears which has three blank text fields
 *                         (i.e. 1st for Source Directory Input.
 *                               2nd for Destination Directory Input.
 *                               3rd for Main class name of the project you wish to compile.)
 *                          and three different sized buttons
 *                         (i.e. Button 1 : Browse(For File Path.)
 *                               Button 2 : Browse(For Destination Directory, where you wish to save your class file.)
 *                               Button 3 : Build(Build the JAVA File.))
 *                               Button 4 : Back (Takes you back to Home window)
 *
 *                          Output : Output on console is same as we compile any JAVA code using command prompt.
 *
 *** To do : Next version will include feature for compilation of C and C++ files.
 *
 *** Requirements : 1) Windows Platform.
 *                  2) Command Prompt.
 *                  3) JAVA Installed on System.
 *                  4) Setting Environment Variables for JAVA.
 *
 *** Number of Classes : 5
 *
 *** Name of Classes : a) Main
 *                     b) FrontPage
 *                     b)ProjectBuild
 *                     c) SingleFileBuild
 *                     d) Utils
 */


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage stage)
    {
        stage.setTitle("Java The Builder");
        new FrontPage(stage);
    }
}
