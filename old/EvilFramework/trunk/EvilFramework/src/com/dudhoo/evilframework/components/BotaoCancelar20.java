/*
 * BotaoCancelar20.java
 *
 * Created on 8 de Fevereiro de 2006, 21:35
 */

package com.dudhoo.evilframework.components;

/**
 *
 * @author  duduzera
 */
public class BotaoCancelar20 extends javax.swing.JButton{

    /** Creates new form BeanForm */
    public BotaoCancelar20(){
	initComponents();
    }

  
    private void initComponents(){

	setIcon(new javax.swing.ImageIcon(getClass()
				   .getResource("/com/dudhoo/evilframework/resources/images/stock_cancel_20.png")));
	setMnemonic('C');
	setText("Cancelar");
	setToolTipText("Cancelar");
    }
    
}
