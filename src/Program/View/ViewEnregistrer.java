package Program.View;

import Program.Controller.Controller;
import Program.Controller.ControllerEnregistrer;
import Program.Model.ModelListOfTags;
import Program.StageFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.lang.reflect.Type;

public class ViewEnregistrer extends View {
    public static final String PATH = "Resources/enregistrer.fxml";
    private ControllerEnregistrer controller;
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
                    if (new_val.intValue()>=0){
                        label.setText("");
                    }else{
                        label.setText("Choisir la type!");
                    }});
    }

    @Override
    public void init(Controller controller, StageFactory factory) {
        this.controller= (ControllerEnregistrer)controller;
        this.controller.getSel_type().setItems(factory.getModelListOfTags().getNames());
        SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99);
        this.controller.getSpi_quan().setValueFactory(svf);
        SpinnerValueFactory svf2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 99);
        this.controller.getSpi_jour().setValueFactory(svf2);
        this.controller.getLab_noti().setText("Enter le nom!");
        listenTo( this.controller.getTxt_nom(), this.controller.getLab_noti());
        this.controller.getLab_notifi().setText("Choisir la type!");
        listenTo( this.controller.getSel_type(), this.controller.getLab_notifi());
        controller.getHboxa().setPrefWidth(600);
        controller.getHboxa().setPrefHeight(475);
    }

}
