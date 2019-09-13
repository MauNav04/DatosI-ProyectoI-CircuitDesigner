package Interfaz;

import Estructuras.LinkedLists;
import Estructuras.Node;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;



public class PartsWn {
    Image andImage = new Image("images/and.png");
    Image orImage = new Image("images/or.png");
    Image nandImage = new Image("images/nand.png");
    Image norImage = new Image("images/nor.png");
    Image notImage = new Image("images/not.png");
    Image xnorImage = new Image("images/xnor.png");
    Image xorImage = new Image("images/xor.png");

    LinkedLists lista1=new LinkedLists();


    public VBox addVBox() {
        this.lista1.insert(xorImage);
        this.lista1.insert(xnorImage);
        this.lista1.insert(notImage);
        this.lista1.insert(norImage);
        this.lista1.insert(nandImage);
        this.lista1.insert(orImage);
        this.lista1.insert(andImage);
        System.out.println("Si lo ejecuta");

        VBox vbox = new VBox();
        vbox.setPrefSize(200,700);
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #336699;");

        for (int i= 0; i != 7; i++ ){

           ImageView iv = new ImageView();
           Image imagen = (Image) this.lista1.get(i);
           iv.setImage(imagen);
           vbox.getChildren().add(iv);

        }

        Button readyBtn = new Button("Test Circuit");
        readyBtn.setPrefSize(150,20);
        vbox.getChildren().add(readyBtn);

        return vbox;
    }

}