/**Class Name : SingleFileBuild
 * Class Methods : FrontPage(Constructor)
 * Function : This class creates the basic layout of the Main Page of Project.
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
 */
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.DirectoryChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;


public class SingleFileBuild {

    private static Rectangle2D rectangle2D = Screen.getPrimary().getVisualBounds();
    private static double width = rectangle2D.getWidth();
    private static double height = rectangle2D.getHeight();

    GridPane grid;
    BorderPane borderPane;
    Font font = new Font(22);

    SingleFileBuild(Stage stage)
    {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        borderPane = new BorderPane();

        TextField singleFileInputPath = new TextField();

        singleFileInputPath.setStyle("-fx-opacity: 1.0;");
        singleFileInputPath.setFont(font);
        singleFileInputPath.setPrefSize(300, 50);
        singleFileInputPath.setPrefWidth(200);

        Button singleInputBrowse = new Button("Browse");

        TextField fileName = new TextField();

        fileName.setStyle("-fx-opacity: 1.0;");
        fileName.setFont(font);
        fileName.setPrefSize(300, 50);

        Button buildButton = new Button("Build");

        buildButton.setPrefWidth(300);
        GridPane.setColumnSpan(buildButton,2);
        buildButton.setId("build");

        Button backButton = new Button("Back");

        backButton.setPrefWidth(300);
        backButton.setId("back");

        fileName.setPrefWidth(200);
        singleFileInputPath.setDisable(true);
        fileName.setDisable(false);
        singleFileInputPath.setPromptText("-- file input path--");
        fileName.setPromptText("--file name--");

        singleInputBrowse.setPrefWidth(200);

        grid.add(singleFileInputPath,0,0);
        grid.add(singleInputBrowse,1,0);

        grid.add(fileName,0,1);
        grid.add(buildButton,0,2);
        grid.add(backButton,0,3);

        borderPane.setCenter(grid);
        Scene scene = new Scene(borderPane, 0.5 * width, 0.5 * height);

        singleInputBrowse.setOnAction(e->{

            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory = directoryChooser.showDialog(stage);
            if (selectedDirectory != null) {
                singleFileInputPath.setText(selectedDirectory.getAbsolutePath());
            }
        });

        buildButton.setOnAction(e->{
            new Utils().compileRunSingleJavaFile(singleFileInputPath.getText(), fileName.getText());
        });

        backButton.setOnAction(e -> {new FrontPage(stage);
        });
    }
}
