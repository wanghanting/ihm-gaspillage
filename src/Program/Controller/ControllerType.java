package Program.Controller;

import Program.Model.ModelListOfTags;
import Program.Model.ModelTag;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerType {

    private ModelListOfTags modelListOfTags = null;

    @FXML
    private Hyperlink link_acceuil;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_deco;
    @FXML
    private Button btn_close;
    @FXML
    private Button btn_ajoute;
    @FXML
    private ListView choosenTag;
    @FXML
    private TextField txt_tag;

    @FXML
    public ListView getListView() {
        return choosenTag;
    }

    @FXML
    public TextField getTxt_tag() {
        return txt_tag;
    }

    @FXML
    public void init(ModelListOfTags tagList) {
        this.modelListOfTags = tagList;
        setBtn_ajoute();
    }

    @FXML
    private void setBtn_ajoute() {

        btn_ajoute.setOnAction(event -> {
            modelListOfTags.add(new ModelTag(txt_tag.getText()));
        });

    }
}
