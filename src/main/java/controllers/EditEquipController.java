package controllers;

import DAO.AmortizationDAO;
import POJO.Amortization;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.HibernateUtil;
import org.hibernate.Session;
import tables.DisplayTable;

/**
 * Контроллер для окна редактирования записей о посещаемости
 */

public class EditEquipController {
    @FXML
    private TextField equipName;

    @FXML
    private TextField equipPrice;

    @FXML
    private TextField usefulLife;

    @FXML
    private Button editButton;

    @FXML
    private TextField equipID;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(editEvent->{
            Session session = HibernateUtil.getSession();

            AmortizationDAO amortizationDAO = new AmortizationDAO(session);

            Amortization amortization = amortizationDAO.findById(Integer.parseInt(equipID.getText()));
            amortization.setEquipmentName(equipName.getText());
            amortization.setEquipmentPrice(Long.parseLong(equipPrice.getText()));
            amortization.setEquipmentUsefulLife(Long.parseLong(usefulLife.getText()));

            amortizationDAO.update(amortization);

            session.close();

            displayTable.showAmortizationTable();

            clearFields();
        });
    }

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }

    private void clearFields() {
        equipName.clear();
        equipPrice.clear();
        usefulLife.clear();
        equipID.clear();
    }
}
