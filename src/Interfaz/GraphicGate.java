package Interfaz;

import Logica.LogicGate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GraphicGate {
    private Image gateImage;
    private int inputAmount;
    private static boolean btnClicked = false;
    public static LogicGate transferGate = null;
    public static LogicGate receiverGate = null;
    public LogicGate currentLogic ;
    public double Coord_X;
    public double Coord_Y;

    public GraphicGate(Image image, int inputs, double coord_X, double coord_Y, LogicGate logic){
        this.gateImage = image;
        this.inputAmount = inputs;
        this.Coord_X = coord_X;
        this.Coord_Y = coord_Y;
        this.currentLogic = logic;
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
                ConnectionManager(outBtn.getId());
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
            }
            else{
                receiverGate = this.currentLogic;
                transferGate.connection(receiverGate);

                LogicGate test1 = (LogicGate) receiverGate.connections.getFirst().getInfo();
                System.out.println("Gate ID conn: " +  test1.gateID);

                transferGate = null;
                receiverGate = null;
                btnClicked = false;
            }

        }

        else{
            System.out.println("...Is an output");
            if (this.btnClicked == false){
                this.btnClicked = true;
                this.transferGate = currentLogic;
            }
            else{
                transferGate = currentLogic;
                this.transferGate.connection(receiverGate);

                LogicGate test1 = (LogicGate) receiverGate.connections.getFirst().getInfo();
                System.out.println("Gate ID: " +  test1.gateID);

                transferGate = null;
                receiverGate = null;
                btnClicked = false;
            }

        }


    }

}
