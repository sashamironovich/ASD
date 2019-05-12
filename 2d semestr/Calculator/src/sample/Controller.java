package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button zero;

    @FXML
    private Button clearLine;

    @FXML
    private Button equals;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Button multiply;

    @FXML
    private Button divide;

    @FXML
    private TextField display;

    @FXML
    private Button dot;

    @FXML
    private Button sin;

    @FXML
    private Button cos;

    @FXML
    private Button tan;

    @FXML
    private Button ctg;

    @FXML
    private Button percent;

    @FXML
    private Button sqrt;

    @FXML
    private Button pi;

    @FXML
    private Button euler;

    @FXML
    private Button ln;

    @FXML
    private Button answer;


    boolean point = false;
    double number1;
    double number2;
    double result = 0;
    int op;
    boolean answOnScr = false;



    @FXML
    public void handleAction(ActionEvent event) {

        if(event.getSource() == one){

            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "1");
            else display.setText("1");
            answOnScr = false;
        }
        else if(event.getSource() == two){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "2");
            else display.setText("2");
            answOnScr = false;
        }
        else if(event.getSource() == three){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "3");
            else display.setText("3");
            answOnScr = false;
        }
        else if(event.getSource() == four){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "4");
            else display.setText("4");
            answOnScr = false;
        }
        else if(event.getSource() == five){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "5");
            else display.setText("5");
            answOnScr = false;
        }
        else if(event.getSource() == six){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "6");
            else display.setText("6");
            answOnScr = false;
        }
        else if(event.getSource() == seven){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "7");
            else display.setText("7");
            answOnScr = false;
        }
        else if(event.getSource() == eight){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "8");
            else display.setText("8");
            answOnScr = false;
        }
        else if(event.getSource() == nine){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "9");
            else display.setText("9");
            answOnScr = false;
        }
        else if(event.getSource() == zero){
            if(display.getText().equals("0"))display.setText("");
            else if(!answOnScr)display.setText(display.getText() + "0");
            else display.setText("0");
            answOnScr = false;
        }
        else if(event.getSource() == dot){
            if(!answOnScr)display.setText(display.getText() + "0");
            else display.setText("0.");
            answOnScr = false;
            point = true;
        }
        else if(event.getSource() == plus){
            op = 1;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }

        else if(event.getSource() == minus){
            op = 2;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }
        else if(event.getSource() == multiply){
            op = 3;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }else if(event.getSource() == divide){
            op = 4;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }

        else if(event.getSource() == sin){
            op = 5;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }

        else if(event.getSource() == cos){
            op = 6;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }

        else if(event.getSource() == tan){
            op = 7;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }

        else if(event.getSource() == ctg){
            op = 8;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }
        else if(event.getSource() == percent){
            op = 9;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }
        else if(event.getSource() == sqrt){
            op = 10;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }
        else if(event.getSource() == pi){
            op = 8;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }
        else if(event.getSource() == euler){
            op = 8;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }
        else if(event.getSource() == ln){
            op = 8;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }
        else if(event.getSource() == answer){
            op = 8;
            number1 = Double.parseDouble(display.getText());
            display.setText("");
            point = false;
        }


        else if(event.getSource() == clearLine){
            display.setText("0");
            
            point = false;
        }
        else if(event.getSource() == equals){
            //if (number1 == 0)return;
            number2 = Double.parseDouble(display.getText());
            point = false;
            switch (op){
                case 1 : result = number1 + number2;
                break;
                case 2 : result = number1 - number2;
                break;
                case 3 : result = number1 * number2;
                break;
                case 4 : result = number1 / number2;
                break;
                default: result = 0;
                break;
            }
            String res = String.valueOf(result);
            if(res.length()>10)res = res.substring(0,10);
            if( res.endsWith(".0")){
                int index = res.indexOf('.');
                res = res.substring(0,index);
            }
            display.setText(res);
            answOnScr = true;

        }






    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
