package test.com.dudhoo.farmaco.install;

import com.dudhoo.farmaco.install.DatabaseInitializer;

import java.sql.SQLException;

import junit.framework.TestCase;

public class DatabaseInitializerTest extends TestCase {
    public DatabaseInitializerTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * @see DatabaseInitializer#alreadyExists()
     */
    public void testAlreadyExists() throws SQLException {
        DatabaseInitializer db = new DatabaseInitializer();
        if(db.alreadyExists() == false){
            db.create();
        }
        assertTrue(db.alreadyExists());
    }
}