package Program.View;

import Program.Controller.Controller;
import Program.Controller.ControllerFollow;
import Program.Controller.ControllerFood;
import Program.Controller.ControllerUser;
import Program.Model.ModelListOfFollow;
import Program.Model.ModelUser;
import Program.StageFactory;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;

public class ViewFollow extends View{
    public static final String PATH = "Resources/follower.fxml";
    public static final String USER = "../Resources/user.fxml";
    private static ModelListOfFollow modelListOfFollow;
    private ControllerFollow controllerFollow;
    private static int rangeSelectedItem = -1;

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }


    public void init(Controller controller, StageFactory factory){
        ViewFollow.modelListOfFollow = factory.getModelListOfFollow();
        this.controllerFollow = (ControllerFollow)controller;
        controllerFollow.getLst_ami ().setItems (modelListOfFollow.getListOfAmi ());
        controllerFollow.getLst_fans ().setItems (modelListOfFollow.getListOfFans ());
        adaptItems (controllerFollow.getLst_ami ());
        adaptItems (controllerFollow.getLst_fans ());
        listenTo(controllerFollow.getLst_ami ());
        listenTo(controllerFollow.getLst_fans ());

    }

    private void adaptItems(ListView listView) {
        //Set a new cell factory to use in the ListView.
        listView.setCellFactory(
                //  first parameter specifies the type of the object passed in to the call method
                //  the second parameter specifying the return type of the method.
                new Callback<ListView, ListCell> () {
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
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(USER));
                                    //create the person controller
                                    ControllerUser userController = new ControllerUser ();
                                    //attach the person controller to this person
                                    loader.setController(userController);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(USER));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    userController.init((ModelUser) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItems(listView);

                                    //remove TextField name contents
                                    controllerFollow.getText_pro ().setText("");
                                }
                            }

                        };
                    }
                });
    }

    private void listenTo(ListView listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<ModelUser>) (observable, oldValue, newValue) -> {
                    rangeSelectedItem = modelListOfFollow.getListOfAmi ().indexOf(newValue);
                    rangeSelectedItem = modelListOfFollow.getListOfFans ().indexOf(newValue);
                    controllerFollow.setRece (newValue);
                }
        );
    }
}
