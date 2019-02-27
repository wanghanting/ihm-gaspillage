package Program.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

import java.util.Date;

public class ModelFood {
    private StringProperty name;
    private StringProperty foodType;
    private IntegerProperty quantity;
    private DatePicker datePurchase;
    private DatePicker dateExpiration;
    private IntegerProperty daysBeforeAlmostExpired;
    private StringProperty foodDescription;

    public void setName(String name){this.name = new SimpleStringProperty(name);}
    public void setFoodType(String foodType){this.foodType = new SimpleStringProperty(foodType);}
    public void setQuantity(Integer quantity){this.quantity = new SimpleIntegerProperty(quantity);}
//    public void setDatePurchase(DatePicker datePurchase){this.datePurchase = new DatePicker(datePurchase);}
//    public void setDateExpiration(DatePicker dateExpiration){this.dateExpiration = new DatePicker(dateExpiration);}
    public void setDaysBeforeAlmostExpired(Integer daysBeforeAlmostExpired){this.daysBeforeAlmostExpired = new SimpleIntegerProperty(daysBeforeAlmostExpired);}
    public void setFoodDescription(String foodDescription){this.foodDescription = new SimpleStringProperty(foodDescription);}

    public String getName(){return name.get();}
    public String getFoodType(){return foodType.get();}
    public Integer getQuantity(){return quantity.get();}
    public DatePicker getDatePurchase(){return datePurchase;}
    public DatePicker getDateExpiration(){return dateExpiration;}
    public Integer getDaysBeforeAlmostExpired(){return daysBeforeAlmostExpired.get();}
    public String getFoodDescription(){return foodDescription.get();}
}
