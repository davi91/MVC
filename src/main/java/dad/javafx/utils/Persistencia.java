package dad.javafx.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

public class Persistencia {

	private static final File FICHERO = new File(System.getProperty("user.home"), "mvc"); // La ruta del perfil de usuario
	// Guardamos y cargamos en disco
	
	public static void guardar(int dato) throws IOException {

		FileUtils.writeStringToFile(FICHERO, ""+dato, StandardCharsets.UTF_8);
	}
	
	public static int cargar() throws NumberFormatException, IOException {
		
		if( !FICHERO.exists() ) {
			return 0;
		}
		
		int dato = Integer.parseInt(FileUtils.readFileToString(FICHERO, StandardCharsets.UTF_8));
		return dato;
	}
}
