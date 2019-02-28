package Program.Controller;

import Program.Model.ModelListOfTags;
import Program.Model.ModelTag;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    public ListView getListView(){
        return choosenTag;
    }

    @FXML
    public TextField getTxt_tag(){
        return txt_tag;
    }

    @FXML
    public void init(ModelListOfTags tagList){
        this.modelListOfTags = tagList;
    }

    @FXML
    private void setBtn_ajoute(){
        try
        {
            btn_ajoute.setOnAction( event -> {
                modelListOfTags.add(new ModelTag(txt_tag.getText()));
            });

        }catch(NullPointerException e)
        {
            System.out.println("发生异常的 :"+e.getMessage());
        }
    }
}
