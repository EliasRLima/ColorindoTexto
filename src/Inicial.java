
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Inicial extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("styled.fxml"));
		Scene scene = new Scene(root, 900, 600);
		stage.setScene(scene);
		stage.setTitle("Area Colorida");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
  
}
