package Program.View;

import Program.Controller.Controller;
import Program.Controller.ControllerSend;
import Program.StageFactory;

public class ViewSend extends View {
    public void init(Controller controllersend, StageFactory stages){
        ControllerSend controllerSend = (ControllerSend)controllersend;
        controllerSend.getLab_rece().setText(stages.getRece().getUsername());
    }
}
