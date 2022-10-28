package org.insset.shared;


import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DefaultDateTimeFormatInfo;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

    /**
     * Verifies that the specified name is valid for our service.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty())) {
            return false;
        }
        return true;
    }

    /**
     * Verifies that the specified value is valide.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidDecimal(double nbr) {
        //Implement your code
        int i;
        i= (int)nbr;
        
        if(i==nbr)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isValidRoman(String nbr) {
        //Implement your code
        nbr=nbr.toUpperCase();
        char i='I',v='V',x='X',l='L',c='C',d='D',m='M';

        for(int j=0;j<nbr.length();j++)
        {
            if(!((nbr.charAt(j)==i)||(nbr.charAt(j)==v)||(nbr.charAt(j)==x)||
            (nbr.charAt(j)==l)||(nbr.charAt(j)==c)||(nbr.charAt(j)==d)||
            (nbr.charAt(j)==m)))
            {
               return false;
            }

        }
                return true; 
        
    }
    
    public static boolean isValidEnteredPrice( int price ) {
        return price >= 0 && price <= 10000;
    }

    public static boolean isValidPercentage( int percentage ) {
        return percentage > 0 && percentage <= 100;
    }
    
    public static boolean isValidDivisionOperands(int dividend, int diviser) {
        return dividend >= 0 && dividend <= 10000 & diviser > 0 && diviser <= 10000;
    }
    public static boolean isValidDate(String date) {
        String[] items= date.split("/");

        if(items[0].length() <= 2 && items[0].length() > 0 && Integer.parseInt(items[0]) <= 31 ) {
            if(items[1].length() <= 2 && items[1].length() > 0 && Integer.parseInt(items[1]) <= 12 ){
                if(items[2].length() == 4 ){
                    return true;
                }
            }
        }

        return false;

    }

}
