package Program;
import Program.Controller.ControllerFood;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import Program.Controller.ControllerAccueil;
import Program.Model.ModelListOfTags;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;

public class ViewFood {
    static final String XML_FILE = "../Resources/page_d'accueil.fxml";
    static final String LABEL = "Aliments";
    static final int WIDTH = 200;
    static final int HEIGHT = 10;
    private static final String FOOD = "Resources/food.fxml";
    private static int rangeSelectedItem = -1;
    private static ModelListOfFood model;
    private static ControllerAccueil controller;

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }

    public void init(ModelListOfFood model, ControllerAccueil controller) {
        ViewFood.model = model;
        ViewFood.controller = controller;
        //init the ObservableList of food to the ListView
        /*ListView foodperime = new ListView();
        foodperime.setItems(model.getListOfTag());
        controller.setView(foodperime);*/
        controller.getPerimeFoodListView().setItems(model.getListOfFood());

        //call a cell factory and display each observable item in the ListView
        adaptItems( controller.getPerimeFoodListView() );

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
                    rangeSelectedItem = model.getListOfFood().indexOf(newValue);
                    // --> GRRR! in javaFX the field Name is kbown in the Controller class (not in the view)
                    //controller.getChoosenName().setText(newValue.getName());
                });
    }
}
