package Program.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelTag {
    private StringProperty name;

    public ModelTag(String name){this.name= new SimpleStringProperty(name); }

    public void setName(String name){this.name=new SimpleStringProperty(name);}

    public String getName(){return name.get();}
}
