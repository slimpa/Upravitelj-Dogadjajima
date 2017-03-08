package Events;
import javafx.beans.property.SimpleStringProperty;

public  class Dogadjaji {
    //nameCol, dateTimeCol, describeCol, organizatorCol, actorsCol
    public final SimpleStringProperty name;
    public final SimpleStringProperty startDateTime;
    public final SimpleStringProperty endDateTime;
    public final SimpleStringProperty describe;
    public final SimpleStringProperty organizator;
    public final SimpleStringProperty actors;
 
    public Dogadjaji(String name, String startDT, String endDT, String describe, String organizator, String actors) {
        this.name = new SimpleStringProperty(name);
        this.startDateTime = new SimpleStringProperty(startDT);
        this.endDateTime = new SimpleStringProperty(endDT);
        this.describe = new SimpleStringProperty(describe);
        this.organizator = new SimpleStringProperty(organizator);
        this.actors = new SimpleStringProperty(actors);
    }
 
    public String getName() {
        return name.get();
    }
    public void setName(String fName) {
        name.set(fName);
    }
        
    public String getStartDateTime() {
        return startDateTime.get();
    }
    public void setStartDateTime(String fName) {
        startDateTime.set(fName);
    }
    
    public String getEndDateTime() {
        return endDateTime.get();
    }
    public void setEndDateTime(String fName) {
        endDateTime.set(fName);
    }
    
    public String getDescribe() {
        return describe.get();
    }
    public void setDescribe(String fName) {
        describe.set(fName);
    }
    
    public String getOrganizator() {
        return organizator.get();
    }
    public void setOrganizator(String fName) {
        organizator.set(fName);
    }
    
    public String getActors() {
        return actors.get();
    }
    public void setActors(String fName) {
        actors.set(fName);
    }
    
        
}