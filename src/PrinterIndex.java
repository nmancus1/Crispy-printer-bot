/**
 * Nick Mancuso
 * CSC 214
 * <p>
 * This data structure stores printer objects and has methods to access them.
 * PrinterIndex can build printer objects from a .csv file, and stores them in  an
 * arrayList.  checkToner() prints a list of printer objects that have an ink level lower
 * than 10%. toString returns a list of all printers in the index and all of the printer's
 * related information.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PrinterIndex {

    //Declare and initialize arrayList to hold printer objects
    ArrayList<Printer> printerList = new ArrayList<>();
    HashMap<String, Printer> printerHashMap = new HashMap<>();

    //Default constructor
    public PrinterIndex() {

    }

    //Add printer, consumes name for key and printer object for value
    public void add(String name, Printer printer) {
        this.printerHashMap.put(name, printer);
    }

    //Remove printer, consumes name
    public void remove(String name) {
        //TODO: implement remove method using name string
        this.printerHashMap.remove(name);
    }

    /**
     * Consumes a .csv file, and creates string [] to pass to buildHelper() method
     * @param csvFile - consumes file object
     * @throws FileNotFoundException
     *
     * ex: try{ Printer.build(csvFile); } catch (FileNotFoundException e){}
     */
    public void build(File csvFile) throws FileNotFoundException {

        Scanner fileReader = new Scanner(csvFile);

        //Skip header in file
        fileReader.nextLine();

        //Iterate through file, parsing each line, creating a String[], and
        //passing to buildHelper()
        while (fileReader.hasNextLine()) {
            String string = fileReader.nextLine();
            String[] printerInfoArray = string.split(",");
            buildHelper(printerInfoArray);

        }
    }

    /**
     * buildHelper() builds printer objects from a String[] and puts them into
     * the printerHashMap.  Each field is identified below.
     *
     * @param printerInfoArray - String[] passed from build()
     */
    private void buildHelper(String[] printerInfoArray) {

        Printer printer = new Printer(
                printerInfoArray[0],                    //printer name
                printerInfoArray[1],                    //ipv4 address
                printerInfoArray[2],                    //last connected time
                printerInfoArray[3],                    //serial number
                Integer.parseInt(printerInfoArray[4]),  //page count
                Integer.parseInt(printerInfoArray[5]),  //black cartridge %
                Integer.parseInt(printerInfoArray[6])); //color cartridge %

        printerHashMap.put(printerInfoArray[0], printer);//add to printerHashMap
    }

    /**
     * checkToner() prints the information of any printer that has < 10% toner level.
     *
     * ex: PrinterIndex.checkToner();
     */
    public void checkToner() {
        for (Printer p : printerHashMap.values()) {

            if (p.getBlackCartridgePercent() < 10) {
                System.out.println(p.getDeviceName() + " has " + p.getBlackCartridgePercent()
                        + "%" + " black toner remaining @ " + p.getLastCommunication());
            }
            if (p.getColorCartridgePercent() < 10) {
                System.out.println(p.getDeviceName() + " has " + p.getColorCartridgePercent()
                        + "%" + " color toner remaining @ " + p.getLastCommunication());
            }
            if ((p.getColorCartridgePercent() < 10) || (p.getBlackCartridgePercent() < 10)) {
                System.out.println();
            }
        }
    }
    /**
     * Overrides object's toString, uses StringBuilder to construct a String
     * @return multi-line string containing the information of all printers in PrinterIndex
     *
     * ex:PrinterIndex.toString(); -or- sout(PrinterIndex)
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Printer p : printerHashMap.values()) {
            sb.append(p);
        }

        return sb.toString();

    }
}

