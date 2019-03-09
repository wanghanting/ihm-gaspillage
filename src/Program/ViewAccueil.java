package Program;
import Program.Controller.ControllerAttention;
import Program.Controller.ControllerFood;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import Program.Controller.ControllerAccueil;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;


public class ViewAccueil {
    private static final String FOOD = "Resources/food.fxml";
    private static int rangeSelectedItem = -1;
    private static ModelListOfFood model;
    private static ControllerAccueil controller;

    public static int getRangeSelectedItem() {
        return rangeSelectedItem;
    }

    public void init(ModelListOfFood model, ControllerAccueil controller) throws IOException {
        ViewAccueil.model = model;
        ViewAccueil.controller = controller;
        //init the ObservableList of food to the ListView
        model.init();
        listinit();
        controller.getPerimeFoodListView().setItems(model.getListOfPerimeFood());
        controller.getOkFoodListView().setItems(model.getListOfOkFood());
        controller.getPPFoodListView().setItems(model.getListOfPPFood());

        //call a cell factory and display each observable item in the ListView
        adaptItems(controller.getPerimeFoodListView() );
        adaptItems(controller.getOkFoodListView());
        adaptItems(controller.getPPFoodListView());



        //listner if user click in the ListView update rangeSelectedItem value
        listenTo( controller.getPerimeFoodListView() );
        listenTo(controller.getOkFoodListView());
        listenTo(controller.getPPFoodListView());
    }
    private void adaptItems(ListView listView) {
        //Set a new cell factory to use in the ListView.
        listView.setCellFactory(
                //  first parameter specifies the type of the object passed in to the call method
                //  the second parameter specifying the return type of the method.
                new Callback<ListView, ListCell>() {
                    //define what to do when ModelListCustomers.listOfCustumers is changed
                    @Override
                    public ListCell call(ListView listView) {
                        return new ListCell() {
                            @Override
                            protected void updateItem(Object item, boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    Parent listElement=null;
                                    // Load fxml file for this Person
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(FOOD));
                                    //create the person controller
                                    ControllerFood foodController = new ControllerFood();
                                    //attach the person controller to this person
                                    loader.setController(foodController);
                                    try {
                                        listElement = loader.load(getClass().getResourceAsStream(FOOD));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    //initialize the person controller
                                    foodController.init((ModelFood) item);
                                    // Display content of the fxml file
                                    setGraphic(listElement);
                                    adaptItems(listView);

                                }
                            }

                        };
                    }
                });
    }


    private void listenTo(ListView listView) {
        listView.getSelectionModel().selectedItemProperty().addListener(
                (ChangeListener<ModelFood>) (observable, oldValue, newValue) -> {
                    rangeSelectedItem = model.getListOfFoodA().indexOf(newValue);
                    //controller.getChoosenFood(newValue.getName(),newValue.getDateExpiration());
                });
    }
    private void listinit(){
        ObservableList listvide= FXCollections.observableList(new ArrayList<>());
        controller.getPerimeFoodListView().setItems(listvide);
        controller.getOkFoodListView().setItems(listvide);
        controller.getPPFoodListView().setItems(listvide);

    }

    public void initAttention(ObservableList<ModelFood> listpp) throws IOException {
        String attention="";
        for(int i =0;i<listpp.size();i++){
            ModelFood food = listpp.get(i);
            LocalDate expiraDate = food.getDateExpiration();
            if(expiraDate.compareTo(LocalDate.now())==0){
                attention+=food.getName()+" expire apr¨¨s aujourd'hui /n";
            }
        }
        System.out.println(attention);
        if(!attention.isEmpty()) {
            FXMLLoader loader = new FXMLLoader();
            // FXMLLoader loader = new FXMLLoader (getClass ().getClassLoader().getResource ("../Resources/attention.fxml"));
            Stage stage = new Stage();
            ControllerAttention controllerAttention = new ControllerAttention();

            loader.setController(controllerAttention);
            Parent root = loader.load(getClass().getResourceAsStream("Resources/attention.fxml"));
            //Parent root = loader.load (getClass().getClassLoader().);
            controllerAttention.getTxt_attention().setText(attention);
            stage.setScene(new Scene(root, 200, 100));
            stage.show();
        }
    }
}
