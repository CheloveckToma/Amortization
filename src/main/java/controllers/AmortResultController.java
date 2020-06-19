package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AmortResultController {
    @FXML
    private Label monthAmort;

    @FXML
    private Label yearAmort;

    private Double yearAmortNumber;
    private Double monthAmotrNumber;

    @FXML
    void initialize() {
        monthAmort.setText(monthAmotrNumber.toString());
        yearAmort.setText(yearAmortNumber.toString());
    }

    public void setYearAmort(Double yearAmort){
        this.yearAmortNumber= yearAmort;
    }

    public Double getYearAmort() {
        return yearAmortNumber;
    }

    public Double getMonthAmotr() {
        return  monthAmotrNumber;
    }

    public void setMonthAmotr(Double monthAmotr) {
        this. monthAmotrNumber = monthAmotr;
    }
}
