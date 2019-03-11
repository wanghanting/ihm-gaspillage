package Program.Controller;

import Program.Model.ModelListOfSum;
import Program.StageFactory;
import Program.View.ViewConsommationTextDate;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerConsommationTextDate {

    @FXML
    private Button btn_close;
    @FXML
    private Hyperlink link_accueil;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_deconn;
    @FXML
    private ListView list_cons;
    @FXML
    private ListView list_gas;
    @FXML
    private ListView list_taux;
    @FXML
    private DatePicker date_from;
    @FXML
    private DatePicker date_to;
    @FXML
    private Label lab_from;
    @FXML
    private Label lab_to;
    @FXML
    private MenuButton sel_cosm_type;
    @FXML
    private MenuItem somme;
    @FXML
    private MenuItem par_type_ali;
    @FXML
    private MenuItem par_ali;
    @FXML
    private Button btn_gra;

    public ListView getList_cons(){return list_cons;}
    public ListView getList_gas(){return list_gas;}
    public ListView getList_taux(){return list_taux;}
    public DatePicker getDate_from(){return date_from;}
    public DatePicker getDate_to(){return date_to;}


    @FXML
    public void init(ModelListOfSum sum, ViewConsommationTextDate view, Stage stage , StageFactory stageFactory){
        if(stageFactory.getModelListOfFood().getDateFrom() == null ){
            lab_from.setText("Pas choisir");
        }else {
            lab_from.setText(stageFactory.getModelListOfFood().getDateFrom().toString());
        }
        if(stageFactory.getModelListOfFood().getDateTo() == null){
            lab_to.setText("Pas choisir");
        }else {
            lab_to.setText(stageFactory.getModelListOfFood().getDateTo().toString());
        }
        date_from.setOnAction(event -> {
            try {
                stageFactory.getModelListOfFood().setDateFrom(date_from.getValue());
                openNewPage(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        date_to.setOnAction(event -> {
            try {
                stageFactory.getModelListOfFood().setDateTo(date_to.getValue());
                openNewPage(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        par_type_ali.setOnAction(event -> {
            try {
                stageFactory.setTypeOfConsom("type");
                openNewPage(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        somme.setOnAction(event -> {
            try {
                stageFactory.setTypeOfConsom("somme");
                openNewPage(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        par_ali.setOnAction(event -> {
            try {
                stageFactory.setTypeOfConsom("aliment");
                openNewPage(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        link_aide.setOnAction(event -> {
            try {
                setLink_aide(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_close.setOnAction(event -> {
            stage.close();
        });
        link_accueil.setOnAction(event -> {
            try {
                setLink_accueil(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_gra.setOnAction(event -> {
            try {
                stageFactory.initConsomation();
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        link_deconn.setOnAction (event -> {
            setLink_deco(stageFactory);
        });
    }

    @FXML
    private void openNewPage(StageFactory factory)throws IOException{
        factory.initCosommationT();
    }

    @FXML
    public void setSel_cosm_type(String type){
        sel_cosm_type.setText(type);
    }

    @FXML
    private void setLink_aide(StageFactory factory)throws IOException {
        factory.initAide ();
    }

    @FXML
    private void setLink_accueil(StageFactory factory)throws IOException{
        factory.initAccueil();
    }

    private void setLink_deco(StageFactory factory) {
        try{
            factory.initAuthentification1();
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }
}
