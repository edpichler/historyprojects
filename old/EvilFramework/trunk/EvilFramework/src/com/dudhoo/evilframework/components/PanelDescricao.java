package com.dudhoo.evilframework.components;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelDescricao extends JScrollPane{
    private JTextArea jTextArea1 = new JTextArea();

    public PanelDescricao() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getViewport().add(jTextArea1, null);
    }
    
    public String getText(){
        return this.jTextArea1.getText();
    }
    
    public void setText(String text){
        this.jTextArea1.setText(text);
    }
}

