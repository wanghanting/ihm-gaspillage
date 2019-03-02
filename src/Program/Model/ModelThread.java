package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelThread {
    private ObservableList<ModelMessage> thread;
    private ModelOtherUser otherUser;

    public ModelThread(ModelOtherUser otherUser){
        thread = FXCollections.observableList(new ArrayList<>());
    }

    public void addMessage(ModelMessage message){thread.add(message);}
    public ObservableList<ModelMessage> getThread(){return thread;}
    public ModelOtherUser getOtherUser(){return otherUser;}
}
