package dad.javafx.modmvc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModView extends VBox {

	private Label datoLbl;
	private TextField datoTxt;
	private Button setButton;
	private Button lowerBt, nextBt;
	
	public ModView() {
		super();
		
		datoLbl = new Label("Valor:");
		
		datoTxt = new TextField();
		datoTxt.setPrefColumnCount(2);
		
		setButton = new Button("Establecer");
		setButton.setDefaultButton(true);
		
		lowerBt = new Button("<<");
		nextBt = new Button(">>");
		
		HBox datoBox = new HBox(5, datoLbl, datoTxt);
		datoBox.setAlignment(Pos.BASELINE_CENTER);
		HBox modBox = new HBox(5, lowerBt, nextBt);
		modBox.setAlignment(Pos.BASELINE_CENTER);
		
		setSpacing(5);
		setAlignment(Pos.CENTER);
		
		getChildren().addAll(datoBox, setButton, modBox);
		
	}

	public Label getDatoLbl() {
		return datoLbl;
	}

	public TextField getDatoTxt() {
		return datoTxt;
	}

	public Button getSetButton() {
		return setButton;
	}

	public Button getLowerBt() {
		return lowerBt;
	}

	public Button getNextBt() {
		return nextBt;
	}

}
