package dad.javafx.vermvc;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class VerController {

	// view
	private VerView view = new VerView();
	
	// model, no siempre es necesaria una clase
	private IntegerProperty dato = new SimpleIntegerProperty();
	
	public VerController() {
		
		// Una property para la barra de progreso
		view.getDatoProgress().progressProperty().bind(dato.divide(100.0));
		view.getDatoLbl().textProperty().bind(Bindings.concat("Valor actual: ").concat(dato));
	}
	

	public VerView getRootView() {
		return view;
	}


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
