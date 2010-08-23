package test.com.dudhoo.nemesis.hibernate;

import com.dudhoo.nemesis.hibernate.Usuario;
import com.dudhoo.nemesis.hibernate.UsuarioHome;

import junit.framework.TestCase;

import org.hibernate.ObjectDeletedException;
import org.hibernate.Transaction;

public class UsuarioHomeTest extends TestCase{
    UsuarioHome home = null;
    public UsuarioHomeTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	home = new UsuarioHome();
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see UsuarioHome#findById(Long)
     */
    public void testFindById(){
	Usuario user = home.findById(null, new Long(1));
	assertEquals("admin",user.getUsername());
	assertEquals(1,user.getId());
	assertNotNull(home.findByExample(user));
    }
    /**
     * @see UsuarioHome#saveOrUpdate(Long)
     */
    public void testsaveOrUpdate(){
	Usuario user = new Usuario();
	user.setUsername("testessUnit");
	user.setSenha("senhasss");
	user.setNome("atssssa");
	user.setGrupoUsuarioId(1);
	Transaction t = home.currentSession().beginTransaction();
	home.currentSession().saveOrUpdate(user);
	home.roolbackTransaction(t);
	home.closeSession(home.currentSession());
    }
    public void testFindLogin(){
        Usuario user = new Usuario();
        user.setUsername("admin");
        user.setSenha("admin");        
        assertNotNull(new UsuarioHome().findByLoginAndPass(user));
        assertEquals(new UsuarioHome().findByLoginAndPass(user).getSenha(),user.getSenha());
    }

    /**
     * @see UsuarioHome#delete(Usuario)
     */
    public void testDelete(){
	Usuario user = new Usuario();
	user.setUsername("testessUnit");
	user.setSenha("senhasss");
	user.setNome("atssssa");
	user.setId(1);
	Transaction t = home.currentSession().beginTransaction();
	home.currentSession().delete(user);
	try{
	    user = home.findById(home.currentSession(), new Long(1));
	    new AssertionError("Não pode deixar deletar o admin");
	}catch(ObjectDeletedException ex){
	    assertNotNull(ex);
	}
	home.roolbackTransaction(t);	
	home.closeSession(home.currentSession());
    }
}
