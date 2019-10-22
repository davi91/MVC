package dad.javafx.main;

import dad.javafx.modmvc.ModController;
import dad.javafx.utils.Persistencia;
import dad.javafx.vermvc.VerController;
import dad.javafx.vermvc.VerView;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	// Este sería como un supercontrolador
	
	// view
	private VerController verController;
	private ModController modController;
	
	// mode
	private IntegerProperty dato = new SimpleIntegerProperty(-1);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		verController = new VerController();
		modController = new ModController();
		
		verController.datoProperty().bind(dato);
		modController.datoProperty().bindBidirectional(dato);
		
		Scene scene = new Scene(verController.getRootView(), 320, 200);
		
		primaryStage.setTitle("Ver");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Scene secScene = new Scene(modController.getRootView(), 320, 200);
		
		Stage secStage = new Stage();
		secStage.setTitle("Modificar");
		secStage.setX(primaryStage.getX() + primaryStage.getWidth());
		secStage.setY(primaryStage.getY());
		secStage.setScene(secScene);
		secStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * Cuando comienza y termina el JavaFX -> Platform.exit()
	 */
	@Override
	public void init() throws Exception {
		try {
			dato.set(Persistencia.cargar());
		} catch (Exception e) {
			dato.set(0); // En caso de que no pudo cargar el dato
		}
		super.init();
	}

	@Override
	public void stop() throws Exception {
		Persistencia.guardar(dato.get());
		super.stop();
	}

}
