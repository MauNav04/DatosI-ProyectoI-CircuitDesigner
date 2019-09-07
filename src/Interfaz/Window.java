package Interfaz;

import Estructuras.ListaEnlazada;
import Estructuras.Node;
import javafx.application.*;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.*;

public class Window extends Application {

    Stage window;
    Image andImage = new Image("images/and.png");
    Estructuras.Node nodeOne = new Node(andImage);
    Image orImage = new Image("images/or.png");
    Image nandImage = new Image("images/nand.png");
    Image norImage = new Image("images/nor.png");
    Image notImage = new Image("images/not.png");
    Image xnorImage = new Image("images/xnor.png");
    Image xorImage = new Image("images/xor.png");


    private VBox addVBox() {

        VBox vbox = new VBox();
        vbox.setPrefSize(200,700);
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #336699;");


        for (int i= 0; i == 7; i++ ){

        }

        ImageView iv = new ImageView();
        iv.setImage(andImage);

        vbox.getChildren().add(iv);

        return vbox;
    }


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

        VBox rightSide = addVBox();
        mainPane.setRight(rightSide);

        // Crear menú en la parte superior
        Menu infoMenu = new Menu("Info");
        infoMenu.getItems().add(new MenuItem("Credits"));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(infoMenu);
        mainPane.setTop(menuBar);




        window.setScene(mainScene);
        window.show();
    }
}
