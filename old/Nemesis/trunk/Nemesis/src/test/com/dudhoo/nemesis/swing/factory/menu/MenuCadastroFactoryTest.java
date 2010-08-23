package test.com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.MenuCadastroFactory;

import junit.framework.TestCase;

public class MenuCadastroFactoryTest extends TestCase{
    public MenuCadastroFactoryTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see MenuCadastroFactory#constroiMenuCadastros()
     */
    public void testConstroiMenuCadastros(){
	new MenuCadastroFactory().constroiMenuCadastros();
    }
}
