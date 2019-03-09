package Program;

import Program.Controller.ControllerConsommationTextDate;
import Program.Controller.ControllerSum;
import Program.Model.*;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;

public class ViewConsommationTextDate {
    private static final String SUM = "Resources/sum.fxml";
    private static int rangeSelectedItem = -1;
    private static ModelListOfSum modelSum;
    private static ControllerConsommationTextDate controller;

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }

    public void init(ModelListOfSum modelSum, ModelListOfFood modelFood, ModelListOfTags modelTag, ControllerConsommationTextDate controller, String type) {
        ViewConsommationTextDate.modelSum = modelSum;
        ViewConsommationTextDate.controller = controller;
        //init the ObservableList of food to the ListView
        modelFood.init();
        modelSum.init(modelFood,modelTag);
        if(type.equals("somme")){
            controller.getList_cons().setItems(modelSum.getListOfConsom());
            controller.getList_gas().setItems(modelSum.getListOfGas());
            controller.getList_taux().setItems(modelSum.getListOfRate());
        }else if(type.equals("type")){
            controller.getList_cons().setItems(modelSum.getListOfConsomByType());
            controller.getList_gas().setItems(modelSum.getListOfGasByType());
            controller.getList_taux().setItems(modelSum.getListOfRateByType());
        }
        adaptItems(controller.getList_cons() );
        adaptItems(controller.getList_gas());
        adaptItems(controller.getList_taux());
    }

    private void adaptItems(ListView listView) {
        //Set a new cell factory to use in the ListView.
        listView.setCellFactory(
                //  first parameter specifies the type of the object passed in to the call method
                //  the second parameter specifying the return type of the method.
                new Callback<ListView, ListCell>() {
                    //define what to do when ModelListCustomers.listOfCustumers is changed
                    @Override
                    public ListCell call(ListView listView) {
                        return new ListCell() {
                            @Override
                            protected void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    Parent listElement=null;
                                    // Load fxml file for this Person
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(SUM));
                                    //create the person controller
                                    ControllerSum sumController = new ControllerSum();
                                    //attach the person controller to this person
                                    loader.setController(sumController);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(SUM));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    sumController.init((ModelSum) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItems(listView);

                                }
                            }

                        };
                    }
                });
    }

    private void listenTo(ListView listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<ModelTag>) (observable, oldValue, newValue) -> {
                    rangeSelectedItem = modelSum.getListOfConsom().indexOf(newValue);
                }

        );
    }
}

