package Program.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelRate {
    private StringProperty name;
    private StringProperty rate;

    public ModelRate(String name,String rate){
        this.name = new SimpleStringProperty(name);
        this.rate = new SimpleStringProperty(rate);
    }

    public void setName(String name){
        this.name = new SimpleStringProperty(name);
    }

    public void setRate(String rate){
        this.rate = new SimpleStringProperty(rate);
    }

    public String getName(){
        return name.get();
    }

    public String getRate(){
        return rate.get();
    }
}
