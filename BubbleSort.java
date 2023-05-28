import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
* This program calculates amount of mean median and mode.
*
* @author  Jedidiah Alfred
* @version 1.0
* @since   2023-05-13
*/

public final class BubbleSort {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private BubbleSort() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) throws Exception {

        // Initializing variables
        String line;
        final String err = "Error";
        final String splitStr = " ";
        try {
            // new file object
            final File input = new File("input.txt");

            // Creating the output
            final FileWriter output = new FileWriter("output.txt");

            try {
                // Creating the scanner.
                final Scanner scanner = new Scanner(input);

                // ArrayList to hold the lines
                final ArrayList<String> lines = new ArrayList<>();

                // Getting the input from the file
                while (scanner.hasNextLine()) {
                    // Getting next line
                    line = scanner.nextLine();
                    lines.add(line);
                }
                for (String line1 : lines) {
                    if (line1.length() != 0) {
                        try {

                            // Alex helped me with this
                            final int[] listNum = Arrays.stream(
                                    line1.split(splitStr)
                                ).mapToInt(Integer::parseInt).toArray();
                            final int[] sort = BubbleSort(listNum);
                            for (int num : sort) {
                                output.write(splitStr + num);
                            }
                            output.write("\n");
                        } catch (NumberFormatException error) {
                            output.write("ERROR: Invalid number\n");
                        }
                    } else {
                        output.write("ERROR: This empty line\n");
                    }
                }
            } catch (IOException error) {
                System.out.println(err + error.getMessage());
            }

            // closes the output
            output.close();
        } catch (IOException error) {
            System.out.println(err + error.getMessage());
        }
    }
    /**
    * This is the method reverseRecs the string.
    *
    * @param listNum This is the array to be sorted
    * @return the sorted array
    */

    public static int[] BubbleSort(int[] listNum) {
        int temp = 0;

        // This loop is the amount of times to go through the array.
        for (int counter1 = 0; counter1 < listNum.length - 1; counter1++) {
            for (int counter2 = 0; counter2 < listNum.length - counter1 - 1;
                counter2++) {
                if (listNum[counter2] > listNum[counter2 + 1]) {
                    temp = listNum[counter2];
                    listNum[counter2] = listNum[counter2 + 1];
                    listNum[counter2 + 1] = temp;
                }
            }
        }
        return listNum;
    }
}
