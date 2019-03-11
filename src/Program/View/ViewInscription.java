package Program.View;

import Program.Controller.ControllerInscription;
import Program.Model.ModelListOfUsers;

public class ViewInscription {
    static final String XML_FILE = "../Resources/inscription.fxml";
    //    static final String CSS = "sample/resources/   View.css";
    static final String LABEL = "HFV";
    static final int WIDTH = 640;
    static final int HEIGHT = 480;
    private static ModelListOfUsers model;
    private static ControllerInscription controller;

    public void init(ModelListOfUsers model, ControllerInscription controller) {
        ViewInscription.model = model;
        ViewInscription.controller = controller;
    }

}

