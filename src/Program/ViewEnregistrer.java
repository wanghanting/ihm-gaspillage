package Program;

import Program.Controller.ControllerEnregistrer;
import Program.Model.ModelListOfTags;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.lang.reflect.Type;

public class ViewEnregistrer {
    private void listenTo(TextField textField, Label label) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (textField.getText().equals("")){
                    label.setText("Entrer le nom!");
                }else{
                    label.setText("");
                }

            }
        });
    }
    private void listenTo(ChoiceBox choiceBox, Label label) {
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val,Number new_val) -> {
                    System.out.println(new_val.intValue());
                    if (new_val.intValue()>=0){
                        label.setText("");
                    }else{
                        label.setText("Entrer la type!");
                    }});
    }


    public void init(ModelListOfTags model, ControllerEnregistrer controller) {
        controller.getSel_type().setItems(model.getNames());
        SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99);
        controller.getSpi_quan().setValueFactory(svf);
        SpinnerValueFactory svf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99);
        controller.getSpi_jour().setValueFactory(svf2);
        controller.getLab_noti().setText("Enter le nom!");
        listenTo(controller.getTxt_nom(),controller.getLab_noti());
        controller.getLab_notifi().setText("Enter la type!");
        listenTo(controller.getSel_type(),controller.getLab_notifi());
    }

}
