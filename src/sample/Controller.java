package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;


public class Controller implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private Button add;
    @FXML
    private TextArea description;
    @FXML
    private Button cancelButton;
    @FXML
    private ListView<String> listView;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setCellFactory(new CellFactory());
        listView.getItems().add("Pick up Ajla from school");
        listView.getItems().add("Java class");
        listView.getItems().add("Take Maid to karate");
        listView.setEditable(true);

        datePicker.setValue(LocalDate.now());
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    private void refresh() {
        datePicker.setValue(LocalDate.now());
        title.setText(null);

    }

    public void dodaj() {
        LocalEvent localEvent = new LocalEvent(title.getText(), description.getText(), datePicker.getValue());
        listView.getItems().add(String.valueOf(localEvent));

        title.clear();
        description.clear();
        datePicker.toBack();
    }

    public void setCancel() {
        title.clear();
        description.clear();
        datePicker.toBack();
    }
}