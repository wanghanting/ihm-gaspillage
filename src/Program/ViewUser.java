package Program;

import Program.Controller.ControllerUser;
import Program.Model.ModelListOfUsers;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;

public class ViewUser {
    static final String XML_FILE = "resources/inscription.fxml";
//    static final String CSS = "sample/resources/   View.css";
    static final String LABEL = "HFV";
    static final int WIDTH = 640;
    static final int HEIGHT = 480;
    private static ModelListOfUsers model;
    private static ControllerUser controller;

    /**
     * getter
     * @return
     */


    void init(ModelListOfUsers model, ControllerUser controller) {
        ViewUser.model = model;
        ViewUser.controller = controller;
        //init the ObservableList of custumers to the ListView
       // controller.getListView().setItems(model.getListOfCustumers());

        //call a cell factory and display each observable item in the ListView
        //adaptItems( controller.getCutomersListView() );

        //listner if user click in the ListView update rangeSelectedItem value
       // listenTo( controller.getCutomersListView() );
    }


    /**
     * display each item of the ListView
     * Automatically called if the ModelListCustomers.listOfCustumers is changed
     * @param listView the element to be filled
     */
//    /*private void adaptItems(ListView listView) {
//        //Set a new cell factory to use in the ListView.
//        listView.setCellFactory(
//                //  first parameter specifies the type of the object passed in to the call method
//                //  the second parameter specifying the return type of the method.
//                new Callback<ListView, ListCell>() {
//                    //define what to do when ModelListCustomers.listOfCustumers is changed
//                    @Override
//                    public ListCell call(ListView listView) {
//                        return new ListCell() {
//                            @Override
//                            protected void updateItem(Object item, boolean empty) {
//                                super.updateItem(item, empty);
//                                if (item != null) {
//                                    Parent listElement=null;
//                                    // Load fxml file for this Person
//                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(PERSON));
//                                    //create the person controller
//                                    ControllerPerson personController = new ControllerPerson();
//                                    //attach the person controller to this person
//                                    loader.setController(personController);
//                                    try {
//                                        listElement = loader.load(getClass().getResourceAsStream(PERSON));
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }
//                                    //initialize the person controller
//                                    personController.init((ModelPerson) item);
//                                    // Display content of the fxml file
//                                    setGraphic(listElement);
//                                    adaptItems(listView);
//
//                                    //remove TextField name contents
//                                    controller.getNameField().setText("");
//                                }
//                            }
//
//                        };
//                    }
//                });
//    }
//
//
//
//    /**
//     * listner if user click in the ListView
//     * update rangeSelectedItem value (if a controller need it)
//     * display the new person name in the Text ChoosenName
//     * @param listView should receive a clic event
//     */
//    private void listenTo(ListView listView) {
//        listView.getSelectionModel().selectedItemProperty().addListener(
//                (ChangeListener<ModelPerson>) (observable, oldValue, newValue) -> {
//                    rangeSelectedItem = model.getListOfCustumers().indexOf(newValue);
//                    // --> GRRR! in javaFX the field Name is kbown in the Controller class (not in the view)
//                    controller.getChoosenName().setText(newValue.getName());
//                });
//    }
//
}
