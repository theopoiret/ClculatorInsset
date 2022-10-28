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
    /**
     * Test of testisValidEnteredPrice method, of class FieldVerifier.
     */
    @Test
    public void testisValidEnteredPrice() {
         //given
        int price = 78;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = true;

        //when
        boolean result = instance.isValidEnteredPrice(price);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidEnteredPrice method, of class FieldVerifier.
     */
    @Test
    public void testisValidEnteredPriceFalse() {
         //given
        int price = -5;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidEnteredPrice(price);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidEnteredPrice method, of class FieldVerifier.
     */
    @Test
    public void testisValidEnteredPriceFalse2() {
         //given
        int price = 100000;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidEnteredPrice(price);

        //then
        assertEquals(expResult, result);
    }
    
    /**
     * Test of testisValidPercentage method, of class FieldVerifier.
     */
    @Test
    public void testisValidPercentage() {
         //given
        int price = 78;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = true;

        //when
        boolean result = instance.isValidPercentage(price);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidEnteredPrice method, of class FieldVerifier.
     */
    @Test
    public void testisValidPercentageFalse() {
         //given
        int price = -5;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidPercentage(price);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidEnteredPrice method, of class FieldVerifier.
     */
    @Test
    public void testisValidPercentageFalse2() {
         //given
        int price = 500;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidPercentage(price);

        //then
        assertEquals(expResult, result);
    }
    
    /**
     * 
    public static boolean isValidDivisionOperands(int dividend, int diviser) {
        return dividend >= 0 && dividend <= 10000 & diviser > 0 && diviser <= 10000;
    }
     */
    /**
     * Test of testisValidDivisionOperands method, of class FieldVerifier.
     */
    @Test
    public void testisValidDivisionOperands() {
         //given
        int diviser = 500;
        int dividend = 500;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = true;

        //when
        boolean result = instance.isValidDivisionOperands(dividend,diviser);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidDivisionOperands method, of class FieldVerifier.
     */
    @Test
    public void testisValidDivisionOperandsFalse() {
         //given
        int diviser = -5;
        int dividend = 500;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidDivisionOperands(dividend,diviser);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidDivisionOperands method, of class FieldVerifier.
     */
    @Test
    public void testisValidDivisionOperandsFalse2() {
         //given
        int diviser = 50000;
        int dividend = 500;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidDivisionOperands(dividend,diviser);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidDivisionOperands method, of class FieldVerifier.
     */
    @Test
    public void testisValidDivisionOperandsFalse3() {
         //given
        int diviser = 500;
        int dividend = -5;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidDivisionOperands(dividend,diviser);

        //then
        assertEquals(expResult, result);
    }
    /**
     * Test of testisValidEnteredPrice method, of class FieldVerifier.
     */
    @Test
    public void testisValidDivisionOperandsFalse4() {
         //given
        int diviser = 500;
        int dividend = 50000;
        FieldVerifier instance = new FieldVerifier();
        boolean expResult = false;

        //when
        boolean result = instance.isValidDivisionOperands(dividend,diviser);

        //then
        assertEquals(expResult, result);
    }
}
