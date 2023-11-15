import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Cited Source: https://www.youtube.com/watch?v=8wlE6DgOWBs
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
    	 String eOrigin = readFile(inputFilePath);
    	 char[] eCharacters = eOrigin.toCharArray();//Places read file into character array
    	 for(char c: eCharacters) {// loops through each character and shifts up to encrypt.
    		 c += shift;
    		 System.out.println(c);
    		 String str = String.valueOf(c);
    		 writeFile(str, encryptedFilePath);
    	 }
    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
    	String dOrigin = readFile(messageFilePath);
   	 	char[] dCharacters = dOrigin.toCharArray();//Places read file into character array
   	 	for(char c: dCharacters) {// loops through each character and shifts down to decrypt.
   	 		c -= shift;
   	 		System.out.print(c);
   	 		String str = String.valueOf(c);
   	 		writeFile(str, decryptedFilePath);
   	 	}
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
        String message = "";
        //TODO: Read file from filePath
        Scanner fileScanner = new Scanner(Paths.get(filePath));
        	while(fileScanner.hasNextLine()) {
        		message = fileScanner.nextLine();
        		System.out.println(message);
        	}
        	fileScanner.close();
        return message;
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     * @throws FileNotFoundException 
     */
    private static void writeFile(String data, String filePath) throws FileNotFoundException {
        //TODO: Write to filePath
    	PrintWriter output = new PrintWriter(filePath);
    		output.println(data);
    		output.close();
    }

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
