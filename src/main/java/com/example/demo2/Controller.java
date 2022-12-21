package com.example.demo2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.SetChangeListener;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Button convertBtn;
    public ChoiceBox<String> conversionChoise;
    public TextArea resultTxtarea;
    public Label welcomeLabel;
    private final String  f_to_c = "Farenhit to celsius";
    private final  String c_to_f = "celsius to Farenhit";
    private boolean isCtoF = true;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        convertBtn.setOnAction(event -> {
            convert();
        });


        conversionChoise.getItems().add(f_to_c);
        conversionChoise.getItems().add(c_to_f);
        conversionChoise.setValue(c_to_f);
        conversionChoise.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if(newValue == c_to_f){
                    isCtoF=true;
                    System.out.println();

                }else isCtoF=false;



            }
        });
    }

    private void convert() {
        String input=resultTxtarea.getText();
        float userinput=0f;

        try{
            userinput=Float.parseFloat(input);
        }
        catch (Exception e){
            alerUser();
            return;
        }

        float result=0f;



        if(isCtoF){
            result=userinput*(9/5)+32;

        }
        else{ result = userinput*(5/9)-32;
        }


        display(result);}




    private void alerUser() {
        Alert warningAlert=new Alert(Alert.AlertType.WARNING);
        warningAlert.setTitle("Invalid Input");
        warningAlert.setHeaderText("Error");
        warningAlert.setContentText("Please Enter a Valid Value");
        warningAlert.show();
        resultTxtarea.clear();


    }

    private void display(float result) {
        String unit= isCtoF? " Ferenhite":" Celsius";
        Alert resultAlert=new Alert(Alert.AlertType.INFORMATION);
        resultAlert.setTitle(unit);
        resultAlert.setHeaderText("Conversion");
        resultAlert.setContentText("The Result is "+result+unit);
        resultAlert.show();

    }
}
