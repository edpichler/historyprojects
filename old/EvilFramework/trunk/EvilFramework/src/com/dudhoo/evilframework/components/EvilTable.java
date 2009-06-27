/*
 * EvilTable.java
 *
 * Created on 24 de Janeiro de 2006, 22:44
 */

package com.dudhoo.evilframework.components;

import com.dudhoo.evilframework.components.factory.TablePopUpMenuFactory;
import com.dudhoo.evilframework.event.RefreshListener;
import com.dudhoo.evilframework.jdbc.Containing;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.util.EventUtil;
import com.dudhoo.evilframework.util.EvilTextFormatter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;


/**
 * Um painel do qual contém uma tabela.
 * @author  duduzera
 */
public class EvilTable extends JPanel  {

    private JComboBox comboCampos;
    private JLabel jLabelStatus;
    private JPanel jPanel1;
    private JPanel jPanelStatus;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextFieldKeyWords;
   
    private Integer indexPrimaryKey = null;

    private ActionListener actionRefresh;

    Logger log = Logger.getLogger(this.getClass());
    JPopupMenu pop;

    private FilteredRowSet filteredRowSet;

    /**
     * Os RefreshListeners do objeto
     * */
    private List < RefreshListener > refreshListeners = null;
    private GridBagLayout gridBagLayout = new GridBagLayout();

    public EvilTable() {
	jbInit();	
	addHeaderListener();	
    }

    private void addHeaderListener(){
        jTable1.getTableHeader().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
    }

    /**
     * return true se existe linha selecionada na tabela
     */
    public boolean isAlgumaLinhaSelecionada(){
        if(this.jTable1.getSelectedRow() != -1){
            return true;
        }else{
            return false;
        }
    }

    public void addRefreshListener(RefreshListener refr){
        if(this.refreshListeners == null){
            this.refreshListeners = new ArrayList();
        }
        this.refreshListeners.add(refr);
    }

    public boolean removeRefreshListener(RefreshListener refr){
        if(this.refreshListeners != null){
            return this.refreshListeners.remove(refr);
        }else{
            return false;
        }
    }

    /**
     *Se não tiver nada selecionado volta null
     */
    public Object getIdCampoSelecionado() throws NullPointerException{
        if(indexPrimaryKey == null){
            throw new NullPointerException("Não foi setado qual coluna " +
                    "correspondia à primary key da tabela. Não é possível retornar um dado.");
        }
        if(isAlgumaLinhaSelecionada()){
            return jTable1.getModel().getValueAt(this.jTable1.getSelectedRow(), indexPrimaryKey - 1); //-1 por que começa de zero
        }else{
            throw new NullPointerException("Não foi selecionado nenhum registro da tabela");
        }
    }

    /**
     * Seta os dados do rowset para a tabela.
     *@param _indexPrimaryKey o indice da coluna primary key da pesquisa. começa por 1
     *@param showPrimaryKey se é pra mostrar o campo primary key na tabela
     */
    public void setFilteredRowSet(FilteredRowSet crs, Integer _indexPrimaryKey/*, boolean showPrimaryKey*/) throws Exception{
        filteredRowSet = crs;
	if(filteredRowSet  == null){
            this.jTable1.setModel(null);
        }else{
            try{
		crs.beforeFirst();
                int colunasCount = crs.getMetaData().getColumnCount();
                if((indexPrimaryKey != null) && colunasCount < indexPrimaryKey){
                    throw new Exception("A chave primária é a coluna " +
                            indexPrimaryKey +
                            ". Mas a pesquisa retornou apenas" + colunasCount + " colunas.");
                }else if((indexPrimaryKey != null) && indexPrimaryKey < 1 ){
                    indexPrimaryKey = null;
                }

                DefaultTableModel model ;
                model = new DefaultTableModel();
                String columnNames[] = new String[ colunasCount ];
                String temp;
                for(int i = 0 ; i < colunasCount; i++){
		    temp = EvilTextFormatter.transformIniciaisMaiusculas(crs.getMetaData().getColumnName(i + 1).replace("_"," "));
                    columnNames[i] = temp;
                }
		temp = null;

                atualizaComboCampos(columnNames);
                model.setColumnIdentifiers(columnNames);
                while(crs.next()){
                    Object rowData[] = new Object[colunasCount];
                    for(int i = 1; i <= colunasCount; i++ ){
                        rowData[i - 1] = crs.getObject(i);
                    }
                    model.addRow(rowData);
                }
                jTable1.setModel(model);

                this.atualizaStatusRodapé();
                indexPrimaryKey = _indexPrimaryKey;
            }catch(SQLException e){
		Object o = null;
		if((this.getParent() != null) && (this.getParent() instanceof Frame) ){
		    o = this.getParent();
		}
                new EvilError((o == null ? null : (Frame)o), false, e).setVisible(true);;
                log.error("Erro ao preencher tabela com linhas: " + e.getMessage());
            }
        }
    }
    private void atualizaStatusRodapé(){
        if(this.jTable1 != null){
            if(this.jTable1.getModel() != null){
                int count = this.jTable1.getModel().getRowCount();
                this.jLabelStatus.setText(count + " registros.");
            }
        }
    }

