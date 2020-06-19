package windows;

import controllers.AddEquipController;
import controllers.AmortResultController;
import controllers.DelEquipController;
import controllers.EditEquipController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sun.plugin2.os.windows.Windows;
import tables.DisplayTable;

import java.io.IOException;

public class Window {

    public static void openAddNoteWindow(DisplayTable displayTable) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/addNoteWindow.fxml"));

            AddEquipController addEquipController = new AddEquipController();
            addEquipController.setDisplayTable(displayTable);

            fxmlLoader.setController(addEquipController);
            Parent root = null;
            root = fxmlLoader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Добавление оборудования");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.getIcons().add(new Image("/images/icon.png"));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void openDelNoteWindow(DisplayTable displayTable) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/delNoteWindow.fxml"));

            DelEquipController delEquipController = new  DelEquipController();
            delEquipController.setDisplayTable(displayTable);

            fxmlLoader.setController(delEquipController);
            Parent root = null;
            root = fxmlLoader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Удаление оборудования");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.getIcons().add(new Image("/images/icon.png"));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void openAmortResultNoteWindow(Double yearAmort,Double monthAmort) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/amortResult.fxml"));

            AmortResultController amortResultController = new AmortResultController();
            amortResultController.setMonthAmotr(monthAmort);
            amortResultController.setYearAmort(yearAmort);

            fxmlLoader.setController(amortResultController);
            Parent root = null;
            root = fxmlLoader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Результаты расчетов");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.getIcons().add(new Image("/images/icon.png"));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void openEditNoteWindow(DisplayTable displayTable) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Windows.class.getResource("/fxml/editNoteWindow.fxml"));

            EditEquipController editEquipController = new EditEquipController();
            editEquipController.setDisplayTable(displayTable);

            fxmlLoader.setController(editEquipController);
            Parent root = null;
            root = fxmlLoader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setTitle("Редактирование записи");
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.getIcons().add(new Image("/images/icon.png"));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
