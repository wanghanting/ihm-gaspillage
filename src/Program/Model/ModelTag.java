package Program.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelTag {
    private StringProperty tagName;

    public ModelTag(String name){this.tagName= new SimpleStringProperty(name); }

    public void setName(String name){this.tagName=new SimpleStringProperty(name);}

    public String getName(){return  tagName.get();}
}
