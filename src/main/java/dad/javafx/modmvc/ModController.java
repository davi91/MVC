package dad.javafx.modmvc;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ModController {

	// view
	private ModView view;
	
	// model
	
	private IntegerProperty dato = new SimpleIntegerProperty();
	private StringProperty introducido = new SimpleStringProperty();
	
	public ModController() {
	
		view = new ModView();
		
		introducido.bind(view.getDatoTxt().textProperty());
		
		view.getSetButton().setOnAction(evt -> OnSetAction());
		view.getLowerBt().setOnAction(evt -> OnLowerBt());
		view.getNextBt().setOnAction(evt -> OnNextBt());
	}
	
	private void OnNextBt() {
		
		dato.set(dato.get()+1);
	}

	private void OnLowerBt() {
		
		dato.set(dato.get()-1);
	}

	private void OnSetAction() {

		try {
			
			int valor = Integer.parseInt(introducido.get());
			dato.set(valor);
			
		} catch( NumberFormatException ex) {
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Debe introducir un número");
			alert.showAndWait();
		}
	}

	public ModView getRootView() {
		return view;
	}

	// Es lo que vamos  a "enchufar"
	public final IntegerProperty datoProperty() {
		return this.dato;
	}
	

	public final int getDato() {
		return this.datoProperty().get();
	}
	

	public final void setDato(final int dato) {
		this.datoProperty().set(dato);
	}
	

	

}
