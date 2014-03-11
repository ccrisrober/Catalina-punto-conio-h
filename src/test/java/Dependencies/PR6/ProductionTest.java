/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dependencies.PR6;

import Dependencies.PR1.Symbols.V;
import Dependencies.PR1.Symbols.VN;
import Dependencies.PR1.Symbols.VT;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Cristian
 */
public class ProductionTest extends TestCase {
    
    public ProductionTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getAntecedente method, of class Production.
     */
    public void testGetAntecedente() {
        System.out.println("getAntecedente");
        List<V> l = new LinkedList<V>();
        l.add(new VN("B"));
        l.add(new VT("c"));
        Production instance = new Production(new VN("A"), l);
        VN expResult = new VN("A");
        VN result = instance.getAntecedente();
        assertEquals(expResult, result);
    }

    /**
     * Test of getConsecuente method, of class Production.
     */
    public void testGetConsecuente() {
        System.out.println("getConsecuente");
        List<V> l = new LinkedList<V>();
        l.add(new VN("B"));
        l.add(new VT("c"));
        Production instance = new Production(new VN("A"), l);
        List<V> expResult = l;
        List<V> result = instance.getConsecuente();
        assertEquals(expResult, result);
    }
}
