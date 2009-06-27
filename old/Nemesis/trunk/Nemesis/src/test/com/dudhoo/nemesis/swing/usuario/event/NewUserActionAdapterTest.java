package test.com.dudhoo.nemesis.swing.usuario.event;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.GrupoUsuario;
import com.dudhoo.nemesis.swing.usuario.JPanelAdminUsuarios;
import com.dudhoo.nemesis.swing.usuario.event.NewUserActionAdapter;

import javax.swing.JList;

import junit.framework.TestCase;

public class NewUserActionAdapterTest extends TestCase{
    public NewUserActionAdapterTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see NewUserActionAdapter#actionPerformed(ActionEvent)
     */
    public void testCreate(){
	NewUserActionAdapter ata;
	ata = new NewUserActionAdapter(new JPanelAdminUsuarios());
    }
}
