package Interfaz;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GraphicGate {
    private Image gateImage;
    private int inputAmount;
    public double Coord_X;
    public double Coord_Y;

    public GraphicGate(Image image, int inputs, double coord_X, double coord_Y){
        this.gateImage = image;
        this.inputAmount = inputs;
        this.Coord_X = coord_X;
        this.Coord_Y = coord_Y;
    }

    public Group CreateGate(){
        System.out.println("Till here");

        Group group = new Group();

        ImageView image = new ImageView(this.gateImage);


        int ancho = 42;
        int total = ancho/inputAmount;
        int pos_Y = 0;

        group.getChildren().add(image);

        for (int i = 0; i < inputAmount; i++){
            Button button = new Button("Inp");
            System.out.println("Pos Y:" + Integer.toString(pos_Y));
            button.setLayoutY(pos_Y);

            group.getChildren().add(button);

            pos_Y = pos_Y + total*2;
        }

        System.out.println("trama pura");
        group.setLayoutX(this.Coord_X);
        group.setLayoutY(this.Coord_Y);

        return group;

    }

}
