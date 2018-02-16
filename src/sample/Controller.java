package sample;

import javafx.beans.value.ObservableValue;
import javafx.css.converter.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField nameTextField;

    @FXML
    private Label statusName;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Label statusSurname;

    @FXML
    private TextField birthYear;

    @FXML
    private CheckBox confirmCheckBox;

    @FXML
    private Label yourAgeLabel;

    @FXML
    private Button loginBtn;

    private Person person = new Person();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //binding name nad surname fields
        nameTextField.textProperty().bindBidirectional(person.namePropertyProperty());
        surnameTextField.textProperty().bindBidirectional(person.surnamePropertyProperty());


        surnameTextField.disableProperty().bind(person.surnameDisableProperty());

        //text to number converter
        javafx.util.StringConverter converter = new NumberStringConverter();

        //binding birth year textfield
        birthYear.textProperty().bindBidirectional(person.birthYearProperty(), converter);
        //binding value to a checkbox
        confirmCheckBox.selectedProperty().bindBidirectional(person.confirmBoxProperty());

        yourAgeLabel.textProperty().bind(person.calcAgeProperty());

        //bind state labels
        statusName.visibleProperty().bind(person.nameStateProperty());
        statusSurname.visibleProperty().bind(person.surnameStateProperty());

        //bind button
        loginBtn.disableProperty().bind(person.btnPropProperty());

    }


}
