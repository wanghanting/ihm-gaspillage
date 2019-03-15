package Program.View;
import Program.Controller.Controller;
import Program.Controller.ControllerFood;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import Program.Controller.ControllerAccueil;
import Program.StageFactory;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;


public class ViewAccueil extends View{
    public static final String PATH = "Resources/page_d'accueil.fxml";
    private static final String FOOD = "../Resources/food.fxml";
    private static int rangeSelectedItem = -1;
    private static ModelListOfFood model;
    private  ControllerAccueil controller;

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }
    @Override
    public void init(Controller controller, StageFactory factory){
        ViewAccueil.model = factory.getModelListOfFood();
        this.controller =(ControllerAccueil) controller;
        //init the ObservableList of food to the ListView
        model.init();
        listinit();
        this.controller.getPerimeFoodListView().setItems(model.getListOfPerimeFood());
        this.controller.getOkFoodListView().setItems(model.getListOfOkFood());
        this.controller.getPPFoodListView().setItems(model.getListOfPPFood());

        //call a cell factory and display each observable item in the ListView
        adaptItems(this.controller.getPerimeFoodListView() );
        adaptItems(this.controller.getOkFoodListView());
        adaptItems(this.controller.getPPFoodListView());



        //listner if user click in the ListView update rangeSelectedItem value
        listenTo(this.controller.getPerimeFoodListView() );
        listenTo(this.controller.getOkFoodListView());
        listenTo(this.controller.getPPFoodListView());
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
                    rangeSelectedItem = model.getListOfFoodCanDelete().indexOf(newValue);
                    //controller.getChoosenFood(newValue.getName(),newValue.getDateExpiration());
                });
    }
    private void listinit(){
        ObservableList listvide= FXCollections.observableList(new ArrayList<>());
        controller.getPerimeFoodListView().setItems(listvide);
        controller.getOkFoodListView().setItems(listvide);
        controller.getPPFoodListView().setItems(listvide);

    }
}
