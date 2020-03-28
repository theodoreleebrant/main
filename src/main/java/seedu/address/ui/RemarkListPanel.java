package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.hirelah.Remark;

/**
 * Panel containing the list of remarks for an interviewee.
 */
public class RemarkListPanel extends UiPart<Region> {
    private static final String FXML = "CardListView.fxml";
    private final Logger logger = LogsCenter.getLogger(RemarkListPanel.class);

    @FXML
    private ListView<Remark> cardListView;

    @FXML
    private Label title;

    public RemarkListPanel(ObservableList<Remark> remarkList) {
        super(FXML);
        title.setText("Remarks");
        cardListView.setItems(remarkList);
        cardListView.setCellFactory(listView -> new RemarkListViewCell());
        cardListView.getItems().addListener(
                (ListChangeListener<Remark>) c -> cardListView.scrollTo(c.getList().size() - 1));
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Remark} using a {@code RemarkCard}.
     */
    class RemarkListViewCell extends ListCell<Remark> {
        @Override
        protected void updateItem(Remark remark, boolean empty) {
            super.updateItem(remark, empty);

            if (empty || remark == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new RemarkCard(remark).getRoot());
            }
        }
    }
}