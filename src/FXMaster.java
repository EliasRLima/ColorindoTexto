import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class FXMaster {
		
	/*
	 * Classe responsavel pelo design do FXML como CSS e palavras a serem pintadas
	 * */
	
	public static String[] getReservadas() {
		String[] reservadas = {"variaveis", "inicio", "fim", "ler", "escrever", "se", "entao", "senao", "e", "verdadeiro", "falso", "caso", "ou", "nao", "faca", "inicio", "enquanto", "para", "de", "repita", "ate", "passo"};
		return reservadas;
	}
	
	public static String[] getTipos() {
		String[] tipos = {"real", "cadeia", "inteiro", "logico;", "vetor", "caractere", "{", "}", "(", ")", ">", "<", "+", "=", "-", "*","/"};
		return tipos;
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static String menuBar() {
		return FXMaster.class.getResource("menubar.css").toExternalForm();
	}
	
	public static String tabPane() {
		return FXMaster.class.getResource("tabpane.css").toExternalForm();
	}
	
	public static String splitPane() {
		return FXMaster.class.getResource("splitpane.css").toExternalForm();
	}
	
	public static String codigo() {
		return FXMaster.class.getResource("txt.css").toExternalForm();
	}
	
	public static String alerta() {
		return FXMaster.class.getResource("alertas.css").toExternalForm();
	}
	
	
}
