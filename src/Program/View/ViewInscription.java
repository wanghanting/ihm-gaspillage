package Program.View;

import Program.Controller.Controller;
import Program.Controller.ControllerInscription;
import Program.Model.ModelListOfUsers;
import Program.StageFactory;

public class ViewInscription extends View {
    public static final String PATH= "Resources/inscription.fxml";
    //    static final String CSS = "sample/resources/   View.css";
    static final String LABEL = "HFV";
    static final int WIDTH = 640;
    static final int HEIGHT = 480;
    private static ModelListOfUsers model;
    private  ControllerInscription controller;

    public void init(Controller controller, StageFactory factory) {
        this.controller = (ControllerInscription)controller;
        ViewInscription.model = factory.getModelListOfUsers();
    }

}

