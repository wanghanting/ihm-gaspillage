package Program.View;

import Program.Controller.Controller;
import Program.Controller.ControllerMessage;
import Program.Controller.ControllerMessages;
import Program.Model.ModelMessage;
import Program.Model.ModelUser;
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

public class ViewMessages extends View{
    private static final String MESSAGE = "../Resources/message.fxml";

    @Override
    public void init(Controller controllerMessages, StageFactory stages){

        ControllerMessages controllerMessages1=(ControllerMessages)controllerMessages;
        controllerMessages1.getList_newm().setItems(findMes(stages.getModelListOfMes().getListOfMes(),stages.getUser()));


        adaptItems(controllerMessages1.getList_newm());
    }
    private void adaptItems(ListView listView) {
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
                                    Parent listElement = null;
                                    // Load fxml file for this Person
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(MESSAGE));
                                    //create the person controller
                                    ControllerMessage mesController = new ControllerMessage();
                                    //attach the person controller to this person
                                    loader.setController(mesController);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(MESSAGE));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    mesController.init((ModelMessage) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItems(listView);

                                }
                            }

                        };
                    }
                });
    }
    ObservableList findMes(ObservableList<ModelMessage> listmes, ModelUser user){
        ObservableList<ModelMessage> list = FXCollections.observableList (new ArrayList<>());
        for(ModelMessage mes:listmes){
            if(mes.getReceivor().getUsername().equals(user.getUsername())){
                list.add(mes);
            }
        }
        return list;
    }

}
