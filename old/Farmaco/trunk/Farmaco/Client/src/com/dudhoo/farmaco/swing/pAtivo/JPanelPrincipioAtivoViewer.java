package com.dudhoo.farmaco.swing.pAtivo;

import com.dudhoo.farmaco.hibernate.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.hibernate.NomeComercial;
import com.dudhoo.farmaco.hibernate.PrincipioAtivo;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.util.Iterator;

public class JPanelPrincipioAtivoViewer extends JScrollPane{
    private PrincipioAtivo principio = null;
    private JLabel jLabel1 = new JLabel();
    

    public JPanelPrincipioAtivoViewer() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(589, 427));
        jLabel1.setVerticalAlignment(SwingConstants.TOP);

        jLabel1.setFont(new Font("Dialog", 0, 11));
        this.getViewport().add(jLabel1, null);
    
    }

    public void setPrincipio(PrincipioAtivo principio) {
        int minimo = 1;
        this.principio = principio;
        if(this.principio != null){
            StringBuffer buf = new StringBuffer();
            buf.append("<html>");
            buf.append("<h1>" + principio.getNome() + "</h1>");            
            buf.append("" + principio.getDescricao()
            .replace("\n","<br>") + (principio.getDescricao()
            .length() > minimo ? "." : "") );            
            
            if(principio.getApresentacoesFarmaceuticas() != null 
            && principio.getApresentacoesFarmaceuticas().size() > 0){
                buf.append("<h2>Apresentações Farmacêuticas</h2>");
                for(Iterator iterator = principio.getApresentacoesFarmaceuticas().iterator(); iterator.hasNext();) {
                    ApresentacaoFarmaceutica appFar = (ApresentacaoFarmaceutica) iterator.next();
                    buf.append("<b>- " + appFar.getNome() + "</b>. <i>Posologia:</i> " + appFar.getPosologia() + " <br> ");
                }
            }
            
            if(principio.getContraIndicacoes() != null
            && principio.getReacoesAdversas().length() > minimo){
                buf.append("<h2>Contra-indicações</h2>");
                buf.append("" + principio.getContraIndicacoes()
                .replace("\n","<br>") + ".");
            }
            
            if(principio.getCuidadosEspeciais() != null 
            && principio.getReacoesAdversas().length() > minimo){
                buf.append("<h2>Cuidados especiais</h2>");
                buf.append("" + principio.getCuidadosEspeciais()
                .replace("\n","<br>") + ".");
            }
            if(principio.getIndicacoes() != null 
            && principio.getReacoesAdversas().length() > minimo){
                buf.append("<h2>Indicações</h2>");
                buf.append("" + principio.getIndicacoes()
                .replace("\n","<br>") + ".");
            }
            if(principio.getInteracoes() != null 
            && principio.getReacoesAdversas().length() > minimo){
                buf.append("<h2>Interações</h2>");
                buf.append("" + principio.getInteracoes()
                .replace("\n","<br>") + ".");
            }
            
            if(principio.getPrecaucoes() != null 
            && principio.getReacoesAdversas().length() > minimo){
                buf.append("<h2>Precausões</h2>");
                buf.append("" + principio.getPrecaucoes()
                .replace("\n","<br>") + ".");
            }
            if(principio.getReacoesAdversas() != null 
                && principio.getReacoesAdversas().length() > minimo){
                buf.append("<h2>Reações adversas</h2>");
                buf.append("" + principio.getReacoesAdversas()
                .replace("\n","<br>") + ".");
            }
            if(principio.getNomesComerciais() != null 
            && principio.getNomesComerciais().size() > 0){
                buf.append("<h2>Nomes Comerciais</h2>");
                for(Iterator iterator = principio.getNomesComerciais().iterator();iterator.hasNext();) {
                    NomeComercial nomeComercial = (NomeComercial) iterator.next();
                    buf.append(" - " + nomeComercial.getNome() + "<br>");
                }
            }
            
            
                        
            buf.append("</html>");
            this.jLabel1.setText(buf.toString());
        }else{
            this.jLabel1.setText(null);
        }
    }

    public PrincipioAtivo getPrincipio() {
        return principio;
    }
}
