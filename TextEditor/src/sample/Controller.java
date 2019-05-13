package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controller {

     int size = 13;
     String color = "black";
     String font = "Segoe UI";

    @FXML
    private MenuItem newButton;

    @FXML
    private MenuItem openButton;

    @FXML
    private MenuItem saveButton;

    @FXML
    private MenuItem printButton;

    @FXML
    private MenuItem closeButton;

    @FXML
    private SplitMenuButton fontButton;

    @FXML
    private MenuItem fontTNE;

    @FXML
    private MenuItem fontTahoma;

    @FXML
    private MenuItem fontCourier;

    @FXML
    private SplitMenuButton sizeButton;

    @FXML
    private MenuItem font12;

    @FXML
    private MenuItem font16;

    @FXML
    private MenuItem font20;

    @FXML
    private ColorPicker colorButton;

    @FXML
    private CheckBox boldButton;

    @FXML
    private CheckBox italicButton;

    @FXML
    private CheckBox underlineButton;

    @FXML
    private Button biggerButton;

    @FXML
    private Button smallerButton;

    @FXML
    private Button dataButton;

    @FXML
    private TextArea textArea;

    @FXML
    void biggerButtonHandle(ActionEvent event) {
        Font font = textArea.getFont();
        double size = font.getSize();
        size++;
        textArea.setStyle("-fx-font-family: " +this.font+ " ;-fx-font-size: "+size+"px; -fx-text-fill: " + color);
        this.size++;

    }

    @FXML
    void boldButtonHandle(ActionEvent event) {

    }

    @FXML
    void closeButtonHandle(ActionEvent event) {

    }


    @FXML
    void colorButtonHandle(MouseEvent event) {
        colorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setStyle("-fx-font-family: " +font+ " ;-fx-font-size: "+size+"px; -fx-text-fill: "+ toRGBCode(colorButton.getValue()));
                color = toRGBCode(colorButton.getValue());
                //textArea.setStyle("-fx-font-size: "+size+"px");
            }
        });

    }

    public  String toRGBCode( Color color )
    {
        String hex2 = "#" + Integer.toHexString(colorButton.getValue().hashCode());
        return hex2.substring(0,7);
    }

    @FXML
    void dataButtonHandle(ActionEvent event) {

    }

    @FXML
    void font12Handle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: " +font+ " ;-fx-font-size: 12px; -fx-text-fill: "+color );
        this.size = 12;
    }

    @FXML
    void font16Handle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: " +font+ " ;-fx-font-size: 16px; -fx-text-fill: "+color );
        this.size = 16;
    }

    @FXML
    void font20Handle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: " +font+ " ;-fx-font-size: 20px; -fx-text-fill: "+color );
        this.size = 20;
    }

    @FXML
    void fontButtonHandle(ActionEvent event) {

    }

    @FXML
    void fontCourierHandle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: 'Courier New' ; -fx-font-size: "+size+"px; -fx-text-fill: "+color );
        font = "Courier New";

    }

    @FXML
    void fontTNEHandle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: "+size+"px; -fx-text-fill: "+color );
        font = "Times New Roman";

    }

    @FXML
    void fontTahomaHandle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: 'Tahoma' ; -fx-font-size: "+size+"px; -fx-text-fill: "+color );
        font = "Tahoma";

    }

    @FXML
    void italicButtonHandle(ActionEvent event) {

    }

    @FXML
    void newButtonHandle(ActionEvent event) {

    }

    @FXML
    void openButtonHandle(ActionEvent event) {

    }

    @FXML
    void printButtonHandle(ActionEvent event) {

    }

    @FXML
    void saveButtonHandle(ActionEvent event) {

    }

    @FXML
    void sizeButtonHandle(ActionEvent event) {

    }

    @FXML
    void smallerButtonHandle(ActionEvent event) {
        Font font = textArea.getFont();
        double size = font.getSize();
        size--;
        textArea.setStyle("-fx-font-family: " + this.font + " ;-fx-font-size: "+size+"px; -fx-text-fill: " + color);
        this.size--;

    }

    @FXML
    void underlineButtonHandle(ActionEvent event) {

    }

}
