package loto;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import loto.gui.FrmMain;

public class Main {

	public final static int version = 1;
	public final static int release = 1;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
			UIManager.setLookAndFeel(
			            UIManager.getSystemLookAndFeelClassName());
		
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FrmMain frame = FrmMain.getInstance();		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.verifySerial();
	}
}
