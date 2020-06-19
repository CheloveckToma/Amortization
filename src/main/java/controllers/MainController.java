package controllers;

import DAO.AmortizationDAO;
import POJO.Amortization;
import calculations.AmortizationCalculation;

import exceptionsss.NegativaCostException;
import exceptionsss.ZeroCostException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import main.HibernateUtil;
import org.hibernate.Session;
import tables.DisplayTable;
import tables.TableСondition;
import windows.Window;

public class MainController {

    @FXML
    private TableView<Amortization> amortizationTableView;

    @FXML
    private Button addNote;

    @FXML
    private Button delNote;

    @FXML
    private HBox equip_list_button;

    @FXML
    private Button editNote;

    private DisplayTable displayTable;
    private TableСondition tableСondition;

    @FXML
    void initialize() {
        HibernateUtil.buildSessionFactory();

        tableСondition = TableСondition.AMORTIZATION;

        displayTable = new DisplayTable(amortizationTableView, tableСondition);

        displayTable.showAmortizationTable();

        amortizationTableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    try {
                        int index = amortizationTableView.getSelectionModel().selectedIndexProperty().get();

                        Session session = HibernateUtil.getSession();

                        AmortizationDAO amortizationDAO = new AmortizationDAO(session);

                        Amortization amortization = amortizationDAO.findById(index + 1);

                        AmortizationCalculation amortizationCalculation = new AmortizationCalculation();

                        Window.openAmortResultNoteWindow(amortizationCalculation.findYearAmortization(amortization.getEquipmentUsefulLife(), amortization.getEquipmentPrice()), amortizationCalculation.findMonthAmortization(amortization.getEquipmentUsefulLife(), amortization.getEquipmentPrice()));
                    } catch (NegativaCostException e) {
                        e.printStackTrace();
                    } catch (ZeroCostException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        EventHandler<MouseEvent> openAmortizationTableEvent = e -> {
            displayTable.showAmortizationTable();
            tableСondition = displayTable.getTableСondition();
        };

        equip_list_button.addEventHandler(MouseEvent.MOUSE_CLICKED, openAmortizationTableEvent);

        addNote.setOnAction(addEvent -> {
            Window.openAddNoteWindow(displayTable);
        });

        delNote.setOnAction(addEvent -> {
            Window.openDelNoteWindow(displayTable);
        });

        editNote.setOnAction(editEvent->{
            Window.openEditNoteWindow(displayTable);
        });


    }
}
