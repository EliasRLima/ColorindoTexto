

import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.StyleClassedTextArea;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;

public class ControllerPrincipal implements Initializable{

	@FXML
	CodeArea texto;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		/*
		 * Classe responsavel pelo controle do texto
		 * */
		
		texto.getStylesheets().add(FXMaster.codigo());
		texto.setParagraphGraphicFactory(LineNumberFactory.get(texto));
		texto.setWrapText(true);
		texto.setLineHighlighterOn(true);
		texto.setStyle("-fx-font-size: 24; -fx-font-weight: bold;-fx-border-color: #1a1a1a");
		
		texto.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
	        public void handle(KeyEvent ke){
				
				KeyCombination combintation = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_ANY);
	            if (combintation.match(ke)) {
	        		
	        		int in = 0, out = 0;
	        		String[] palavras = FXMaster.getReservadasNoSplit();
	        		for(int loop = 0; loop < palavras.length; loop++) {
	        			do {
	        				in = texto.getText().indexOf(palavras[loop], in);
	        				if(in != -1) {
	        					texto.setStyleClass(in, in+palavras[loop].length(), "reservadas");
		        				in += palavras[loop].length();
	        				}
	        				
	        			}while(in != -1);
	        			in = 0;
	        		}
	        		
	        		palavras = FXMaster.getTiposNoSplit();
	        		for(int loop = 0; loop < palavras.length; loop++) {
	        			do {
	        				in = texto.getText().indexOf(palavras[loop], in);
	        				if(in != -1) {
	        					texto.setStyleClass(in, in+palavras[loop].length(), "tipos");
	        					in += palavras[loop].length();
	        				}
	        				
	        			}while(in != -1);
	        			in = 0;
	        		}
	        		
	        		int inString = texto.getText().indexOf('"');
        			int outString;
	        		while(inString != -1) {
	        			outString = texto.getText().indexOf('"',inString+1);
	        			if(outString >= 0) {
	        				texto.setStyleClass(inString, outString+1, "texto");
	        				inString = texto.getText().indexOf('"',outString+1);
	        				continue;
	        			}else {
	        				texto.setStyleClass(inString, inString, "texto");
	        			}
	        			inString = texto.getText().indexOf('"',inString+1);
	        		}
	        		
	        		inString = texto.getText().indexOf("'");
	        		while(inString != -1) {
	        			outString = texto.getText().indexOf("'",inString+1);
	        			if(outString >= 0) {
	        				texto.setStyleClass(inString, outString+1, "texto");
	        				inString = texto.getText().indexOf("'",outString+1);
	        				continue;
	        			}else {
	        				texto.setStyleClass(inString, inString, "texto");
	        			}
	        			inString = texto.getText().indexOf("'",inString+1);
	         			
	        		}
	        		
	        	}
				
	            else if( ke.getText().equals(";") ||
	            	ke.getText().equals(".") ||
	            	ke.getCode().equals(KeyCode.ENTER) || 
	            	ke.getCode().equals(KeyCode.BACK_SPACE) || 
	            	ke.getCode().equals(KeyCode.DELETE) || 
	            	ke.getCode().equals(KeyCode.SPACE) || 
	            	ke.getCode().equals(KeyCode.TAB))
	            {
	                int comecoDaLinha = texto.getText().lastIndexOf("\n", texto.getCaretPosition()-1);
	                int finalDaLinha = texto.getText().indexOf("\n",texto.getCaretPosition()); //se == -1 é a ultima
	                int comecoDaLinhaAnt = 0;
	                
	                if(finalDaLinha == -1 && comecoDaLinha != -1)
	                	texto = colorirArea(texto,comecoDaLinha+1);
	                else if(finalDaLinha == -1 && comecoDaLinha == -1)
	                	texto = colorirArea(texto,0);
	                else if(finalDaLinha != -1 && comecoDaLinha == -1)
	                	texto = colorirArea(texto,0, finalDaLinha);
	                else
	                	texto = colorirArea(texto,comecoDaLinha, finalDaLinha);
	                
	                if(comecoDaLinha > 1) {
	                	comecoDaLinhaAnt = texto.getText().lastIndexOf("\n", comecoDaLinha-1);
	                	if(comecoDaLinhaAnt == -1)
	                		texto = colorirArea(texto,0,comecoDaLinha);
	                	else
	                		texto = colorirArea(texto,comecoDaLinhaAnt,comecoDaLinha);
	                }
	            }
	            
	            
	            
	        }
		});
		
	}
	
	public static CodeArea colorirArea(CodeArea area, int in, int out) {
		String texto = "";
		 try {
			 texto = area.getText().replace("\t"," ").substring(in,out);
			 if(texto.indexOf("\n")==0)
				 in++;
			 texto = area.getText().replace("\t"," ").substring(in,out);
				 
		 }catch(Exception e) {
			 System.out.println("subs falhou para " + in + " e " + out + " em " + area.getText().replace("\t"," "));
			 return area;
		 }
		  
		 String linha[] = texto.split(" ",-1);
		 
		 try {
			 area.setStyleClass(in, out, "variaveis");
		 }catch(Exception e) {
			 System.out.println("pintar falhou para " + in + " e " + out + " em " + area.getText().replace("\t"," "));
			 return area;
		 }
		 for(int loop = 0; loop < linha.length; loop++) {
				if(Arrays.asList(FXMaster.getReservadas()).contains(linha[loop]) || Arrays.asList(FXMaster.getReservadas()).contains("\n"+linha[loop])) { //verifica se eh reservada
					int i = texto.indexOf(linha[loop]);
					while(i >= 0) {
						area.setStyleClass(in+i, in+i+linha[loop].length(), "reservadas");
					    i = texto.indexOf(linha[loop], i+1);
					}
				}else if(Arrays.asList(FXMaster.getTipos()).contains(linha[loop]) || Arrays.asList(FXMaster.getTipos()).contains("\n"+linha[loop])) { //verifica se eh tipo
					int i = texto.indexOf(linha[loop]);
					while(i >= 0) {
						area.setStyleClass(in+i, in+i+linha[loop].length(), "tipos");
					    i = texto.indexOf(linha[loop], i+1);
					}
				}else if(FXMaster.isNumeric(linha[loop]) || FXMaster.isNumeric(linha[loop].replace("\n", "")) ){ //verificar se eh number
					int i = texto.indexOf(linha[loop]);
					while(i >= 0) {
						area.setStyleClass(in+i, in+i+linha[loop].length(), "constantes");
					    i = texto.indexOf(linha[loop], i+1);
					}
				}
			}
		
		if(texto.indexOf('"') >= 0) {
			int inString = texto.indexOf('"');
			int outString = texto.indexOf('"',inString+1);
			if(outString >= 0) {
				area.setStyleClass(in+inString, in+outString+1, "texto");
			}else {
				area.setStyleClass(in+inString, in+inString, "texto");
			}
		}
		
		if(texto.indexOf("'") >= 0) {
			int inString = texto.indexOf("'");
			int outString = texto.indexOf("'",inString+1);
			if(outString >= 0) {
				area.setStyleClass(in+inString, in+outString+1, "texto");
			}else {
				area.setStyleClass(in+inString, in+inString, "texto");
			}
		}
		
		return area;
	}
	
	public static CodeArea colorirArea(CodeArea area, int in) {
		colorirArea(area, in, area.getText().length());
		
		return area;
	}
	
}
