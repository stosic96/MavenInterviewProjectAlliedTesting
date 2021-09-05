import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class used for testing SequenceHandler class.
 * Each test case has it's own resource directory which contains necessary files.
 * <p>
 * Test cases either compare the resulting file with the expected file, or check if the correct exception is thrown.
 */
class SequenceHandlerTest {

    /**
     * Path to directories containing resource files for the test cases
     */
    String testResources = "src/test/resources/";
    SequenceHandler sequenceHandler;

    /**
     * Method that creates a fresh instance before each test case
     */
    @BeforeEach
    void setUp() {
        sequenceHandler = new SequenceHandler();
    }

    /**
     * Test case where both input files are formatted correctly
     */
    @Test
    void testInterviewExample() {
        String testDirectoryName = "testInterviewExample";
        try {
            sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            assertTrue(compareExpectedAndResultFile(testResources + testDirectoryName + "/expected.txt", testResources + testDirectoryName + "/C.txt"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    /**
     * Test case where both input files are empty
     */
    @Test
    void testEmptyInputFiles() {
        String testDirectoryName = "testEmptyInputFiles";
        try {
            sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            assertTrue(compareExpectedAndResultFile(testResources + testDirectoryName + "/expected.txt", testResources + testDirectoryName + "/C.txt"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    /**
     * Test case where the first input file is empty
     */
    @Test
    void testEmptyFirstInputFile() {
        String testDirectoryName = "testEmptyFirstInputFile";
        try {
            sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            assertTrue(compareExpectedAndResultFile(testResources + testDirectoryName + "/expected.txt", testResources + testDirectoryName + "/C.txt"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    /**
     * Test case where the second input file is empty
     */
    @Test
    void testEmptySecondInputFile() {
        String testDirectoryName = "testEmptySecondInputFile";
        try {
            sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            assertTrue(compareExpectedAndResultFile(testResources + testDirectoryName + "/expected.txt", testResources + testDirectoryName + "/C.txt"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    /**
     * Test case where the input files contain negative values
     */
    @Test
    void testNegativeValues() {
        String testDirectoryName = "testEmptyInputFiles";
        try {
            sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            assertTrue(compareExpectedAndResultFile(testResources + testDirectoryName + "/expected.txt", testResources + testDirectoryName + "/C.txt"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    /**
     * Test case where the input files contain a float value.
     * Since only integer values are expected, a NumberFormatException is expected to occur.
     */
    @Test
    void testInputFileWithFloat() {
        String testDirectoryName = "testInputFileWithFloat";
        try {
            assertThrows(NumberFormatException.class, () -> {
                sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            });
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }
    /**
     * Test case where the input files contain a string value.
     * Since only integer values are expected, a NumberFormatException is expected to occur.
     */
    @Test
    void testInputFileWithString() {
        String testDirectoryName = "testInputFileWithString";
        try {
            assertThrows(NumberFormatException.class, () -> {
                sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            });
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    /**
     * Test case where the path to the input files is incorrect.
     * A FileNotFoundException is expected to occur.
     */
    @Test
    void testFileNotFound() {
        String testDirectoryName = "testFileNotFound";
        try {
            assertThrows(FileNotFoundException.class, () -> {
                sequenceHandler.createSortedSequenceFile(testResources + testDirectoryName + "/A.txt", testResources + testDirectoryName + "/B.txt", testResources + testDirectoryName + "/C.txt");
            });
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }


    /**
     * A method that checks the equality of the provided files.
     * @param expectedFileName path to the first file. Example: src\test\resources\expected.txt
     * @param resultFileName   path to the second file. Example: src\test\resources\result.txt
     * @return true if the files are the same, false otherwise
     * @throws FileNotFoundException
     */
    boolean compareExpectedAndResultFile(String expectedFileName, String resultFileName) throws FileNotFoundException {
        File expectedFile = new File(expectedFileName);
        File resultFile = new File(resultFileName);
        Scanner scanExpectedFile = new Scanner(expectedFile);
        Scanner scanResultFile = new Scanner(resultFile);
        int expectedFileNum;
        int resultFileNum;
        while (scanExpectedFile.hasNextLine() && scanResultFile.hasNextLine()) {
            expectedFileNum = Integer.parseInt(scanExpectedFile.nextLine());
            resultFileNum = Integer.parseInt(scanResultFile.nextLine());
            if (expectedFileNum != resultFileNum) return false;
        }
        return true;
    }
}