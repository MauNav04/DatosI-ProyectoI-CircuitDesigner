import Estructuras.LinkedLists;
import Interfaz.PartsWn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Circuit Designer");
        window.setWidth(800);
        window.setHeight(700);
        window.setResizable(false);
        window.getIcons().add(new Image("images/Logo.png"));

        BorderPane mainPane = new BorderPane();
        Scene mainScene = new Scene (mainPane,800,700);

        PartsWn rightSide = new PartsWn();
        mainPane.setRight(rightSide.addVBox());

        // Crear menú en la parte superior
        Menu infoMenu = new Menu("Info");
        infoMenu.getItems().add(new MenuItem("Credits"));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(infoMenu);
        mainPane.setTop(menuBar);

        window.setScene(mainScene);
        window.show();

    }

    public static void main (String[] args) {
        launch(args);
    }
}
