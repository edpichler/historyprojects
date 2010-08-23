package test.com.dudhoo.farmaco.swing.pAtivo;

import com.dudhoo.farmaco.hibernate.PrincipioAtivo;
import com.dudhoo.farmaco.hibernate.PrincipioAtivoHome;
import com.dudhoo.farmaco.swing.pAtivo.JPanelPrincipioAtivoViewer;

import java.sql.SQLException;

import javax.swing.JDialog;

import junit.framework.TestCase;

public class JPanelPrincipioAtivoViewerTest extends TestCase {
    public JPanelPrincipioAtivoViewerTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see JPanelPrincipioAtivoViewer#setPrincipio(PrincipioAtivo)
     */
    public void testSetPrincipio() throws SQLException {
        JDialog dia = new JDialog();
        PrincipioAtivo a = (PrincipioAtivo)new PrincipioAtivoHome().findAll(2).get(0);
        JPanelPrincipioAtivoViewer view =  new JPanelPrincipioAtivoViewer();    
        view.setPrincipio(a);
        dia.getContentPane().add(view);
        dia.setModal(true);
        dia.setVisible(true);
    }
}
