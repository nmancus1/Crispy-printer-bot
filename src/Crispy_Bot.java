/**
 * Nick Mancuso
 *
 * This is the driver for crispy-printer-bot.  It employs a menu used to parse input files, display the printer index,
 * and check toner levels.  displayPrinterIndex() will print all printer info in the index to the console, formatted.  Also
 * included is a console args option.
 *
 * ex: java Crispy_Bot -f filename.csv
 *
 * Where the 'f' switch allows a user to input a file, and automatically have a list of the printers that are
 * low on toner displayed, for usage with scripts or for cron jobs.  The output can be then piped to a text file.
 *
 * ex: $~date > text.txt && java Crispy_Bot -f filename.csv >> text.txt
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Crispy_Bot {

    public static void main(String[] args) {

        //Check args[], if true then jump to cmdLineTonerCheck and exit
        if(args.length != 0) {
            if (args[0].equalsIgnoreCase("-f") && args.length == 2) {
                cmdLineTonerCheck(args);
                System.exit(0);
            } else {
                System.out.println("Invalid option. Use '-f' to print list of printers low on toner from .csv file\n" +
                        "** ex: 'java Crispy_Bot -f filename.csv' ");
                System.exit(0);
            }
        }

        //Else, proceed to main program

        //Create printerIndex, scanner, and file
        PrinterIndex printerIndex = new PrinterIndex();
        Scanner scan = new Scanner(System.in);
        File csvFile;
        char inputChar;

        //Print greeting to console
        printGreeting();

        //Menu system:
        do {
            System.out.print("\n(P)arse .csv file, (D)isplay Printer Index, (C)heck low toner levels, or (Q)uit: ");

            inputChar = scan.next().charAt(0);

            switch (Character.toUpperCase(inputChar)) {

                //File input
                case 'P':
                    System.out.print("Please enter filename of .csv file (ex: 'Filename.csv'): ");
                    csvFile = new File(scan.next());

                    try {
                        printerIndex.build(csvFile);
                        System.out.println("\n" + csvFile + " successfully parsed!");

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                    }
                    break;

                //Display all printers
                case 'D':
                    displayPrinterIndexHeader();
                    System.out.println(printerIndex);
                    break;

                //Check toner levels
                case 'C':
                    System.out.println();
                    printerIndex.checkToner();
                    break;
            }
        } while (inputChar != 'q');         //quit

        System.out.println("Goodbye!");
        System.exit(0);


    }

    /**
     * Print ascii art greeting
     */
    private static void printGreeting() {

        System.out.println("\n" +
                "    __  ____   ____ _____ ____  __ __      ____  ____   ____  ____   ______    ___  ____       ____    ___   ______ \n" +
                "   /  ]|    \\ |    / ___/|    \\|  |  |    |    \\|    \\ |    ||    \\ |      |  /  _]|    \\     |    \\  /   \\ |      |\n" +
                "  /  / |  D  ) |  (   \\_ |  o  )  |  |    |  o  )  D  ) |  | |  _  ||      | /  [_ |  D  )    |  o  )|     ||      |\n" +
                " /  /  |    /  |  |\\__  ||   _/|  ~  |    |   _/|    /  |  | |  |  ||_|  |_||    _]|    /     |     ||  O  ||_|  |_|\n" +
                "/   \\_ |    \\  |  |/  \\ ||  |  |___, |    |  |  |    \\  |  | |  |  |  |  |  |   [_ |    \\     |  O  ||     |  |  |  \n" +
                "\\     ||  .  \\ |  |\\    ||  |  |     |    |  |  |  .  \\ |  | |  |  |  |  |  |     ||  .  \\    |     ||     |  |  |  \n" +
                " \\____||__|\\_||____|\\___||__|  |____/     |__|  |__|\\_||____||__|__|  |__|  |_____||__|\\_|    |_____| \\___/   |__|  \n" +
                "                                                                                                                    \n" +
                "                                                                                                                    \n" +
                "     ********************************************************************************************************     \n" +
                "     *     This command line applet consumes a .csv file, and builds an index of printers from it.          *     \n" +
                "     *     After parsing and building the index, the user can choose to parse more .csv files to keep       *      \n" +
                "     *     building the index, or display all printers in the index.  The check low toner level             *       \n" +
                "     *     option will display only the printers that are low on toner, and specify which cartridge         * \n" +
                "     *     to replace.  This program can also be run directly from the command line to check toner          *        \n" +
                "     *     levels, to be used with scripts. Ex: 'java Crispy_Bot -f filename.csv'                           *\n" +
                "     ********************************************************************************************************       \n");

    }

    /**
     * This method simply prints a formatted header for the
     * PrinterIndex's toString() method
     */

    private static void displayPrinterIndexHeader() {
        System.out.printf("\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Device Name",
                "IPV4 Address", "Last Connected", "Serial Number", "Page Count", "Black Cartridge " +
                        "%", "Color Cartridge %");
        System.out.println("==================================================================" +
                "===============================================================================");


    }

    /**
     * This method is used with command line args only.
     * @param args - String[] passed from command line
     */
    public static void cmdLineTonerCheck(String[] args) {
        PrinterIndex printerIndex = new PrinterIndex();
        Scanner scan = new Scanner(System.in);
        File csvFile;

        csvFile = new File(args[1]);
        try {
            printerIndex.build(csvFile);
            System.out.println();
            printerIndex.checkToner();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


    }

}
