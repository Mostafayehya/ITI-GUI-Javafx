package Day2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TestGradient extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        final Scene scene = new Scene(root,300, 300); Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(1, Color.WHITE)};
        LinearGradient linear = new LinearGradient(0, 0, 0, 0.5, true, CycleMethod.REFLECT, stops);


        Rectangle rect = new Rectangle(0, 0, 300, 300);
        rect.setFill(linear);
        root.getChildren().add(rect);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Animation Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
