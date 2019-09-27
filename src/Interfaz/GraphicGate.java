package Interfaz;

import Estructuras.LinkedLists;
import Logica.LogicGate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GraphicGate {
    private Image gateImage;
    private int inputAmount;
    private static boolean btnClicked = false;
    public static String firstID;
    public static LogicGate transferGate = null;
    public static LogicGate receiverGate = null;
    public LogicGate currentLogic ;
    private Pane window;
    public double Coord_X;
    public double Coord_Y;
    public static boolean connectionComplete = false;
    public static LinkedLists CoordsPnt1 = new LinkedLists();
    public static LinkedLists CoordsPnt2 = new LinkedLists();


    public GraphicGate(Image image, int inputs, double coord_X, double coord_Y, LogicGate logic, Pane window){
        this.gateImage = image;
        this.inputAmount = inputs;
        this.Coord_X = coord_X;
        this.Coord_Y = coord_Y;
        this.currentLogic = logic;
        this.window = window;
    }

    public Group CreateGate(){

        Group group = new Group();

        ImageView image = new ImageView(this.gateImage);

        int ancho = 42;
        int total = ancho/inputAmount;
        int pos_Y = 0;

        group.getChildren().add(image);

        for (int i = 0; i < inputAmount; i++){
            Button button = new Button("Inp");
            button.setId("I");

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    System.out.println("Button Clicked !!");

                    if(btnClicked == false) {

                        CoordsPnt1.lastInsert(button.getLayoutX() + Coord_X);
                        CoordsPnt1.lastInsert(button.getLayoutY() + Coord_Y);
                    }
                    else{
                        CoordsPnt2.lastInsert(button.getLayoutX() + Coord_X);
                        CoordsPnt2.lastInsert(button.getLayoutY() + Coord_Y);
                    }

                    ConnectionManager(button.getId());


                }
            });

            button.setLayoutY(pos_Y);

            group.getChildren().add(button);

            pos_Y = pos_Y + total*2;


        }

        Button outBtn = new Button("Out");
        outBtn.setId("O");
        outBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Button Clicked !!");

                if(btnClicked == false) {

                    CoordsPnt1.lastInsert(outBtn.getLayoutX() + Coord_X);
                    CoordsPnt1.lastInsert(outBtn.getLayoutY() + Coord_Y);

                }
                else{
                    CoordsPnt2.lastInsert(outBtn.getLayoutX() + Coord_X);
                    CoordsPnt2.lastInsert(outBtn.getLayoutY() + Coord_Y);
                }

                ConnectionManager(outBtn.getId());

                event.getSource();

            }
        });

        outBtn.setLayoutY(20);
        outBtn.setLayoutX(130);

        group.getChildren().add(outBtn);

        group.setLayoutX(this.Coord_X);
        group.setLayoutY(this.Coord_Y);

        return group;

    }

    public void ConnectionManager(String ID){
        if (ID == "I"){
            System.out.println("...Is an input");
            if (this.btnClicked == false){
                this.btnClicked = true;
                receiverGate = this.currentLogic;
                firstID = ID;

            }
            else{
                if (firstID == "O") {
                    receiverGate = this.currentLogic;
                    transferGate.connection(receiverGate,this.inputAmount);

                    System.out.println("Conexión completada exitosamente!");
                    LineCreator(window, (double) CoordsPnt1.get(0), (double)CoordsPnt1.get(1), (double)CoordsPnt2.get(0), (double)CoordsPnt2.get(1));
                }

                else {
                    System.out.println("Debe conectar output con input");
                    CoordsPnt1 = null;
                    CoordsPnt2 = null;
                }
                transferGate = null;
                receiverGate = null;
                btnClicked = false;
                firstID = null;
            }

        }

        else{
            System.out.println("...Is an output");
            if (this.btnClicked == false){
                this.btnClicked = true;
                this.transferGate = currentLogic;
                firstID = ID;
            }
            else{
                if(firstID == "I") {
                    transferGate = currentLogic;
                    transferGate.connection(receiverGate,inputAmount);

                    System.out.println("Conexión completada exitosamente!");
                    LineCreator(window, (double) CoordsPnt1.get(0), (double)CoordsPnt1.get(1), (double)CoordsPnt2.get(0), (double)CoordsPnt2.get(1));


                }
                else {
                    System.out.println("Debe conectar output con input");
                    CoordsPnt1 = null;
                    CoordsPnt2 = null;
                }

                transferGate = null;
                receiverGate = null;
                btnClicked = false;
                firstID = null;

            }

        }

    }

    public void LineCreator (Pane window, double X1, double Y1, double X2, double Y2 ){
        Line line = new Line();
        line.setStartX(X1);
        line.setStartY(Y1);
        line.setEndX(X2);
        line.setEndY(Y2);
        //line.setStroke(Color.ORANGE);

        window.getChildren().add(line);

        CoordsPnt1 = new LinkedLists();
        CoordsPnt2 = new LinkedLists();
        connectionComplete = false;

    }

}
