package sample;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class ListViewCell  extends ListCell<String> {

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("+++++ oldValue: " + oldValue + "new value: " + newValue);
        });

        checkBox.setOnAction(event -> {
        });

        HBox pane = new HBox();
        pane.getChildren().add(checkBox);

        String task = null;

        if (item != null && !empty) {
            task = item;
            setGraphic(pane);
        }

        if (item == null || empty) {
            setGraphic(null);
        }

        this.setText(task);
    }
}
