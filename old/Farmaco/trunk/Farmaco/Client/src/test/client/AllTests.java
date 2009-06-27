package test.client;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.swingui.TestRunner;

import test.com.dudhoo.farmaco.hibernate.ApresentacaoFarmaceuticaHomeTest;
import test.com.dudhoo.farmaco.hibernate.NomeComercialHomeTest;
import test.com.dudhoo.farmaco.hibernate.PrincipioAtivoHomeTest;
import test.com.dudhoo.farmaco.hibernate.root.HibernateRootTest;
import test.com.dudhoo.farmaco.install.DatabaseInitializerTest;

public class AllTests {
    public static Test suite() {
        TestSuite suite;
        suite = new TestSuite("AllTests");
        suite.addTestSuite(HibernateRootTest.class);
        suite.addTestSuite(DatabaseInitializerTest.class);
        suite.addTestSuite(PrincipioAtivoHomeTest.class);
        suite.addTestSuite(NomeComercialHomeTest.class);
        suite.addTestSuite(ApresentacaoFarmaceuticaHomeTest.class);
        return suite;
    }

    public static void main(String args[]) {
        String args2[] = {"-noloading", "test.client.AllTests"};
        TestRunner.main(args2);
    }
}