package Program;

import Program.Controller.ControllerFood;
import Program.Controller.ControllerFoodByType;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFoodByType {
    private static final String FOOD = "Resources/food.fxml";
    private static int rangeSelectedItem = -1;
    private static ModelListOfFood model;
    private static ControllerFoodByType controller;

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }

    public void init(ModelListOfFood model, ControllerFoodByType controller) {
        ViewFoodByType.model = model;
        ViewFoodByType.controller = controller;
        //init the ObservableList of food to the ListView
        model.init();
        listinit();
        controller.getPerimeFoodListView().setItems(model.getListOfPerimeFoodOfOneType());
        controller.getOkFoodListView().setItems(model.getListOfOkFoodOfOneType());
        controller.getPPFoodListView().setItems(model.getListOfPPFoodOfOneType());

        //call a cell factory and display each observable item in the ListView
        adaptItems( controller.getPerimeFoodListView() );
        adaptItems(controller.getOkFoodListView());
        adaptItems(controller.getPPFoodListView());

        //listner if user click in the ListView update rangeSelectedItem value
        listenTo( controller.getPerimeFoodListView() );
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
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(FOOD));
                                    //create the person controller
                                    ControllerFood foodController = new ControllerFood();
                                    //attach the person controller to this person
                                    loader.setController(foodController);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(FOOD));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    foodController.init((ModelFood) item);
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
                (ChangeListener<ModelFood>) (observable, oldValue, newValue) -> {
                    rangeSelectedItem = model.getListOfOkFood().indexOf(newValue);
                    // --> GRRR! in javaFX the field Name is kbown in the Controller class (not in the view)
                    //controller.getChoosenName().setText(newValue.getName());
                });
    }
    private void listinit(){
        ObservableList listvide= FXCollections.observableList(new ArrayList<>());
        controller.getPerimeFoodListView().setItems(listvide);
        controller.getOkFoodListView().setItems(listvide);
        controller.getPPFoodListView().setItems(listvide);

    }

}
