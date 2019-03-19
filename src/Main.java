import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	Codage codage;
	
	@Override
	public void start(Stage primaryStage) {	
		try {
	        
			GridPane grid = new GridPane();
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));	        

	        Text erreurText = new Text("");
	        Text scenetitle = new Text("Bienvenue dans l'appli Codage ");
	        scenetitle.setFont(Font.font("Calibri", FontWeight.NORMAL, 20));
	        grid.add(scenetitle, 0, 0, 2, 1);

	        grid.add( new Label("Code binaire :") , 0, 1);
	        TextField binaryCode = new TextField();
	        binaryCode.setText("0110010");
	        grid.add(binaryCode, 1, 1);
	        
	        grid.add( new Label("Type de graphe :") , 0, 2);
	        
	        final ComboBox<String> TypeComboBox = new ComboBox();
	        TypeComboBox.getItems().addAll(
	        	"NRZ",
	            "Manchester"
	        );
	        grid.add(TypeComboBox, 1, 2);

	        Button btn = new Button();
	        btn.setText("Valider");
	        btn.setOnAction(new EventHandler<ActionEvent>() {	 
	            @Override
	            public void handle(ActionEvent event) {	            	
	            	String erreur = "";	            	
	            	if( binaryCode.getText().isEmpty() ) {		            	
	            		erreur = "SVP : Tapez un code binaire !!";	            	
	            	}else if( !binaryCode.getText().replaceAll("[01]", "").isEmpty() ) {	            	
	            		erreur = "SVP : Tapez un valide code binaire !!";	            	
	            	}else if( TypeComboBox.getValue() == null ) {	            		
	            		erreur = "SVP : choisir un type pour contenu !!";	            	
	            	}else  {
		            	switch( TypeComboBox.getValue().toString() ) {
		            		case "NRZ":
		            			codage = new NRZ();
		            			break;
		            		case "Manchester":
		            			codage = new Manchester();
		            			break;
		            	}
		            	codage.setCode( binaryCode.getText() );		            	
		            	Chart chart = new Chart();
		            	chart.setCodage( codage );
		            	chart.make();
	            	}	            	
            		erreurText.setText(erreur);
	            }
	        });
	        grid.add(btn, 1, 3);
	        grid.add(erreurText, 0, 5, 2, 1);

	        // @ Copyright/
	        grid.add(new Label("réaliser par : oubtou mohamed | rabat le 18-03-2019"), 0, 10, 2, 1);

	        Scene scene = new Scene(grid, 330, 275);
	        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			
			primaryStage.setTitle("Line Chart Sample");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}