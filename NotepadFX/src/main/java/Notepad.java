import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Notepad extends Application {

    FileChooser fileChooser = new FileChooser();

    @Override
    public void init() throws Exception {
        super.init();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
    }

    @Override
    public void start(Stage stage) throws Exception {

        MenuBar bar = new MenuBar();

        // File
        Menu fileMenu = new Menu("_File");
        MenuItem newItem = new MenuItem("New");
        newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        newItem.setOnAction(e -> {
            //Creating a File chooser
            fileChooser.setTitle("New File");
            fileChooser.setInitialFileName("Mostafa.txt");
            fileChooser.showSaveDialog(stage);

        });
        MenuItem openItem = new MenuItem("Open");
        openItem.setOnAction(actionEvent -> {
            fileChooser.setTitle("Open File");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
            fileChooser.showOpenDialog(stage);
        });
        openItem.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));
        MenuItem saveItem = new MenuItem("Save");
        saveItem.setOnAction(actionEvent -> {
            fileChooser.setTitle("Save File");
            fileChooser.setInitialFileName("SaveMostafa.txt");
            fileChooser.showSaveDialog(stage);
        });
        saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(actionEvent -> {
            stage.close();
        });
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+e"));
        fileMenu.getItems().addAll(newItem,new SeparatorMenuItem(), openItem, saveItem,new SeparatorMenuItem(), exitItem);

        // Edit
        Menu editMenu = new Menu("_Edit");
        MenuItem undoItem = new MenuItem("Undo");
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pastItem = new MenuItem("Past");
        MenuItem deleteItem = new MenuItem("Delete");
        MenuItem selectAllItem = new MenuItem("Select all");
        editMenu.getItems().addAll(undoItem, cutItem, copyItem, pastItem, deleteItem, selectAllItem);

        // Help
        Menu helpMenu = new Menu("_Help");
        MenuItem about = new MenuItem("About");
        helpMenu.getItems().add(about);

        // TextArea
        TextArea editor = new TextArea();

        bar.getMenus().addAll(fileMenu, editMenu, helpMenu);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(bar);
        borderPane.setCenter(editor);

        Scene scene = new Scene(borderPane, 600, 600);
        stage.setScene(scene);
        stage.setTitle("NotepadFX");
        stage.show();
    }
}
