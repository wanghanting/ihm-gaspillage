package Program;


import Program.Controller.ControllerTag;
import Program.Controller.ControllerType;
import Program.Model.ModelListOfTags;
import Program.Model.ModelTag;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;

public class ViewType {
    public static final String TYPE = "Resources/types.fxml";
    static final String TAG = "Resources/tag.fxml";
    static final String ACCUEIL = "Resources/page_d'accueil.fxml";
    public static final String LABEL = "HFV";
    private static ModelListOfTags modelListOfTags;
    private static ControllerType controllerType;
    private static int rangeSelectedItem = -1;

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }

    public void init(ModelListOfTags modelListOfTags, ControllerType controllerType) {
        ViewType.modelListOfTags = modelListOfTags;
        ViewType.controllerType = controllerType;

        controllerType.getListView().setItems(modelListOfTags.getListOfTag());

        adaptItems(controllerType.getListView());

        listenTo(controllerType.getListView());

    }

    private void adaptItems(ListView listView) {

        listView.setCellFactory(

                new Callback<ListView, ListCell>() {
                    @Override
                    public ListCell call(ListView listView) {
                        return new ListCell() {
                            @Override
                            protected void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    Parent listElement = null;
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(TAG));
                                    ControllerTag tagController = new ControllerTag();
                                    loader.setController(tagController);

                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(TAG));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }

                                    tagController.init((ModelTag) item);

                                    setGraphic(listElement);
                                    adaptItems(listView);

                                    controllerType.getTxt_tag().setText("");
                                }
                            }
                        };
                    }
                }

        );

    }

    private void listenTo(ListView listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<ModelTag>) (observable, oldValue, newValue) -> {
                    rangeSelectedItem = modelListOfTags.getListOfTag().indexOf(newValue);
                }

        );
    }
}
