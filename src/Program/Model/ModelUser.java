package Program.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ModelUser {
    private String username;
    private String password;
    private StringProperty lastName;
    private StringProperty firstName;
    private StringProperty smallDescription;
    private StringProperty longDescription;

    public ModelUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void setLastName(String lastName){this.lastName = new SimpleStringProperty(lastName);}
    public void setFirstName(String firstName){this.firstName = new SimpleStringProperty(firstName);}
    public void setSmallDescription(String smallDescription){this.smallDescription = new SimpleStringProperty(smallDescription);}
    public void setLongDescription(String longDescription){this.longDescription = new SimpleStringProperty(longDescription);}

    public String getUsername() {return username;}
    public String getPassword(){return password;}
    public String getLastName(){return lastName.get();}
    public String getFirstName(){return firstName.get();}
    public String getSmallDescription(){return smallDescription.get();}
    public String getLongDescription(){return longDescription.get();}
}