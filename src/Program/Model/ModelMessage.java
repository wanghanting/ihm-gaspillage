package Program.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ModelMessage {
    private ModelUser sender;
    private ModelUser receivor;
    private LocalDateTime date;
    private String message;

    public ModelMessage(ModelUser User,ModelUser receivor, String message,LocalDateTime date){
        this.sender = User;
        this.receivor = receivor;
        this.date = date;
        this.message = message;
    }
    public LocalDateTime getDate() {return date;}
    public String getMessage() {return message;}
    public ModelUser getSender(){return sender;}
    public ModelUser getReceivor(){return receivor;}
}
