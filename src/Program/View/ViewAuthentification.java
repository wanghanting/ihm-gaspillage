package Program.View;

import Program.Controller.ControllerAuthentification;
import Program.Model.ModelListOfUsers;


public class ViewAuthentification{

    static final String XML_FILE = "../Resources/authentification.fxml";
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

    public void init(ModelListOfUsers model, ControllerAuthentification controller) {
        ViewAuthentification.model = model;
        ViewAuthentification.controller= controller;

    }


}
