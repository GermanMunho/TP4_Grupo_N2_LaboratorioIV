package ejercicio3;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Validaciones {
	
	public static void JtextFieldEsNumero(KeyEvent evt) {
		
		int k=(int)evt.getKeyChar();
		if(k>=97 && k<=122||k>=65 && k<=90) {
			evt.setKeyChar((char)KeyEvent.VK_CLEAR);
			JOptionPane.showMessageDialog(null, "No puede ingresar letras!!","Validando Datos",JOptionPane.ERROR_MESSAGE);
			}
		}
		 
		public static void JtextFieldEsPositivo(KeyEvent evt) {
			
			int k=(int)evt.getKeyChar();
			if(k==45) {
				evt.setKeyChar((char)KeyEvent.VK_CLEAR);
				JOptionPane.showMessageDialog(null, "No puede ingresar numeros negativos!!","Validando Datos",JOptionPane.ERROR_MESSAGE);
				}
			}
	
	public static boolean verificarNumero(String cadenaNumero) {
		boolean NUMERO_VALIDO = true;
		
		try {
			if(Float.parseFloat(cadenaNumero) < 1.0f || Float.parseFloat(cadenaNumero) > 10.0f) {
				NUMERO_VALIDO=false;
			}
		}catch(Exception e) {
			NUMERO_VALIDO = false;
		}			
		
		return NUMERO_VALIDO;
	}
}
