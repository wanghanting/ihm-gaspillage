package Program.View;

import Program.Controller.ControllerChart;
import Program.Controller.ControllerConsomationG;
import Program.Model.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;

public class ViewConsomationG extends View {
    public static final String PATH = "Resources/consommation_graphique.fxml";
    private static final String CHART = "../Resources/chart.fxml";
    private static int rangeSelectedItem = -1;
    private static ModelListOfChart modelChar;
    private static ControllerConsomationG controller;

    public void init(ModelListOfChart modelChar, ModelListOfSum modelSum, ModelListOfFood modelFood, ModelListOfTags modelTag, ControllerConsomationG controller, String type) {
        this.modelChar = modelChar;
        this.controller = controller;
        //init the ObservableList of food to the ListView
        modelFood.init();
        modelSum.init(modelFood,modelTag);
        if(type.equals("somme")){
            controller.getlist_chart().setItems(modelChar.getListOfChart());
        }else if(type.equals("type")){
            controller.getlist_chart().setItems(modelChar.getListOfCharByType());
        }else {
            controller.getlist_chart().setItems(modelChar.getListOfCharByAli());
        }
        adaptItems(controller.getlist_chart() );
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
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(CHART));
                                    //create the person controller
                                    ControllerChart controllerChart = new ControllerChart();
                                    //attach the person controller to this person
                                    loader.setController(controllerChart);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(CHART));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    controllerChart.init((ModelChart) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItems(listView);

                                }
                            }

                        };
                    }
                });
    }
}
