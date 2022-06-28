

import java.util.Scanner;

public class PasswordGenerator {

    /**
     * Special characters
     *
     * @return Returns n array of chars containing all valid special characters
     */
    public static char[] getSpecialCharacters() {
        return new char[]{'!', '@', '#', '_', '.', '*'};
    }

    /**
     * Valid password characters
     *
     * @return Returns String containing all valid password characters
     */
    public static final String getValidPasswordCharacters() { // I kept signature as is for grade, but removed the redundant assignment
        return "abcdefghijklmnopqrstuvwyxzABCDEFGHIJKLMNOPQRSTUVEWXYZ0123456789";
    }

    /**
     * @return Returns a single String of 140 four-letter words than can be used in a password.
     *
     */
    public static final String getAllFourLetterWords() { // I kept signature as is for grade, but removed the redundant assignment
        return "able bane barn bile blip boat bolt bran brat brim bulb "+
                "bull burn cane card cart clan clip cold cone core dart "+
                "deny dial dang dirk dolt door dote drip drop dupe each "+
                "earn easy fast fest file five flap flip flop foal folk "+
                "fort four full gave give gone grin hard hurt idle isle "+
                "join king knit knob land lane lard link list live long "+
                "lung made main many mile mine moat mole mote mule nine "+
                "norm note paid part pick pile ping pipe plan pole pong "+
                "port prim pull quid quip quit rain rang redo ring ripe "+
                "role root rote rung sand sang silk sing sink slam slow "+
                "song sort spam sulk take tame tang tide tile time tint "+
                "toll tone took tote trap trip turn undo vile volt vote "+
                "wart wing woke wool wore writ zero zoom";
    }



    /**
     * Create a password
     *
     * @return Returns a password meeting all of the specifications
     */
    public static String createPassword() {

        // Originally 'password' was a string I changed it to StringBuilder and back
        // to string since it wasn't covered in class yet but intellij suggested it later on
        // so, I kept the change.
        StringBuilder password = new StringBuilder();
        String[] validWord = getAllFourLetterWords().split(" "); // generate variables to append
        char[] validSpecial = getSpecialCharacters();
        String validChars = getValidPasswordCharacters();

        password.append(validWord[(int) (Math.random() * validWord.length)]); // select a random int from the array using length as max
        password.append(validSpecial[(int) (Math.random() * validSpecial.length)]); // same as above
        password.append(String.format("%02d", (int) (Math.random() * 100))); // format an integer to be 2 fixed length digits
        for(int i = 0; i < 5; i++)
            password.append(validChars.charAt((int) (Math.random() * validChars.length()))); // there's definitely a better way of doing this, but I don't know it
        return password.toString();
    }

    /**
     * @return true if this password is unique to the list of generated passwords.
     */

    public static boolean isUniquePassword(String aPassword, String passwordList) {
        return !passwordList.contains(aPassword); // check passwordList with string contains method, had to change to ! to fit method with return
    }

    /**
     * Add aPassword to the list of unique passwords
     *
     * @param aPassword: the password to add
     * @param passwordList: A string containing all unique passwords, separated by spaces
     * @return Updated passwordList with the new password
     */
    public static String addUniquePassword(String aPassword, String passwordList) {

        while(!isUniquePassword(aPassword, passwordList)) // repeat creating passwords if one isn't unique
            aPassword = createPassword();
        return aPassword + ","; // generate list as csv to be split later

    }

    /**
     * @author David Badcoe
     * @date 2021/10/17 23:33
     * */
    // Included above because pretty much every other method had one, don't think that's what this doc is meant for though.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many passwords do you want to generate? ");
        int numPasswords = scanner.nextInt();
        scanner.close();
        String uniquePasswords = "";

        for(int i = 0; i < numPasswords; i++){
            uniquePasswords += addUniquePassword(createPassword(), uniquePasswords); // create a password and pass it through as the argument
        }
        int count = 0;
        for(String s : uniquePasswords.split(",")) // split csv and do a foreach over generated array
            System.out.printf("%3d: %s\n", ++count, s); // print elements out with format and count, this way seems cleaner to me than doing a for loop

        // I spent a lot of extra time making my code more readable and checking the intellij suggestions to see if there were cleaner ways of doing things
    }
}
