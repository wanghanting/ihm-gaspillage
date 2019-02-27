package Program.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class ModelOtherUser {
    private String lastName;
    private String firstName;
    private String shortDescription;
    private String longDescription;
    private BooleanProperty followUser;
    private BooleanProperty isFollowedByUser;

    public ModelOtherUser(String lastName, String firstName, String shortDescription, String longDescription, Boolean followUser, Boolean isFollowedByUser){
        this.lastName = lastName;
        this.firstName = firstName;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.followUser = new SimpleBooleanProperty(followUser);
        this.isFollowedByUser = new SimpleBooleanProperty(isFollowedByUser);
    }

    public void setFollowUser(Boolean followUser){
        this.followUser = new SimpleBooleanProperty(followUser);
    }

    public void setIsFollowedByUser(Boolean isFollowedByUser){
        this.isFollowedByUser = new SimpleBooleanProperty(isFollowedByUser);
    }

    public String getLastName(){return lastName;}
    public String getFirstName(){return firstName;}
    public String getShortDescription(){return shortDescription;}
    public String getLongDescription(){return longDescription;}
    public Boolean getFollowUser(){return followUser.get();}
    public Boolean getIsFollowedByUser(){return isFollowedByUser.get();}
}
