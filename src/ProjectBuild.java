/**Class Name : ProjectBuild
 * Class Methods : ProjectBuild(Constructor)
 * Function : This class creates the Project Building layout page of the Project.
 * JAVAFX Nodes Present in Class :  a) Border Pane.
 *                                  b) Grid Pane.
 *                                  c) Text Field : (i) singleFileInputPath (For Input Path Directory).
 *                                                  (ii) className (For Main Class Name).
 *                                  d) HBox(Horizontal Box) - to set Title on it and then on top of border pane.
 *                                  e) Button : (i) Browse
 *                                                  (Opens a New Stage with directory selector).
 *                                              (ii) Build
 *                                                  (Build the selected File and opens Output console).
 *                                              (iii) Back
 *                                                   (Goes Back to FrontPage).
 *
 */
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class ProjectBuild {

    private static Rectangle2D rectangle2D = Screen.getPrimary().getVisualBounds();
    private static double width = rectangle2D.getWidth();
    private static double height = rectangle2D.getHeight();

    Font font = new Font(22);
    GridPane grid;
    BorderPane borderPane;

    ProjectBuild(Stage stage)
    {
        borderPane = new BorderPane();

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        TextField singleFileInputPath = new TextField();
        singleFileInputPath.setStyle("-fx-opacity: 1.0;");
        singleFileInputPath.setFont(font);
        singleFileInputPath.setPrefSize(300, 50);
        Button singleInputBrowse = new Button("Browse");
        singleInputBrowse.setPrefSize(300,20);

        TextField className = new TextField();
        className.setStyle("-fx-opacity: 1.0;");
        Font font = new Font(22);
        className.setFont(font);
        className.setPrefSize(300,50);
        className.setPromptText("--Name of Main Class--");

        Button buildButton = new Button("Build");
        buildButton.setPrefWidth(300);
        //Setting ID for CSS File.
        buildButton.setId("build");

        Button backButton = new Button("Back");
        backButton.setPrefWidth(300);
        //Setting ID for CSS File.
        backButton.setId("back");

        GridPane.setColumnSpan(className,3);
        GridPane.setColumnSpan(buildButton, 3);

        singleFileInputPath.setPrefWidth(200);

        singleFileInputPath.setDisable(true);

        singleFileInputPath.setPromptText("-- file input path--");


        singleInputBrowse.setPrefWidth(200);


        grid.add(singleFileInputPath, 0, 0);
        grid.add(singleInputBrowse, 2, 0);


        grid.add(className,0,1);
        grid.add(buildButton, 0, 2);
        grid.add(backButton, 0, 3);

        borderPane.setCenter(grid);

        singleInputBrowse.setOnAction(e -> {

            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory = directoryChooser.showDialog(stage);
            if (selectedDirectory != null) {
                singleFileInputPath.setText(selectedDirectory.getAbsolutePath());
            }
        });



        buildButton.setOnAction(e -> {
                String classNm = className.getText();
               // System.out.println("Class Name : " + classNm);
                String src = singleFileInputPath.getText();
                //System.out.println("Input path : " + src);

                new Utils().compileRunJavaProject(src, classNm);

            });

        backButton.setOnAction(e -> {new FrontPage(stage);
        });
    }
}
