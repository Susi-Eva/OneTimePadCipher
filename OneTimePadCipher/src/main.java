/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OneTimePad;

import static OneTimePad.OneTimePadCipher.decryptionMessage;
import static OneTimePad.OneTimePadCipher.encryptionMessage;
import static OneTimePad.OneTimePadCipher.setNewKey;
import static OneTimePad.OneTimePadCipher.setNewPlainText;
import java.util.Scanner;


/**
 *
 * @author Susi Purba
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message (Plain text): ");
        String message = sc.next();
        System.out.println("Set new Plaintext: "+setNewPlainText(message));
        String a = setNewPlainText(message);
        String b = setNewKey(message);
        System.out.println("Set Key: "+setNewKey(message));
        System.out.println("'" + message + "' in encrypted message : "
                + encryptionMessage(a));
        System.out.println("'" + encryptionMessage(a)
                + "' in decrypted message : "
                + decryptionMessage(encryptionMessage(a)));
        sc.close();
    }
}
    
