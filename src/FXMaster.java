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
	
	public static String[] getReservadasNoSplit() {
		String[] reservadas = {"variaveis\0", "variaveis\n", "variaveis\t", "variaveis ",
						       "\ninicio\n", "\ninicio\t", "\ninicio ", "\tinicio\n", "\tinicio\t", "\tinicio ", " inicio\n", " inicio\t", " inicio ",
						       "\nfim.", "\tfim.", " fim.",
						       "\nler\n", "\nler\t", "\nler ", "\tler\n", "\tler\t", "\tler ", " ler\n", " ler\t", " ler ",
						       "\nescrever\n", "\nescrever\t", "\nescrever ", "\tescrever\n", "\tescrever\t", "\tescrever ", " escrever\n", " escrever\t", " escrever ",
						       "\nse\n", "\nse\t", "\nse ", "\tse\n", "\tse\t", "\tse ", " se\n", " se\t", " se ",
						       "\nentao\n", "\nentao\t", "\nentao ", "\tentao\n", "\tentao\t", "\tentao ", " entao\n", " entao\t", " entao ", 
						       "\nsenao\n", "\nsenao\t", "\nsenao ", "\tsenao\n", "\tsenao\t", "\tsenao ", " senao\n", " senao\t", " senao ", 
						       "\ne\n", "\ne\t", "\ne ", "\te\n", "\te\t", "\te ", " e\n", " e\t", " e ",
						       "\nverdadeiro\n", "\nverdadeiro\t", "\nverdadeiro ", "\tverdadeiro\n", "\tverdadeiro\t", "\tverdadeiro ", " verdadeiro\n", " verdadeiro\t", " verdadeiro ", 
						       "\nfalso\n", "\nfalso\t", "\nfalso ", "\tfalso\n", "\tfalso\t", "\tfalso ", " falso\n", " falso\t", " falso ",
						       "\ncaso\n", "\ncaso\t", "\ncaso ", "\tcaso\n", "\tcaso\t", "\tcaso ", " caso\n", " caso\t", " caso ",
						       "\nou\n", "\nou\t", "\nou ", "\tou\n", "\tou\t", "\tou ", " ou\n", " ou\t", " ou ", 
						       "\nnao\n", "\nnao\t", "\nnao ", "\tnao\n", "\tnao\t", "\tnao ", " nao\n", " nao\t", " nao ", 
						       "\nfaca\n",  "\nfaca\t", "\nfaca ", "\tfaca\n",  "\tfaca\t", "\tfaca ", " faca\n",  " faca\t", " faca ",
						       "\ninicio\n", "\ninicio\t", "\ninicio ", "\tinicio\n", "\tinicio\t", "\tinicio ", "\ninicio\n", "\ninicio\t", "\ninicio ",
						       "\nenquanto\n", "\nenquanto\t", "\nenquanto ", "\tenquanto\n", "\tenquanto\t", "\tenquanto ", " enquanto\n", " enquanto\t", " enquanto ", 
						       "\npara\n", "\npara\t", "\npara ", "\tpara\n", "\tpara\t", "\tpara ", " para\n", " para\t", " para ",
						       "\nde\n", "\nde\t", "\nde ", "\tde\n", "\tde\t", "\tde ", " de\n", " de\t", " de ",
						       "\nrepita\n", "\nrepita\t", "\nrepita ", "\trepita\n", "\trepita\t", "\trepita ", " repita\n", " repita\t", " repita ", 
						       "\nate\n", "\nate\t", "\nate ", "\tate\n", "\tate\t", "\tate ", " ate\n", " ate\t", " ate ",
						       "\npasso\n", "\npasso\t", "\npasso ", "\tpasso\n", "\tpasso\t", "\tpasso ", " passo\n", " passo\t", " passo "};
		return reservadas;
	}
	
	public static String[] getTipos() {
		String[] tipos = {"real", "cadeia", "inteiro", "logico", "vetor", "caractere", "{", "}", "(", ")", ">", "<", "+", "=", "-", "*","/"};
		return tipos;
	}
	
	public static String[] getTiposNoSplit() {
		String[] tipos = {" real ", " real;", ":real ", ":real;",
						  " cadeia ", " cadeia;", ":cadeia ", ":cadeia;",
						  " inteiro ", " inteiro;", ":inteiro ", ":inteiro;",
						  " logico ", " logico;", ":logico ", ":logico;",
						  " vetor ", " vetor;", ":vetor ", ":vetor;",
						  " caractere ", " caractere;",  ":caractere ", ":caractere;",
						  "{", "}", "(", ")", ">", "<", "+", "=", "-", "*","/"};
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
