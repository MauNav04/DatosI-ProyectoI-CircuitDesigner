import Estructuras.LinkedLists;
import Interfaz.DragAndDrop;
import Interfaz.PartsWn;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    Stage window;
    BorderPane mainPane;
    VBox source;
    ImageView imageView;
    VBox center;
    Image andImage = new Image("images/and.png");


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Circuit Designer");
        window.setWidth(800);
        window.setHeight(700);
        window.setResizable(false);
        window.getIcons().add(new Image("images/Logo.png"));

        mainPane = new BorderPane();
        Scene mainScene = new Scene (mainPane,800,700);

        PartsWn rightSide = new PartsWn();
        mainPane.setRight(rightSide.addVBox());


        center = new VBox();
        mainPane.setCenter(center);

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
