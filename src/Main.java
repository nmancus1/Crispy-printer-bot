import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PrinterIndex printerIndex = new PrinterIndex();
        Scanner scan = new Scanner(System.in);
        File csvFile;

        char inputChar;


        printGreeting();

        do {
            System.out.print("\n(P)arse .csv file, (D)isplay Printer Index, (C)heck low toner levels, or (Q)uit: ");

            inputChar = scan.next().charAt(0);

            switch (Character.toUpperCase(inputChar)) {

                case 'P':
                    System.out.print("Please enter filename of .csv file (ex: 'Filename.csv'): ");
                    csvFile = new File(scan.next());

                    try {
                        printerIndex.build(csvFile);
                        System.out.println(csvFile + " successfully parsed!");

                    } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                    }
                    break;

                case 'D':
                    displayPrinterIndex(printerIndex);
                    break;

                case 'C':
                    System.out.println();
                    printerIndex.checkToner();
                    break;
            }
        } while (inputChar != 'q');

        System.out.println("Goodbye!");
        System.exit(0);


    }

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
                "     *     After parsing and building the index, the user can choose to parse more .csv files to keep      *      \n" +
                "     *     building the index, or display all printers in the index.  The check low toner level             *       \n" +
                "     *     option will display only the printers that are low on toner, and specify which cartridge         * \n" +
                "     *     to replace.                                                                                      *        \n" +
                "     ********************************************************************************************************       \n");

    }

    private static void displayPrinterIndex(PrinterIndex printerIndex) {
        System.out.printf("\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Device Name",
                "IPV4 Address", "Last Connected", "Serial Number", "Page Count", "Black Cartridge " +
                        "%", "Color Cartridge %");
        System.out.println("==================================================================" +
                "===============================================================================");
        System.out.println(printerIndex);


    }

}
