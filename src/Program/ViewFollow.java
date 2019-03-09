//package Program;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.control.ListCell;
//import javafx.scene.control.ListView;
//import javafx.util.Callback;
//
//import java.io.IOException;
//
//public class ViewFollow {
//    public static final String MSG = "Resources/messages.fxml";
//
//    /**
//     * display each item of the ListView
//     * Automatically called if the ModelListCustomers.listOfCustumers is changed
//     * @param listView the element to be filled
//     */
//    private void adaptItems(ListView listView) {
//        //Set a new cell factory to use in the ListView.
//        listView.setCellFactory(
//                //  first parameter specifies the type of the object passed in to the call method
//                //  the second parameter specifying the return type of the method.
//                new Callback<ListView, ListCell> () {
//                    //define what to do when ModelListCustomers.listOfCustumers is changed
//                    @Override
//                    public ListCell call(ListView listView) {
//                        return new ListCell() {
//                            @Override
//                            protected void updateItem(Object item, boolean empty) {
//                                super.updateItem(item, empty);
//                                if (item != null) {
//                                    Parent listElement=null;
//                                    // Load fxml file for this Person
//                                    FXMLLoader loader = new FXMLLoader(getClass().getResource(PERSON));
//                                    //create the person controller
//                                    ControllerPerson personController = new ControllerPerson();
//                                    //attach the person controller to this person
//                                    loader.setController(personController);
//                                    try {
//                                        listElement = loader.load(getClass().getResourceAsStream(PERSON));
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }
//                                    //initialize the person controller
//                                    personController.init((ModelPerson) item);
//                                    // Display content of the fxml file
//                                    setGraphic(listElement);
//                                    adaptItems(listView);
//
//                                    //remove TextField name contents
//                                    controller.getNameField().setText("");
//                                }
//                            }
//
//                        };
//                    }
//                });
//    }
//}
