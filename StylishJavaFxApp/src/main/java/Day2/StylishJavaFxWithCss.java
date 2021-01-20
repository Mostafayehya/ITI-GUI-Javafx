package Day2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StylishJavaFxWithCss extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        root.setId("root");
        Text text = new Text("Stylish with CSS");
        text.setId("text");

        Scene scene = new Scene(root, 300, 300);
        root.getChildren().add(text);

        scene.getStylesheets().add("/styles/styles.css");

        stage.setTitle("Stylish with CSS");
        stage.setScene(scene);
        stage.show();
    }

}
