/*
 * TablePopUpMenuFactory.java
 *
 * Created on 2 de Fevereiro de 2006, 21:47
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.evilframework.components.factory;

import com.dudhoo.evilframework.components.EvilTable;
import com.dudhoo.evilframework.swing.EvilError;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.KeyStroke;

/**
 *
 * @author duduzera
 */
public class TablePopUpMenuFactory {
    private  static EvilTable ev;
    private  static JPopupMenu popmenu ;
    private  static JMenu menu ;
    private static ButtonGroup group;
    private static JMenu menuAutoRed ;
    private static JRadioButtonMenuItem it[] ;
    private static Resizedor all, last, next, sub, off;
   
    private static JMenuItem menuItemRefresh;
            
    public TablePopUpMenuFactory(EvilTable _ev){
        ev = _ev;
    }
    
    public static JMenuItem getCurrentJMenuItemRefresh(){
        if(menuItemRefresh == null ){
            menuItemRefresh = new JMenuItem("Atualizar");
            menuItemRefresh.setAccelerator( KeyStroke.getKeyStroke( KeyEvent.VK_F5, 0));
            menuItemRefresh.setToolTipText("Atualizar os dados da tabela. Refaz a consulta no banco de dados.");
            
        }
        return menuItemRefresh;
    }
    
    /**
     * Seleciona no menu a opçao corresondente ao objeto
     */
    private static void setAutoResizeSelected(int mode){
        try{
            switch(mode){
                case JTable.AUTO_RESIZE_ALL_COLUMNS:{
                    it[0].setSelected(true);
                    break;
                }
                case JTable.AUTO_RESIZE_LAST_COLUMN:{
                    it[1].setSelected(true);
                    break;
                }
                case JTable.AUTO_RESIZE_NEXT_COLUMN:{
                    it[2].setSelected(true);
                    break;
                }
                case JTable.AUTO_RESIZE_OFF:{
                    it[4].setSelected(true);
                    break;
                }
                case JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS:{
                    it[3].setSelected(true);
                    break;
                }
            }
        }catch(NullPointerException eee){
            new EvilError(null, false, new NullPointerException("O menu está null."));
        }
    }
    public static JMenu getMenuAutoredimensionamentoColunas(int mode, EvilTable _evil) throws NullPointerException{
        ev = _evil;
        if(ev == null){
            throw new NullPointerException("EvilTable não pode ser null.");
        }
        if(popmenu == null){
            popmenu = new JPopupMenu();
        }
        
        if(menu == null){
            menu = new JMenu("colunas");
        }
        popmenu.add(menu);
        
        criaItemsAutoRedimensionamento(menu);
        setAutoResizeSelected(mode);
        return menu;
    }
    
    private static void criaItemsAutoRedimensionamento(JMenu menu){
        if(menuAutoRed ==null){
            menuAutoRed  = new JMenu("redimensionamento");
        }
        menuAutoRed.setToolTipText("Altera o comportamento que as colunas têm quando são redimensionadas");
        menu.add(menuAutoRed);
        
        if(group  == null){
            group = new ButtonGroup();
        }
        
        if(it == null ){
            it = new JRadioButtonMenuItem[5];
            for (int i = 0 ; i < it.length; i++){
            it[ i ] = new JRadioButtonMenuItem();
            menuAutoRed.add( it[i] );
            group.add(it[i]);
        }
        }
        
        all = new Resizedor(ev, JTable.AUTO_RESIZE_ALL_COLUMNS);
        it[0].setText("Todas colunas");
        it[0].addActionListener(all);
        
        last = new Resizedor(ev, JTable.AUTO_RESIZE_LAST_COLUMN);
        it[1].setText("Última coluna");
        it[1].addActionListener(last);
        
        next = new Resizedor(ev, JTable.AUTO_RESIZE_NEXT_COLUMN);
        it[2].setText("Próxima coluna");
        it[2].addActionListener(next);
        
        sub = new Resizedor(ev, JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        it[3].setText("Colunas subsequentes");
        it[3].addActionListener(sub);
        
        it[4].setText("Desabilitado");
        off = new Resizedor(ev, JTable.AUTO_RESIZE_OFF);
        it[4].addActionListener(off);
    }
    
}
//inner class
class Resizedor implements ActionListener{
    private int state;
    private EvilTable ev;
    public Resizedor(EvilTable _ev, int theState){
        ev = _ev;
        state = theState;
    }
    public void actionPerformed(ActionEvent e){
        try{
            ev.setAutoResizeMode(state);
        }catch(Exception xxx){
            new EvilError(null, false, xxx).setVisible(true);
        }
    }
}