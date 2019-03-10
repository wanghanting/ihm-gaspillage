package Program;

import Program.Controller.ControllerAuthentification;
import Program.Controller.ControllerInscription;
import Program.Model.ModelListOfUsers;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;


public class ViewAuthentification{

    static final String XML_FILE = "resources/authentification.fxml";
    //   static final String CSS = "sample/resources/custumerView.css";
    static final String LABEL = "Please Login";
    static final int WIDTH = 640;
    static final int HEIGHT = 480;
    private static ModelListOfUsers model;
    private static ControllerAuthentification controller;

    /**
     * getter
     * @return
     */

    void init(ModelListOfUsers model, ControllerAuthentification controller) {
        ViewAuthentification.model = model;
        ViewAuthentification.controller= controller;

    }


}
