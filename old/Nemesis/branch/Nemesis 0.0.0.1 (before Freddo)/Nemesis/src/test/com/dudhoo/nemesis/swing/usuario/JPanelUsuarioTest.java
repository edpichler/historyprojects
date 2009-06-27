package test.com.dudhoo.nemesis.swing.usuario;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.Usuario;
import com.dudhoo.nemesis.swing.usuario.JPanelUsuario;

import junit.framework.TestCase;

public class JPanelUsuarioTest extends TestCase{
    JPanelUsuario a = null;

    public JPanelUsuarioTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
	a = new JPanelUsuario();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see JPanelUsuario#setUser(Usuario)
     */
    public void testSetUser() throws ValidationException{
	a.setUser(null);
	assertNotNull(a.getUser());
    }

    /**
     * @see JPanelUsuario#getUser()
     */
    public void testGetUser() throws ValidationException{
	Usuario u = a.getUser();
	a.setUser(u);
	assertSame(u, a.getUser());
    }
}
