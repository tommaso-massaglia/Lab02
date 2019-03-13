package it.polito.tdp.alien;
	
import it.polito.tdp.alien.model.AlienModel;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AlienModel model = new AlienModel();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Alien.fxml"));
			
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			AlienController controller = loader.getController();
			controller.setModel(model);
			
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
