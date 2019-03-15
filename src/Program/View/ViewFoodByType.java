package Program.View;

import Program.Controller.Controller;
import Program.Controller.ControllerFood;
import Program.Controller.ControllerFoodByType;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import Program.StageFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFoodByType extends View {
    public static final String PATH = "Resources/aliment_par_type.fxml";
    private static final String FOOD = "../Resources/food.fxml";
    private  ModelListOfFood model;
    private ControllerFoodByType controller;
    private String type ;

    @Override
    public void init(Controller controller, StageFactory factory) {
        this.controller =(ControllerFoodByType) controller;
        this.type=factory.getType();
        this.controller.getType().setText(type);
        this.model = findFood(factory.getModelListOfFood());

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
    private void listinit(){
        ObservableList listvide= FXCollections.observableList(new ArrayList<>());
        controller.getPerimeFoodListView().setItems(listvide);
        controller.getOkFoodListView().setItems(listvide);
        controller.getPPFoodListView().setItems(listvide);

    }
    private ModelListOfFood findFood( ModelListOfFood modelListOfFood){
        ModelListOfFood modelListOfFood1 = new ModelListOfFood();
        modelListOfFood1.setListOfFoodA();
        for(ModelFood food: modelListOfFood.getListOfFoodCanDelete()){
            if(food.getFoodType().equals(this.type)){
                modelListOfFood1.addFood(food);
            }
        }
        return modelListOfFood1;
    }

}
