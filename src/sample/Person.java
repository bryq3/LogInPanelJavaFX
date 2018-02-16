package sample;

import javafx.beans.binding.When;
import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Created by User on 2018-02-16.
 */
public class Person {

    //person's name
    private StringProperty nameProperty = new SimpleStringProperty();

    //state of nameTextField
    private BooleanProperty nameState = new SimpleBooleanProperty(false);

    //person's surname
    private StringProperty surnameProperty = new SimpleStringProperty();

    //state of surnameTextField
    private BooleanProperty surnameState = new SimpleBooleanProperty(false);

    //disable surname field
    private BooleanProperty surnameDisable = new SimpleBooleanProperty(true);

    public boolean isSurnameDisable() {
        return surnameDisable.get();
    }

    public BooleanProperty surnameDisableProperty() {
        return surnameDisable;
    }

    public void setSurnameDisable(boolean surnameDisable) {
        this.surnameDisable.set(surnameDisable);
    }

    //birthYear
    private IntegerProperty birthYear = new SimpleIntegerProperty();

    //checkbox state
    private BooleanProperty confirmBox = new SimpleBooleanProperty(false);

    //calculated age
    private StringProperty calcAge = new SimpleStringProperty();

    //button prop
    private BooleanProperty btnProp= new SimpleBooleanProperty(false);

    //current year
    private IntegerProperty currentYear = new SimpleIntegerProperty(LocalDate.now().getYear());

    //consturctor
    public Person() {
        nameState.bind(nameProperty.isNotEmpty());
        surnameState.bind(surnameProperty.isNotEmpty());
        surnameDisable.bind(nameProperty.isEmpty());
        btnProp.bind(confirmBoxProperty().not());
        calcAge.bind(new When(birthYear.isNotEqualTo(0))
            .then(currentYear.subtract(birthYearProperty()).asString()).otherwise(""));
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    public StringProperty namePropertyProperty() {
        return nameProperty;
    }

    public void setNameProperty(String nameProperty) {
        this.nameProperty.set(nameProperty);
    }

    public boolean isNameState() {
        return nameState.get();
    }

    public BooleanProperty nameStateProperty() {
        return nameState;
    }

    public void setNameState(boolean nameState) {
        this.nameState.set(nameState);
    }

    public String getSurnameProperty() {
        return surnameProperty.get();
    }

    public StringProperty surnamePropertyProperty() {
        return surnameProperty;
    }

    public void setSurnameProperty(String surnameProperty) {
        this.surnameProperty.set(surnameProperty);
    }

    public boolean isSurnameState() {
        return surnameState.get();
    }

    public BooleanProperty surnameStateProperty() {
        return surnameState;
    }

    public void setSurnameState(boolean surnameState) {
        this.surnameState.set(surnameState);
    }

    public int getBirthYear() {
        return birthYear.get();
    }

    public IntegerProperty birthYearProperty() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear.set(birthYear);
    }

    public boolean isConfirmBox() {
        return confirmBox.get();
    }

    public BooleanProperty confirmBoxProperty() {
        return confirmBox;
    }

    public void setConfirmBox(boolean confirmBox) {
        this.confirmBox.set(confirmBox);
    }

    public String getCalcAge() {
        return calcAge.get();
    }

    public StringProperty calcAgeProperty() {
        return calcAge;
    }

    public void setCalcAge(String calcAge) {
        this.calcAge.set(calcAge);
    }

    public boolean isBtnProp() {
        return btnProp.get();
    }

    public BooleanProperty btnPropProperty() {
        return btnProp;
    }

    public void setBtnProp(boolean btnProp) {
        this.btnProp.set(btnProp);
    }

    public int getCurrentYear() {
        return currentYear.get();
    }

    public IntegerProperty currentYearProperty() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear.set(currentYear);
    }
}
