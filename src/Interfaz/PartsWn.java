package Interfaz;

import Estructuras.LinkedLists;
import Estructuras.Node;
import Logica.LogicGate;

import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;



public class PartsWn {
    Image andImage = new Image("images/and.png");
    Image orImage = new Image("images/or.png");
    Image nandImage = new Image("images/nand.png");
    Image norImage = new Image("images/nor.png");
    Image notImage = new Image("images/not.png");
    Image xnorImage = new Image("images/xnor.png");
    Image xorImage = new Image("images/xor.png");
    double mousePosX;
    double mousePosY;

    LinkedLists lista1=new LinkedLists();


    public VBox addVBox(int width, int height, int spacing, String color, VBox wind) {
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
                    button.setOnMouseMoved(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            mousePosX = event.getX();
                            System.out.println(mousePosX);
                            mousePosY = event.getY();
                            System.out.println(mousePosY);


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
                LogicGate comp0 = new LogicGate();
                LogicGate comp1 = new LogicGate();
                LogicGate comp2 = new LogicGate();
                LogicGate comp3 = new LogicGate();

                comp1.connection(comp2);
                comp3.connection(comp2);

                LogicGate a = (LogicGate) comp2.connections.get(0);
                System.out.println(a.gateID);

            }
        });


        vbox.getChildren().add(readyBtn);

        return vbox;
    }

}