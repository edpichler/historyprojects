package test.com.dudhoo.nemesis.swing.usuario;

import com.dudhoo.nemesis.swing.usuario.JPanelAdminUsuarios;

import junit.framework.TestCase;

public class JPanelAdminUsuariosTest extends TestCase{
    public JPanelAdminUsuariosTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();

    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    public void testaCriar(){
	assertNotNull(new JPanelAdminUsuarios());
    }
}
