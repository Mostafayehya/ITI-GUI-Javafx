package Day2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LifecycleExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public LifecycleExample() {
        String name = Thread.currentThread().getName();
        System.out.println("Constructor() method: current thread " + name);
    }

    @Override
    public void init() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("init() method: current thread " + name);

        super.init();
    }


    @Override
    public void start(Stage stage) throws Exception {

        String name = Thread.currentThread().getName();
        System.out.println("start() method: current thread " + name);

        StackPane root = new StackPane();
        Text text = new Text("Hello life Cycle");
        text.setId("text");

        root.getChildren().add(text);
        Scene scene = new Scene(root, 300, 250);
        //todo fix Failed to execute goal org.openjfx:javafx-maven-plugin:0.0.5:run
        // (default-cli) on project IPResolver: Error
        scene.getStylesheets().add(getClass().getResource("/styles.css").toString());
        // text.getStyleClass().add("root");
        stage.setTitle("LifeCycle Example");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        String name = Thread.currentThread().getName();
        System.out.println("Stop() method: current thread " + name);
        super.stop();
    }
}
