package AlphabetCipher;

/* "The Alphabet Cipher", published by Lewis Carroll in 1868, describes a Vigenère cipher (thanks /u/Yadkee for the clarification)
    for passing secret messages. The cipher involves alphabet substitution using a shared keyword.
    Using the alphabet cipher to tranmit messages follows this procedure:

    You must make a substitution chart like this, where each row of the alphabet is rotated by one as each letter goes down the chart.
    All test cases will utilize this same substitution chart.

    INPUTS:

    bond theredfoxtrotsquietlyatmidnight
    train murderontheorientexpress
    garden themolessnuckintothegardenlastnight

    OUTPUTS:

    uvrufrsryherugdxjsgozogpjralhvg
    flrlrkfnbuxfrqrgkefckvsa
    zhvpsyksjqypqiewsgnexdvqkncdwgtixkx
*/

import java.util.HashMap;
import java.util.Map;

public class AlphabetCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        Map<String, String> alphabetChiper = new HashMap<>();

        for(int i = 0; i < ALPHABET.length() - 1; i++) {
            String key = String.valueOf(ALPHABET.charAt(i)).toUpperCase();
            String value = ALPHABET.substring(i, ALPHABET.length()).concat(ALPHABET.substring(0, i));

            alphabetChiper.put(key, value);
        }

        String message = "themolessnuckintothegardenlastnight";
        String encryptedMessage = "";

        String keyword = "garden";
        int keywordLenght = keyword.length() - 1;
        int keywordI = 0;

        for(int i = 0; i < message.length(); i++) {
            if(keywordI > keywordLenght) keywordI = 0;
            String messageValue = String.valueOf(message.charAt(i)).toUpperCase();
            int keywordIndex = ALPHABET.indexOf(keyword.charAt(keywordI));

            String aChiper = alphabetChiper.get(messageValue);

            encryptedMessage = encryptedMessage.concat(String.valueOf(aChiper.charAt(keywordIndex)));

            keywordI++;
        }

        System.out.println(encryptedMessage);
    }
}
