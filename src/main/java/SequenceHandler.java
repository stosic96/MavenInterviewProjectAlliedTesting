import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This is a class for handling sorted sequence files which contain integers stored on separate lines.
 */
public class SequenceHandler {

    /**
     * Method that uses a FileWriter object provided as a parameter to write a number in a new line in a file.
     * @param writer FileWriter object used to write to a file
     * @param number number to write in a new line
     * @return null value that can be used to reset the written number
     * @throws IOException
     */
    private  Integer writeNumberToResultFile(FileWriter writer, Integer number) throws IOException {
        writer.write(number + "\n");
        return null;
    }

    /**
     * Method that produces text file C containing sorted sequence of all numbers from files A and B.
     * Text files A and B each contain a sorted sequence of integer numbers stored on separate lines.
     *
     * @param sortedSequenceFileA path to the first file. Example: src\main\resources\A.txt
     * @param sortedSequenceFileB path to the second file. Example: src\main\resources\B.txt
     * @param resultFileName      path to the result file that will be created from the first two. If file already exists, it will be overridden. Example: src\main\resources\C.txt
     * @throws Exception
     */
    public  void createSortedSequenceFile(String sortedSequenceFileA, String sortedSequenceFileB, String resultFileName) throws Exception {
        FileWriter writer = null;
        try {
            writer = new FileWriter(resultFileName);
            File A = new File(sortedSequenceFileA);
            File B = new File(sortedSequenceFileB);
            Scanner scanA = new Scanner(A);
            Scanner scanB = new Scanner(B);
            Integer numA = null;
            Integer numB = null;
            while ((scanA.hasNextLine() || scanB.hasNextLine()) || (numA != null || numB != null)) {
                if (scanA.hasNextLine() && numA == null) {
                    numA = Integer.parseInt(scanA.nextLine());
                }
                if (scanB.hasNextLine() && numB == null) {
                    numB = Integer.parseInt(scanB.nextLine());
                }
                if (numA != null && numB != null) {
                    if (numA <= numB) {
                        numA = writeNumberToResultFile(writer, numA);
                    } else {
                        numB = writeNumberToResultFile(writer, numB);
                    }
                } else if (numA != null) {
                    numA = writeNumberToResultFile(writer, numA);
                } else {
                    numB = writeNumberToResultFile(writer, numB);
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Input file not found!");
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input file should only contain integer values!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
