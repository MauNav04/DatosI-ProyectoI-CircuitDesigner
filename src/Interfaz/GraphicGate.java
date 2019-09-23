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
        Button button1 = new Button("Buton 1");
        button1.setLayoutY(20);
        Button button2 = new Button("Button 2");

        group.getChildren().addAll(image,button1,button2);
        group.setLayoutX(this.Coord_X);
        group.setLayoutY(this.Coord_Y);

        return group;

    }

}
