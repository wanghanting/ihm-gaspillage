package Program;

import Program.Controller.ControllerEnregistrer;
import Program.Model.ModelListOfTags;
import javafx.collections.ObservableList;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class ViewEnregistrer {

    public void init(ModelListOfTags model, ControllerEnregistrer controller) {
        controller.getSel_type().setItems(model.getNames());
        SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99);
        controller.getSpi_quan().setValueFactory(svf);
        SpinnerValueFactory svf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99);
        controller.getSpi_jour().setValueFactory(svf2);
    }

}
