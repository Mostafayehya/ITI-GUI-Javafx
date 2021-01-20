package Day2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StylishJavaFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        StackPane root = new StackPane();
        Text text = new Text("Hello Stylish");
        text.setId("text");

        Reflection reflection = new Reflection();
        text.setEffect(reflection);

        Scene scene = new Scene(root, 300, 300);

        Stop[] stops = new Stop[]{new Stop(0, Color.BLACK), new Stop(1, Color.WHITE)};
        LinearGradient linear = new LinearGradient(0, 0, 0, 0.5, true, CycleMethod.REFLECT, stops);
        scene.setFill(linear);

        root.getChildren().add(text);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toString());

        stage.setTitle("Stylish lab");
        stage.setScene(scene);
        stage.show();
    }
}
