/**Class Name : FrontPage
 * Class Methods : FrontPage(Constructor)
 * Function : This class creates the basic layout of the Main Page of Project.
 * JAVAFX Nodes Present in Class :  a) Border Pane.
 *                                  b) Grid Pane.
 *                                  c) Label(For Title)
 *                                  d) HBox(Horizontal Box) - to set Title on it and then on top of border pane.
 *                                  e) Button : (i) Single.
 *                                              (ii) Project.
 */

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

//-------------------------------------Class Body Starts------------------------------------------------------------
public class FrontPage
{
    /**Rectangle declared here gives us the basic screen size and helps us to manipulate with the size as many
     * times as we want. We declared the rectangle to be the normal screen size initially.
     */
    //Rectangle Declaration and getting screen dimensions( "Screen.getPrimary().getVisualBounds()" )
    private static Rectangle2D rectangle2D = Screen.getPrimary().getVisualBounds();
    private static double width = rectangle2D.getWidth();
    private static double height = rectangle2D.getHeight();

    //Variable Declaration( Globally Declared )
    private GridPane gridPane;
    private BorderPane borderPane;

    FrontPage(Stage stage)
    {
        //Constructor of Label Class has been called.
        Label title = new Label("JAVA THE BUILDER");

        //Grid Pane to set buttons and other elements over it.
        gridPane = new GridPane();
        //Aligning GridPane to center.
        gridPane.setAlignment(Pos.CENTER);

        //borderPane Constructor called.
        borderPane = new BorderPane();

        //Setting ID for CSS File
        title.setId("title");

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        //??hboxName_.getChildren().add(Node);
        hbox.getChildren().add(title);

        borderPane.setTop(hbox);

        //--Gridpane customisation starts.
        gridPane.setHgap(25);
        gridPane.setAlignment(Pos.CENTER);

        //Button Declarartion
        Button single = new Button("Single");
        Button project = new Button("Project");

        //setPrefSize(prefWidth, prefHeight)
        single.setPrefSize(150, 100);
        project.setPrefSize(150, 100);

        //Adding Nodes to Grid Pane.
        gridPane.add(single, 0, 0);
        gridPane.add(project, 1, 0);

       gridPane.setGridLinesVisible(true);

        single.setOnAction(e -> {
            borderPane.setCenter(new SingleFileBuild(stage).grid);
        });
        project.setOnAction(e -> {
            borderPane.setCenter(new ProjectBuild(stage).grid);
        });

        borderPane.setCenter(gridPane);
        width = width * 0.75;
        height = height * 0.75;
        Scene scene = new Scene(borderPane, width, height);
        //Adding CSS File to JAVAFX Code.
        scene.getStylesheets().add("JAVA_CSS.css");

        stage.setScene(scene);

        stage.setResizable(true);

        stage.show();
    }
}