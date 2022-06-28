import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab09b {
    public static void main(String[] args) {
        List<String> versions = crawler("https://www.java.com/releases/");// Traverse the Web from the a starting url

        // Note: This URL does not work because the website requires javascript, I do not know which query I can do to get the versions on here without using javascript

        System.out.println("Which version would you like to know the latest of? ");
        Scanner s = new Scanner(System.in);
        int i = 1;
        for(String ver : versions)
            System.out.println(i + ": v" + ver.split("[0-9]+")[0]); // get the first characters of each version
        System.out.println(versions.get(s.nextInt() - 1)); // print the current version
    }

    public static List<String> crawler(String startingURL) {
        java.net.URL url = null;
        try {
            url = new java.net.URL(startingURL); // set the url
        } catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        int relevantIndex = 0; // keep valuable indexes if needed later
        List<String> versions = new ArrayList<>();
        try {
            Scanner input = new Scanner(url.openStream()); // open the website
            StringBuilder testString = new StringBuilder(); // use a test string instead of searching the entire webpage and break it up by line
            while(input.hasNextLine() && testString.indexOf("id=\"released\"") == -1){ // find the latest releases
                testString.setLength(0); // clear the string so not as much needs to be searched
                testString.append(input.nextLine()); // add the next line
            }
            boolean firstDateFound = false; // sections are broken up by the date
            while(input.hasNextLine()){
                testString.setLength(0);
                testString.append(input.nextLine());
                if(testString.indexOf("td>20") != -1 && firstDateFound) // check if there is a date and another section is already being used
                    break;
                else if(!firstDateFound) // set after first date is found
                    firstDateFound = true;
                relevantIndex = testString.indexOf("id=\""); // set the index of any version numbers
                if(relevantIndex != -1){ // if there is a version number
                    versions.add(testString.substring(relevantIndex + 4, testString.indexOf("\"", relevantIndex+4))); // get the version between the quotation marks
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return versions; // return the list of versions
    }
}