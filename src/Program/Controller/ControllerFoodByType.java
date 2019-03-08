package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.StageFactory;
import Program.ViewFoodByType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFoodByType {
    private ModelListOfFood modelListOfFood = null;

    @FXML
    private ListView list_alipp;
    @FXML
    private ListView list_aliok;
    @FXML
    private ListView list_perimes;
    @FXML
    private Label type;
    @FXML
    private Button back;

    public ListView getPerimeFoodListView(){ return list_perimes;}
    public ListView getOkFoodListView(){ return this.list_aliok;}
    public ListView getPPFoodListView(){return  this.list_alipp;}

    public void init(ModelListOfFood food, ViewFoodByType view, Stage stage , StageFactory stageFactory,String type){
        this.modelListOfFood = food;
        this.type.setText(type);
        back.setOnAction(event -> {
            try {
                setBack(stage,stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    public void setBack(Stage stageOld,StageFactory stageFactory)throws IOException {
        stageOld.close();
        stageFactory.initType();
    }

}
