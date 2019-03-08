package Program.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelSum {
    private StringProperty name;
    private StringProperty sum;

    public ModelSum(String name,String sum){
        this.name = new SimpleStringProperty(name);
        this.sum = new SimpleStringProperty(sum);
    }

    public void setName(String name){
        this.name = new SimpleStringProperty(name);
    }

    public void setSum(String sum){
        this.sum = new SimpleStringProperty(sum);
    }

    public String getName(){
        return name.get();
    }

    public String getSum(){
        return sum.get();
    }
}
