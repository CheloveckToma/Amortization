package controllers;

import DAO.AmortizationDAO;
import POJO.Amortization;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.HibernateUtil;
import org.hibernate.Session;
import tables.DisplayTable;

public class DelEquipController {

    @FXML
    private Button delButton;

    @FXML
    private TextField equipID;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        delButton.setOnAction(delEvent->{
            Session session = HibernateUtil.getSession();

            AmortizationDAO amortizationDAO = new AmortizationDAO(session);

            Amortization amortization = amortizationDAO.findById(Integer.parseInt(equipID.getText()));

            amortizationDAO.delete(amortization);

            session.close();

            displayTable.showAmortizationTable();

            clearFields();
        });
    }

    private void clearFields() {
        equipID.clear();
    }

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
