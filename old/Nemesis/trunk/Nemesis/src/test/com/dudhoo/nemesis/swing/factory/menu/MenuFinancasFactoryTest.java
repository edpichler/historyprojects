package test.com.dudhoo.nemesis.swing.factory.menu;

import com.dudhoo.nemesis.swing.factory.menu.MenuFinancasFactory;

import junit.framework.TestCase;

public class MenuFinancasFactoryTest extends TestCase{
    public MenuFinancasFactoryTest(String sTestName){
	super(sTestName);
    }

    protected void setUp() throws Exception{
	super.setUp();
    }

    protected void tearDown() throws Exception{
	super.tearDown();
    }

    /**
     * @see MenuFinancasFactory#getMenuFinanca()
     */
    public void testGetMenuFinanca(){
	new MenuFinancasFactory().getMenuFinanca();
    }
}
