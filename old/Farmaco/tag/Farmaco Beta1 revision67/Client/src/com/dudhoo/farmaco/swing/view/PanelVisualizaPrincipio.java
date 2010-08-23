package com.dudhoo.farmaco.swing.view;

import com.dudhoo.evilframework.components.BotaoFechar24;
import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.dto.ContraIndicacao;
import com.dudhoo.farmaco.dto.CuidadosEspeciais;
import com.dudhoo.farmaco.dto.Indicacao;
import com.dudhoo.farmaco.dto.Interacao;
import com.dudhoo.farmaco.dto.Posologia;
import com.dudhoo.farmaco.dto.Precaucao;
import com.dudhoo.farmaco.dto.PrincipioAtivo;

import com.dudhoo.farmaco.dto.ReacaoAdversa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.FlowLayout;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyledDocument;
import java.util.Iterator;

import javax.swing.text.html.HTMLEditorKit;

public class PanelVisualizaPrincipio extends JPanel{

    private BorderLayout borderLayout1 = new BorderLayout();
    private PrincipioAtivo principio;
    private JScrollPane scrolable = new JScrollPane();
    private JTextPane textPane = new JTextPane();
    private JPanel jPanelBottom = new JPanel();
    private BotaoFechar24 botaoFechar241 = new BotaoFechar24();

    public PanelVisualizaPrincipio(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(702, 578));
	this.setLayout(borderLayout1);
	textPane.setEditable(false);
	textPane.setEditorKit(new HTMLEditorKit());

	scrolable.getViewport().add(textPane, null);
	this.add(scrolable, BorderLayout.CENTER);
	jPanelBottom.add(botaoFechar241, null);
	this.add(jPanelBottom, BorderLayout.SOUTH);
	jPanelBottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
	botaoFechar241.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoFechar241_actionPerformed(e);
		    }
		});
    }

    public void setPrincipio(PrincipioAtivo _principio){
	this.principio = _principio;
	if(this.principio != null){
	    StringBuffer buf = new StringBuffer("");
	    buf.append(getInitHtml());
	    buf = putNome(buf, principio.getNome());
	    buf = putDescricao(buf, principio.getDescricao());
	    buf = putIndicacao(buf, principio.getIndicacao());
	    buf = putInteracoes(buf, principio.getInteracao());
	    buf = putPrecaucao(buf, principio.getPrecaucao());
	    buf = putRecoesAdv(buf, principio.getReacaoAdversa());
	    buf = putContraIndicacao(buf, principio.getContraIndicacao());
	    buf = putCuidadosEsp(buf, principio.getCuidadosEspec());
	    Set <ApresentacaoFarmaceutica > set = principio.getApresentacaoFarmaceutica();
	    buf = putCuidadosEsp(buf, set);
	    buf.append(getFimHtml());

	    textPane.setText(buf.toString());
	}else{
	    textPane.setText(null);
	}
    }

    public PrincipioAtivo getPrincipio(){
	return principio;
    }

    private void botaoFechar241_actionPerformed(ActionEvent e){
	this.getParent().remove(this);
    }

    private StringBuffer putNome(StringBuffer buf, String nome ){
	return buf.append("<h1 class='stylePrincipio'>" + nome + "</h1>");
    }

    private StringBuffer putDescricao(StringBuffer buf, String descri){
	return buf.append(descri);
    }

    private StringBuffer putIndicacao(StringBuffer buf, Indicacao ind){
	if(ind != null && ind.getDescricao().length() > 1){
	    String      title = "Indicação";
	    String      indicacao = ind.getDescricao();
	    putH2(buf, title, indicacao, null);
	}
	return buf;
    }

    private StringBuffer putInteracoes(StringBuffer buf, Interacao in){
	if(in!= null && in.getDescricao().length() > 1){
	    String      title = "Interações";
	    String      desc = in.getDescricao();
	    putH2(buf,title, desc, null);
	}
	return buf;
    }

    private StringBuffer putPrecaucao(StringBuffer buf, Precaucao in){
	if(in!= null && in.getDescricao().length() > 1){
	    String      title = "Precauções";
	    String      desc = in.getDescricao();
	    putH2(buf,title, desc, null);
	}
	return buf;
    }

    private StringBuffer putRecoesAdv(StringBuffer buf, ReacaoAdversa in){
	if(in!= null && in.getDescricao().length() > 1){
	    String      title = "Reações adversas";
	    String      desc = in.getDescricao();
	    putH2(buf,title, desc, null);
	}
	return buf;
    }

    private StringBuffer putContraIndicacao(StringBuffer buf,
					    ContraIndicacao in){
	if(in!= null && in.getDescricao().length() > 1){
	    String      title = "Contra-indicações";
	    String      desc = in.getDescricao();
	    putH2(buf,title, desc, null);
	}
	return buf;
    }

    private StringBuffer putCuidadosEsp(StringBuffer buf, CuidadosEspeciais in){
	if(in!= null && in.getDescricao().length() > 1){
	    String      title = "Cuidados especiais";
	    String      desc = in.getDescricao();
	    putH2(buf,title, desc, null);
	}
	return buf;
    }

    private StringBuffer putCuidadosEsp(StringBuffer buf,
					Set<ApresentacaoFarmaceutica> set){

	if(set != null && set.size() > 0){
	    String   title = "Apresentações farmacêuticas";
	    putH2(buf,title,"", "stylePrincipio");
	    for(Iterator iterator = set.iterator();iterator.hasNext();) {
		ApresentacaoFarmaceutica apreFar = (ApresentacaoFarmaceutica) iterator.next();
	        Posologia poso = apreFar.getPosologia();		
		String apNome = null;
		String posNome = null;
		if(apreFar != null){
		    apNome = apreFar.getDescricao(); 
		}else{
		    apNome = "";
		}	        
	        if(poso != null){
	            posNome = "<i>Posologia:</i> " + poso.getDescricao(); 
	        }else{
	            posNome = "";
	        }	        
		putH3(buf,apNome , posNome);		
	    }
	}
	return buf;
    }

    private String getInitHtml(){
	return "<html>\n" +
	"<head>\n" +
	"<title>Untitled Document</title>\n" +
	"<style type=\"text/css\">\n" +
	"<!--\n" +
	"body,td,th {\n" +
	"       font-family: Trebuchet MS;\n" +
	"}\n" +
	".stylePrincipio {color: #B31E00}\n" +
	"-->\n" +
	"</style></head>\n" +
	"<body>\n";
    }

    private String getFimHtml(){
	return "</body></html>";
    }

    private void putH2(StringBuffer buf, String title, String text, String styleClass){
	if(styleClass!= null && styleClass.length() > 0){
	    buf.append("<h2 class='" + styleClass + "'>" + title + "</h2>" + text.replace("\n","<br>"));
	}else{
	    buf.append("<h2>" + title + "</h2>" + text.replace("\n","<br>"));
	}   
    }
    private void putH3(StringBuffer buf, String title, String text){
	buf.append("<h3>" + title + "</h3>" + text.replace("\n","<br>"));
    }
}
