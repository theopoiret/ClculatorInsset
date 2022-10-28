/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

/**
 *
 * @author insset
 */
public class DateUtils {
    
    public static int[] convertDateStringToIntArray(String dateStr) throws IllegalArgumentException {
        
        String[] date = dateStr.split("/");

        if ( date.length != 3 )
            throw new IllegalArgumentException("Invalid date format");

        int[] result = new int[]{0, 0, 0};

        for (int dateIndex = 0; dateIndex < date.length; dateIndex++)
            result[dateIndex] = Integer.parseInt(date[dateIndex]);

        return result;
    }
    
}
