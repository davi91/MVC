package dad.javafx.vermvc;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

public class VerView extends VBox {

	private ProgressBar datoProgress;
	private Label datoLbl;
	
	public VerView() {
		super();
		
		datoProgress = new ProgressBar();
		datoProgress.setPrefWidth(150);
		
		datoLbl = new Label();
		
		setSpacing(5);
		setAlignment(Pos.CENTER);
		getChildren().addAll(datoProgress, datoLbl);
		
	}

	public ProgressBar getDatoProgress() {
		return datoProgress;
	}

	public Label getDatoLbl() {
		return datoLbl;
	}
}
