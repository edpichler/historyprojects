package test.com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.MenuSegurancaFactory;

import junit.framework.TestCase;

public class MenuSegurancaFactoryTest extends TestCase{
    public MenuSegurancaFactoryTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see MenuSegurancaFactory#getMenuSeguranca()
     */
    public void testGetMenuSeguranca(){
	new MenuSegurancaFactory().getMenuSeguranca();
    }
}
