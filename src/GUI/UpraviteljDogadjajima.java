import Events.Dogadjaji;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
 
public class UpraviteljDogadjajima extends Application {
 
    //public TableView table = new TableView();
    private TableView<Dogadjaji> table = new TableView<Dogadjaji>();
    public final ObservableList<Dogadjaji> data = FXCollections.observableArrayList(
        new Dogadjaji("OK fest4", "31.6.2017", "2.7.2017", "Festival", "Nektar pivara", "Svi ucesnici kampa"),
        new Dogadjaji("OK fest2", "31.6.2017", "2.7.2017", "Festival", "Nektar pivara", "Svi ucesnici kampa"),
        new Dogadjaji("OK fest3", "31.6.2017", "2.7.2017", "Festival", "Nektar pivara", "Svi ucesnici kampa")
    );
 
    public static void main(String[] args) {		
        launch(args);		
    }
      
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Upravitelj Dogadjajima");
        stage.setWidth(800);
        stage.setHeight(600);
        Stage stage1 = new Stage();
        Scene scene1 = new Scene(new Group());
        stage1.setTitle("Dodavanje dogadjaja");
        stage1.setWidth(800);
        stage1.setHeight(600);
        final Label label = new Label("Tabela svih dogadjaja");
        label.setFont(new Font("Arial", 20));
        final HBox hb = new HBox();
        final HBox hb1 = new HBox();
        table.setEditable(true);
 //naziv, datum i vrijeme održavanja (početak i kraj), opis, organizatora i učesnike
        TableColumn nameCol = new TableColumn("Naziv");
        nameCol.setCellValueFactory(
            new PropertyValueFactory<Dogadjaji,String>("name")
        );
        
        TableColumn dateTimeCol = new TableColumn("Datum i vrijeme");
        TableColumn startDateTimeCol = new TableColumn("Start");
        startDateTimeCol.setCellValueFactory(
            new PropertyValueFactory<Dogadjaji,String>("startDateTime")
        );
        TableColumn endDateTimeCol = new TableColumn("Kraj");
        endDateTimeCol.setCellValueFactory(
            new PropertyValueFactory<Dogadjaji,String>("endDateTime")
        );
        dateTimeCol.getColumns().addAll( startDateTimeCol, endDateTimeCol);
        
        TableColumn describeCol = new TableColumn("Opis");
        describeCol.setCellValueFactory(
            new PropertyValueFactory<Dogadjaji,String>("describe")
        );
        TableColumn organizatorCol = new TableColumn("Organizator");
        organizatorCol.setCellValueFactory(
            new PropertyValueFactory<Dogadjaji,String>("organizator")
        );
        
        TableColumn actorsCol = new TableColumn("Ucesnici");
        actorsCol.setCellValueFactory(
            new PropertyValueFactory<Dogadjaji,String>("actors")
        );
        
        table.setItems(data);
        table.getColumns().addAll(nameCol, dateTimeCol, describeCol, organizatorCol, actorsCol);
  
        final TextField addName= new TextField();		
        addName.setPromptText("Naziv");		
        addName.setMaxWidth(nameCol.getPrefWidth());		
        final TextField addStartTime = new TextField();		
        addStartTime.setMaxWidth(startDateTimeCol.getPrefWidth());		
        addStartTime.setPromptText("Vrijeme pocetka");		
        final TextField addEndTime = new TextField();		
        addEndTime.setMaxWidth(endDateTimeCol.getPrefWidth());		
        addEndTime.setPromptText("Vrijeme zavrsetka");	
        final TextField addDescribe= new TextField();		
        addDescribe.setPromptText("Opis");		
        addDescribe.setMaxWidth(nameCol.getPrefWidth());
        final TextField addOrganizator= new TextField();		
        addOrganizator.setPromptText("Organizator");		
        addOrganizator.setMaxWidth(nameCol.getPrefWidth());
        final TextField addActors= new TextField();		
        addActors.setPromptText("Ucesnici");		
        addActors.setMaxWidth(nameCol.getPrefWidth());
 		
        final Button addButton = new Button("Add");		
        addButton.setOnAction(new EventHandler<ActionEvent>() {		
            @Override		
            public void handle(ActionEvent e) {
                stage1.setScene(scene1);
                stage1.show();
                data.add(new Dogadjaji(		
                        addName.getText(),		
                        addStartTime.getText(),		
                        addEndTime.getText(),
                        addDescribe.getText(),
                        addOrganizator.getText(),
                        addActors.getText()));		
                addName.clear();		
                addStartTime.clear();		
                addEndTime.clear();
                addDescribe.clear();
                addOrganizator.clear();
                addActors.clear();
            }		
        });		
 		
        hb.getChildren().addAll(addName, addStartTime, addEndTime, addDescribe, addOrganizator, addActors);		
        hb.setSpacing(3);
        hb1.getChildren().addAll(addButton);		
        hb1.setSpacing(3);
        
        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(15, 0, 0, 15));
        vbox.getChildren().addAll(label, table,hb1);
        final VBox vbox1 = new VBox();
        vbox1.setSpacing(10);
        vbox1.setPadding(new Insets(15, 0, 0, 15));
        vbox1.getChildren().addAll(hb);
        ((Group) scene1.getRoot()).getChildren().addAll(vbox1);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
        
    }
}