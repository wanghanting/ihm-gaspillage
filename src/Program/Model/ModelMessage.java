package Program.Model;

import java.time.LocalDateTime;

public class ModelMessage {
    private ModelOtherUser otherUser;
    private boolean isOtherUserTheSender;
    private LocalDateTime date;
    private String message;

    public ModelMessage(ModelOtherUser otherUser, boolean isOtherUserTheSender, String message){
        this.otherUser = otherUser;
        this.isOtherUserTheSender = isOtherUserTheSender;
        this.date = date.now();
        this.message = message;
    }

    public ModelOtherUser getOtherUser() {return otherUser;}
    public boolean getIsOtherUserTheSender() {return isOtherUserTheSender;}
    public LocalDateTime getDate() {return date;}
    public String getMessage() {return message;}
}
