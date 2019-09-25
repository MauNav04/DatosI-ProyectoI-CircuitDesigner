import Estructuras.LinkedLists;
import Interfaz.DragAndDrop;
import Interfaz.GraphicGate;
import Interfaz.PartsWn;

import Logica.LogicGate;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Collection;


public class Main extends Application {
    Stage window;
    BorderPane mainPane;
    VBox source;
    Pane center;
    Image andImage = new Image("images/and.png");
    Image orImage = new Image("images/or.png");
    Image nandImage = new Image("images/nand.png");
    Image norImage = new Image("images/nor.png");
    Image notImage = new Image("images/not.png");
    Image xnorImage = new Image("images/xnor.png");
    Image xorImage = new Image("images/xor.png");
    double mousePosX;
    double mousePosY;
    int inputAmount = 3;
    LogicGate internalLogic;

    LinkedLists lista1=new LinkedLists();


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


        source = addVBox(200,700,8, "-fx-background-color:#A6DF34");
        mainPane.setRight(source);

        center = new Pane();
        mainPane.setCenter(center);




        // Crear menú en la parte superior
        Menu infoMenu = new Menu("Info");
        infoMenu.getItems().add(new MenuItem("Credits"));

        Menu settingsMenu = new Menu("Settings");
        settingsMenu.getItems().add(new MenuItem("Input amount"));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(infoMenu,settingsMenu);
        mainPane.setTop(menuBar);

        window.setScene(mainScene);
        window.show();

    }

    public VBox addVBox(int width, int height, int spacing, String color) {
        this.lista1.insert(xorImage);
        this.lista1.insert(xnorImage);
        this.lista1.insert(notImage);
        this.lista1.insert(norImage);
        this.lista1.insert(nandImage);
        this.lista1.insert(orImage);
        this.lista1.insert(andImage);
        System.out.println("Si lo ejecuta" + "-fx-background-color: #336699;");

        VBox vbox = new VBox();
        vbox.setPrefSize(width, height);
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(spacing);
        vbox.setStyle(color);

        for (int i = 0; i != 7; i++) {

            ImageView iv = new ImageView();
            Image imagen = (Image) this.lista1.get(i);
            iv.setImage(imagen);

            Button button = new Button();
            button.setGraphic(iv);
            button.setPrefSize(150,80);

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("A gate has been clicked !!");
                    center.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            mousePosX = event.getX();
                            System.out.println("Click X on: " + mousePosX);
                            mousePosY = event.getY();
                            System.out.println("Click Y on: " + mousePosY);

                           double selectedX = valid_X(mousePosX);
                           double selectedY = valid_Y(mousePosY);


                            System.out.println("SelecX: "+selectedX);
                            System.out.println("SelecY: "+selectedY);

                           if(selectedX < 583 && selectedY < 635) {
                               LogicGate logicGate = new LogicGate(inputAmount);
                               internalLogic = logicGate;

                               GraphicGate newGate = new GraphicGate(imagen,inputAmount,selectedX,selectedY,internalLogic);
                               center.getChildren().addAll(newGate.CreateGate());

                               System.out.println("Gate ID: " + logicGate.gateID);

                           }
                           else{
                               System.out.println("Fuera del rango");
                           }

                        }
                    });

                }
            });



            vbox.getChildren().add(button);



        }

        Button readyBtn = new Button("Test Circuit");
        readyBtn.setPrefSize(150, 20);

        readyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LogicGate comp0 = new LogicGate(inputAmount);
                LogicGate comp1 = new LogicGate(inputAmount);
                LogicGate comp2 = new LogicGate(inputAmount);
                LogicGate comp3 = new LogicGate(inputAmount);

                comp1.connection(comp2);
                comp3.connection(comp2);

                LogicGate a = (LogicGate) comp2.connections.get(0);
                System.out.println(a.gateID);

            }
        });


        vbox.getChildren().add(readyBtn);

        return vbox;
    }

   public ImageView placeImage (Image image, double coordX, double coordY){
       ImageView newIV = new ImageView(image);
       newIV.setX(coordX);
       newIV.setY(coordY);

       center.getChildren().add(newIV);
       return newIV;
   }

   public double valid_X (double value){
        if (value <= 583){
            if(value <= 410){
                return value;

            }
            else{
                double newValue = 410;
                return newValue;
            }
        }

        value++;
        return value;

   }

   public double valid_Y (double value){
       if (value <= 635){
           if(value <= 550){
               return value;

           }
           else{
               double newValue = 550;
               return newValue;
           }
       }

       value ++;
       return value;
   }


    public static void main (String[] args) {
        launch(args);
    }
}
