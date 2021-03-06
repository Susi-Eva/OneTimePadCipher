package OneTimePad;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author Susi Purba
 */
public class OneTimePadCipher {
     
     public static String setNewKey(String s){
        int len = s.length();
        String x = "";
        int index = 0;
        
        for (int i = len-1 ; i >= 0; i--){
            char c = s.charAt(i);
            int j = (int) c;
            if(j % 2 == 0){
                x += s.charAt(i);
                index++;
            }
        }
        return x;
        
    }
    
    
    public static String setNewPlainText(String s){
        int len = s.length();
        String x = "";
        int index = 0;
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            int j = (int) c;
            if(j % 2 == 1){
                x += s.charAt(i);
                index++;
            }
        }
        return x;
    }
    
     
     public static String encryptionMessage(String s)
    {
        int i, j;
        int randomBitPattern[] = new int[8];
        for (i = 0; i < 7; i++)
        {
            randomBitPattern[i] = (i % 2 == 0) ? 1 : 0;
        }
        char asc[] = new char[s.length()];
        for (i = 0; i < s.length(); i++)
        {
            asc[i] = (char) ((int) s.charAt(i));
        }
        BasicOperation b1 = new BasicOperation();
        String cipherText = new String("");
        for (i = 0; i < asc.length; i++)
        {
            int temp = (int) (asc[i]);
            int len = b1.decimalToBinary(temp);
            int bintemp[] = new int[7];
            int xorlen;
            if (len == 7)
            {
                for (j = 1; j <= len; j++)
                {
                    bintemp[j - 1] = b1.binaryArrayAtPosition(j);
                }
                // XOR Operation
                xorlen = b1.xorop(bintemp, randomBitPattern, len);
            }
            else
            {
                // System.out.println("\n less than 7 :"+len);
                bintemp[0] = 0;
                for (j = 1; j <= len; j++)
                {
                    bintemp[j] = b1.binaryArrayAtPosition(j);
                }
                // XOR Operation
                xorlen = b1.xorop(bintemp, randomBitPattern, len + 1);
            }
            int xor[] = new int[xorlen];
            for (j = 0; j < xorlen; j++)
            {
                xor[j] = b1.xorinArrayAt(j);
                cipherText = cipherText + xor[j];
            }
            cipherText += " ";
        }
        return (cipherText);
    }
 
    public static String decryptionMessage(String s)
    {
        int i, j;
        // char cipherChar[]=new char[(s.length()/2)];
        char cipherChar[] = new char[(s.length())];
        int cnt = -1;
        for (i = 0; i < s.length(); i++)
        {
            // we receive only Ascii of it is allow 0 and 1, do not accept white
            // space
            // int ascii=(int)s.charAt(i);
            if ((int) s.charAt(i) == 48 || (int) s.charAt(i) == 49
                    || (int) s.charAt(i) == 32)
            {
                cnt++;
                cipherChar[cnt] = s.charAt(i);
            }
        }
        String s1 = new String(cipherChar);
        String s2[] = s1.split(" ");
        int data[] = new int[s2.length];
        for (i = 0; i < s2.length; i++)
        {
            data[i] = Integer.parseInt(s2[i]);
        }
        char randomBitPattern[] = new char[7];
        for (i = 0; i < 7; i++)
        {
            randomBitPattern[i] = (i % 2 == 0) ? '1' : '0';
        }
        BasicOperation b1 = new BasicOperation();
        String plain = new String("");
        // do the XOR Operation
        for (i = 0; i < s2.length; i++)
        {
            int xorlen = b1.xorop(s2[i], randomBitPattern);
            int xor[] = new int[xorlen];
            for (j = 0; j < xorlen; j++)
            {
                xor[j] = b1.xorinArrayAt(j);
                plain += xor[j];
            }
            plain += " ";
        }
        String p[] = plain.split(" ");
        BasicOperation ob = new BasicOperation();
        int decryptedChar[] = new int[p.length];
        char plainTextChar[] = new char[p.length];
        for (i = 0; i < p.length; i++)
        {
            decryptedChar[i] = ob.binaryToDecimal(Integer.parseInt(p[i]));
            plainTextChar[i] = (char) decryptedChar[i];
        }
        return (new String(plainTextChar));
    }
 
}
 
