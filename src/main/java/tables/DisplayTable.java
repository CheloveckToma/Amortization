package tables;

import DAO.AmortizationDAO;
import POJO.Amortization;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.HibernateUtil;
import org.hibernate.Session;

public class DisplayTable {

    private TableСondition tableСondition;
    private TableView<Amortization> amortizationTableView;

    public DisplayTable(TableView<Amortization> amortizationTableView, TableСondition tableСondition) {
        this.amortizationTableView = amortizationTableView;;
        this.tableСondition = tableСondition;
    }

    public void showAmortizationTable() {
        amortizationTableView.getColumns().clear();

        tableСondition = TableСondition.AMORTIZATION;

        Session session = HibernateUtil.getSession();

        AmortizationDAO amortizationDAO = new AmortizationDAO(session);

        amortizationTableView.setItems(FXCollections.observableList(amortizationDAO.findAll()));

        TableColumn<Amortization, Integer> ID = new TableColumn<Amortization, Integer>("ID");
        ID.setCellValueFactory(new PropertyValueFactory<Amortization, Integer>("ID"));

        TableColumn<Amortization, String> equipName = new TableColumn<Amortization, String>("Название оборудования");
        equipName.setCellValueFactory(new PropertyValueFactory<Amortization, String>("equipmentName"));

        TableColumn<Amortization, String> equipPrice = new TableColumn<Amortization, String>("Цена оборудования");
        equipPrice.setCellValueFactory(new PropertyValueFactory<Amortization, String>("equipmentPrice"));

        TableColumn<Amortization, String> equipUsefulLife = new TableColumn<Amortization, String>("Срок полезного использования");
        equipUsefulLife.setCellValueFactory(new PropertyValueFactory<Amortization, String>("equipmentUsefulLife"));

        amortizationTableView.getColumns().addAll(ID,equipName,equipPrice,equipUsefulLife);
    }

    public TableСondition getTableСondition() {
        return tableСondition;
    }
}
