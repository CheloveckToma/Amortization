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
 * Контроллер для окна добавления записей о посещаемости
 */

public class AddEquipController {

    @FXML
    private TextField equipName;

    @FXML
    private TextField equipPrice;

    @FXML
    private TextField usefulLife;

    @FXML
    private Button addButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        addButton.setOnAction(delEvent->{
            Session session = HibernateUtil.getSession();

            AmortizationDAO amortizationDAO = new AmortizationDAO(session);

            Amortization amortization = new Amortization();

            amortization.setEquipmentName(equipName.getText());
            amortization.setEquipmentPrice(Long.parseLong(equipPrice.getText()));
            amortization.setEquipmentUsefulLife(Long.parseLong(usefulLife.getText()));

            amortizationDAO.save(amortization);

            session.close();

            displayTable.showAmortizationTable();

            clearFields();
        });
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
        equipName.clear();
        usefulLife.clear();
        equipPrice.clear();
    }
}

