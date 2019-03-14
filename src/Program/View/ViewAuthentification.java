package Program.View;

import Program.Controller.Controller;
import Program.Controller.ControllerAuthentification;
import Program.Model.ModelListOfUsers;
import Program.StageFactory;


public class ViewAuthentification extends View{

    public static final String PATH = "Resources/authentification.fxml";
    //   static final String CSS = "sample/resources/custumerView.css";
    static final String LABEL = "Please Login";
    static final int WIDTH = 640;
    static final int HEIGHT = 480;
    private static ModelListOfUsers model;
    private  ControllerAuthentification controller;

    /**
     * getter
     * @return
     */

    public void init(Controller controller, StageFactory factory) {
        ViewAuthentification.model = factory.getModelListOfUsers();
        this.controller= (ControllerAuthentification)controller;

    }


}