    /**
     * Mostra menu de contexto
     */

    private void mostraPopUpMenu(int x, int y){
        try{

            if(pop == null){
                pop = new JPopupMenu();
            }
            pop.add( TablePopUpMenuFactory.getMenuAutoredimensionamentoColunas( this.jTable1.getAutoResizeMode(), this ) );

            //refresh
            JMenuItem itemRefresh = TablePopUpMenuFactory.getCurrentJMenuItemRefresh();
            setActionListener(itemRefresh);
            pop.add( itemRefresh);

            pop.show(this, x, y);
        }catch(NullPointerException ere){
            pop = null;
            new EvilError(null, false, ere).setVisible(true);
        }
    }

    private void setActionListener(JMenuItem item){
        if(actionRefresh == null){
            actionRefresh = new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    if(refreshListeners != null && refreshListeners.size() > 0){
                        callRefresh();
                    }
                }
            };
        }
        new EventUtil().removeAllActionListeners(item);
        item.addActionListener(actionRefresh);
    }

    /**executa os refreshListeners*/
    private void callRefresh(){
        for(int i = 0; i < refreshListeners.size(); i++){
            refreshListeners.get(i).doWhenRefreshIsCalled();
        }
    }

    private void jbInit() {
        jScrollPane1 = new JScrollPane();
        jPanel1 = new JPanel();
	jTable1 = new JTable();
        comboCampos = new JComboBox();
        jTextFieldKeyWords = new JTextField();
        jPanelStatus = new JPanel();
        jLabelStatus = new JLabel();

        setLayout(new BorderLayout());

        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {"Sem dados..."}
            },
            new String [] {
                "Coluna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

	jTextFieldKeyWords.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			setFiltro(e);
		    }
		});
	jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, BorderLayout.CENTER);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Filtragem de dados"));
	jPanel1.setLayout(gridBagLayout);
	jPanel1.add(comboCampos,
	     new GridBagConstraints(0, 0, 1, 1, 0.01, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

	jPanel1.add(jTextFieldKeyWords,
	     new GridBagConstraints(1, 0, 1, 1, 0.01, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 3, 5, 5), 0, 0));

        add(jPanel1, BorderLayout.NORTH);

        jPanelStatus.setLayout(new FlowLayout(FlowLayout.LEFT));

        jPanelStatus.setBorder(new EtchedBorder());
        jLabelStatus.setFont(new Font("Tahoma", 2, 10));
        jPanelStatus.add(jLabelStatus);

        add(jPanelStatus, BorderLayout.SOUTH);

    }


    private void jTable1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getButton() == evt.BUTTON3){
            mostraPopUpMenu(evt.getX(),evt.getY());
        }
    }

    private void setFiltro(ActionEvent e){
	if(this.filteredRowSet != null){
	    try{
		int idx = comboCampos.getSelectedIndex();
	        Predicate pre = new Containing(this.jTextFieldKeyWords.getText().trim(), new int[]{this.comboCampos.getSelectedIndex() + 1});
		this.filteredRowSet.setFilter( pre );
		this.setFilteredRowSet(filteredRowSet, new Integer(1));
		comboCampos.setSelectedIndex(idx);
	    } catch(Exception f){
		new EvilError(null, true, f);
	    }
	}
    }

    private void atualizaComboCampos(String[] campos){
	DefaultComboBoxModel  model = new DefaultComboBoxModel();
        for (int i = 0; i < campos.length; i++)  {
	    model.addElement(campos[i]);
        }
	this.comboCampos.setModel(model);

    }


    public void setAutoResizeMode(int state){
	this.jTable1.setAutoResizeMode(state);
    }
}
