package test.com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.MenuRelatoriosFactory;

import javax.swing.JMenu;

import junit.framework.TestCase;

public class MenuRelatoriosFactoryTest extends TestCase{
    public MenuRelatoriosFactoryTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see MenuRelatoriosFactory#getMenuRelatorios()
     */
    public void testGetMenuRelatorios(){
	JMenu menu;
	menu = new MenuRelatoriosFactory().getMenuRelatorios();
	assertNotNull(menu);
    }
}
