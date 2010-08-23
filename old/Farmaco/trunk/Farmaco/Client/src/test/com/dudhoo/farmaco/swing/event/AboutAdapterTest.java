package test.com.dudhoo.farmaco.swing.event;

import com.dudhoo.evilframework.swing.JDialogAbout;
import com.dudhoo.farmaco.swing.event.AboutAdapter;

import junit.framework.TestCase;

public class AboutAdapterTest extends TestCase {
    public AboutAdapterTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see AboutAdapter#getPanel()
     */
    public void testGetPanel() {
        JDialogAbout a = new JDialogAbout(null, false) ;
        a.setAboutListener(new AboutAdapter()); 
        a.setVisible(true);
        assertNotNull( new AboutAdapter().getPanel());
    }

    /**
     * @see AboutAdapter#getTabName()
     */
    public void testGetTabName() {
    }
}
