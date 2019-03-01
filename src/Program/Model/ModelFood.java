package Program.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class ModelFood {
    private StringProperty name;
    private StringProperty foodType;
    private IntegerProperty quantity;
    private LocalDate datePurchase;
    private LocalDate dateExpiration;
    private IntegerProperty daysBeforeAlmostExpired;
    private StringProperty foodDescription;

    public ModelFood(String name, String foodType, int quantity, LocalDate datePurchase, LocalDate dateExpiration, int daysBeforeAlmostExpired, String foodDescription){
        this.name = new SimpleStringProperty(name);
        this.foodType = new SimpleStringProperty(foodType);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.datePurchase = datePurchase;
        this.dateExpiration = dateExpiration;
        this.daysBeforeAlmostExpired = new SimpleIntegerProperty(daysBeforeAlmostExpired);
        this.foodDescription = new SimpleStringProperty(foodDescription);
    }

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
    public LocalDate getDatePurchase(){return datePurchase;}
    public LocalDate getDateExpiration(){return dateExpiration;}
    public Integer getDaysBeforeAlmostExpired(){return daysBeforeAlmostExpired.get();}
    public String getFoodDescription(){return foodDescription.get();}
}
