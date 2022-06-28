import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//This lab does not seem like it was for this week, but next week with the class writing

public class CSVWriter {
/*
    CSVWriter has an CSVRow object for every grading element row to be written to the spreadsheet file
    CSVWriter  handles user interaction and uses  CSVRow  objects to hold user input
    CSVWriter  writes the spreadsheet file from CSVRow's  toString method
    CSVWriter  writes the final "average" line to the spreadsheet file
    The final "average" line includes only those cells that contribute to the average calculation
    The file opens in Excel or LibreOffice.Calc as a spreadsheet with all calculations performed
    The grading weights are taken from Course Resources
*/
    private static List<CSVRow> rows = new ArrayList<>();
    public static void main(String[] args) {

        //Labs 	20
        //Reading Quizzes 	10
        //REVEL 	15
        //Midterm 	20
        //Project 	15
        //Final 	20

        Scanner s = new Scanner(System.in);
        generateRowsFromFile();
        StringBuilder avgCalc = new StringBuilder("=(");
        for(int i = 1; i <= rows.size(); i++)
            avgCalc.append("D").append(i).append("+");
        avgCalc.setLength(avgCalc.length() - 1 );
        System.out.println("Enter your scores below");
        try(PrintWriter out = new PrintWriter(new File("output.csv"))) {
            for(CSVRow row : rows){
                System.out.print(row.getName() + ": ");
                row.setScore(s.nextInt());
                out.println(row);
            }
            out.println("\"average\","+avgCalc+")/"+rows.size());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generateRowsFromFile(){
        int i = 1;
        try(Scanner s = new Scanner(new FileReader("Values.txt"))) {
            StringBuilder name = new StringBuilder();
            while(s.hasNextLine()){
                do{
                    name.append(s.next()).append(" ");
                } while(!s.hasNextInt());
                rows.add(new CSVRow(name.toString().trim(), s.nextInt(), String.format("=B%d+C%d/100", i, i)));
                i++;
                name.setLength(0);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void setRows(List<CSVRow> rows) {
        CSVWriter.rows = rows;
    }
}

class CSVRow extends CSVWriter{ // inherited earlier because I wanted to make rows protected instead of part of the main
    private final String name;
    private int score;
    private final int weight;
    private final String calc;

    public CSVRow(String name, int weight, String calc){
        this.name = name;
        this.score = 0;
        this.weight = weight;
        this.calc = calc;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public String toString() {
        return String.format("\"%s\",%d,%d,\"%s\"", name, score, weight, calc);
    }
}