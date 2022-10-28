/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

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
public class RomanConverterServiceImplTest {
    
    public RomanConverterServiceImplTest() {
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
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDateYears() {
        //given
        String date = "15/02/2000";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "XV/II/MM";
        //when
        String result = instance.convertDateYears(date);
        //then
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of convertRomanToArabe method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertRomanToArabe() {
        //given
        String romanNumber = "XX";
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        Integer expResult = 20;
        //when
        Integer result = instance.convertRomanToArabe(romanNumber);
        //then
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of processDecimal method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testProcessDecimal() {
        //given
        int decimal = 2;
        int lastNumber = 5;
        int lastDecimal = 8;
        int expResult = 6;
        //when
        int result = RomanConverterServiceImpl.processDecimal(decimal, lastNumber, lastDecimal);
        //then
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
/**
     * Test of processDecimal method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testProcessDecimal2() {
        //given
        int decimal = 8;
        int lastNumber = 5;
        int lastDecimal = 10;
        int expResult = 18;
        //when
        int result = RomanConverterServiceImpl.processDecimal(decimal, lastNumber, lastDecimal);
        //then
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of convertArabeToRoman method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertArabeToRoman() {
        //given
        Integer nbr = 5;
        RomanConverterServiceImpl instance = new RomanConverterServiceImpl();
        String expResult = "V";
        //when
        String result = instance.convertArabeToRoman(nbr);
        //then
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
