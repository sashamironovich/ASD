package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Controller {

    private FileChooser fileChooser = new FileChooser();
    private File file;

     int currSize = 13;
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
    private MenuButton fontButton;

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

        textArea.setStyle("-fx-font-family: " +this.font+ " ;-fx-font-size: "+size+"px; -fx-text-fill: " + color +" ;  -fx-text-alignment: right");
        System.out.println(textArea.getSelectedText());
        this.currSize++;
        sizeButton.setText(Integer.toString(currSize));


    }

    @FXML
    void boldButtonHandle(ActionEvent event) {

    }

    @FXML
    void closeButtonHandle(ActionEvent event) {
        Platform.exit();
    }


    @FXML
    void colorButtonHandle(MouseEvent event) {
        colorButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setStyle("-fx-font-family: " +font+ " ;-fx-font-size: "+ currSize +"px; -fx-text-fill: "+ toRGBCode(colorButton.getValue()));
                color = toRGBCode(colorButton.getValue());
                //textArea.setStyle("-fx-font-currSize: "+currSize+"px");
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
        this.currSize = 12;
        sizeButton.setText(Integer.toString(currSize));

    }

    @FXML
    void font16Handle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: " +font+ " ;-fx-font-size: 16px; -fx-text-fill: "+color );
        this.currSize = 16;
        sizeButton.setText(Integer.toString(currSize));

    }

    @FXML
    void font20Handle(ActionEvent event) {
        textArea.setStyle("-fx-font-family: " +font+ " ;-fx-font-size: 20px; -fx-text-fill: "+color );
        this.currSize = 20;
        sizeButton.setText(Integer.toString(currSize));

    }

    @FXML
    void fontButtonHandle(ActionEvent event) {
        String choice = ((MenuItem) event.getSource()).getId();

        switch (choice) {
            case "fontTNE":
                textArea.setStyle("-fx-font-family: 'Times New Roman' ; -fx-font-size: "+ currSize +"px; -fx-text-fill: "+color );
                fontButton.setText("Times New Roman");
                font = "Times New Roman";
                break;
            case "fontTahoma":
                textArea.setStyle("-fx-font-family: 'Tahoma' ; -fx-font-size: "+ currSize +"px; -fx-text-fill: "+color );
                fontButton.setText("Tahoma");
                font = "Tahoma";
                break;
            case "fontCourier":
                textArea.setStyle("-fx-font-family: 'Courier New' ; -fx-font-size: "+ currSize +"px; -fx-text-fill: "+color );
                fontButton.setText("Courier New");
                font = "Courier New";
                break;
            default:
                textArea.setStyle("-fx-font-family: 'Courier New' ; -fx-font-size: "+ currSize +"px; -fx-text-fill: "+color );
                font = "Courier New";
        }


    }



    @FXML
    void italicButtonHandle(ActionEvent event) {

    }

    @FXML
    void newButtonHandle(ActionEvent event) {
        textArea.clear();
        Stage stage = (Stage) textArea.getScene().getWindow();
        stage.setTitle("Untitled - Notepad");
        file = null;

    }

    @FXML
    void openButtonHandle(ActionEvent event) {
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Stage stage = (Stage) textArea.getScene().getWindow();
            stage.setTitle(file.getName() + " - Notepad");
            BufferedReader br = null;
            try {
                String sCurrentLine;
                br = new BufferedReader(new FileReader(file));
                while ((sCurrentLine = br.readLine()) != null) {
                    textArea.appendText(sCurrentLine + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void printButtonHandle(ActionEvent event) {
        Text extractedText = new Text(textArea.getText());
        extractedText.setWrappingWidth(450);

        // use pane to place the text
        StackPane container = new StackPane(extractedText);
        container.setAlignment(Pos.TOP_LEFT);

        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null && printerJob.showPageSetupDialog(textArea.getScene().getWindow())
                && printerJob.showPrintDialog(textArea.getScene().getWindow())) {

            if (printerJob.printPage(container)) {
                printerJob.endJob();
            } else {
                System.out.println("Failed to print");
            }
        } else {
            System.out.println("Canceled");
        }

    }

    @FXML
    void saveButtonHandle(ActionEvent event) {
        file = fileChooser.showSaveDialog(null);

        String content = textArea.getText();
        if (file != null) {
            Stage stage = (Stage) textArea.getScene().getWindow();
            stage.setTitle(file.getName() + " - Notepad");
            try {
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
        this.currSize--;
        sizeButton.setText(Integer.toString(currSize));


    }

    @FXML
    void underlineButtonHandle(ActionEvent event) {

    }

}
