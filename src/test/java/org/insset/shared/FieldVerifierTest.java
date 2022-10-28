/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author insset
 */
public class FieldVerifierTest {
    
    public FieldVerifierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of isValidName method, of class FieldVerifier.
     */
    @Test
    public void testIsValidName() {
        //given
        String name = "theo";
        boolean expResult = true;
        //when
        boolean result = FieldVerifier.isValidName(name);
        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of isInValidName method, of class FieldVerifier.
     */
    @Test
    public void testIsInValidName() {
        //given
        String name = "";
        boolean expResult = false;
        //when
        boolean result = FieldVerifier.isValidName(name);
        //then
        assertEquals(expResult, result);
    }
/**
     * Test of isValidDecimal method, of class FieldVerifier.
     */
    @Test
    public void testIsValidDecimal() {
        //given
        int nbr = 5;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = true;

        //when
        boolean result = instance.isValidDecimal(nbr);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of isInValidDecimal method, of class FieldVerifier.
     */
    @Test
    public void testIsInValidDecimal() {
        //given
        double nbr = 5.8;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidDecimal(nbr);

        //then
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsValidRoman() {
        //given
        String nbr = "XXM";
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = true;

        //when
        boolean result = instance.isValidRoman(nbr);

        //then
        assertEquals(expResult, result);
    }
/**
     * Test of isInValidRoman method, of class FieldVerifier.
     */
    @Test
    public void testIsInValidRoman() {
        //given
        String nbr = "XAXM";
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidRoman(nbr);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of isValidDate method, of class FieldVerifier.
     */
    @Test
    public void testIsValidDate() {
         //given
        String date = "22/06/2022";
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = true;

        //when
        boolean result = instance.isValidDate(date);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of isInValidDate method, of class FieldVerifier.
     */
    @Test
    public void testIsInValidDate() {
         //given
        String date = "45/125/2022";
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidDate(date);

        //then
        assertEquals(expResult, result);
    }
}
