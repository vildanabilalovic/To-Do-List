package sample;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class CellFactory implements Callback<ListView<String>, ListCell<String>> {

    @Override
    public ListCell<String> call(ListView<String> listView) {

        ListViewCell cell = new ListViewCell();

        ContextMenu contextMenu = new ContextMenu();

        MenuItem editItem = new MenuItem();
        editItem.textProperty().bind(Bindings.format("Edit \"%s\"", cell.itemProperty()));
        editItem.setOnAction(event -> {
            cell.startEdit();
        });
        MenuItem deleteItem = new MenuItem();
        deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", cell.itemProperty()));
        deleteItem.setOnAction(event -> listView.getItems().remove(cell.getItem()));

        contextMenu.getItems().addAll(editItem, deleteItem);

        cell.textProperty().bindBidirectional(cell.itemProperty());
        cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
            if (isNowEmpty) {
                cell.setContextMenu(null);
            } else {
                cell.setContextMenu(contextMenu);
            }
        });
        return cell ;
    }
}