import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PrinterIndex {

        ArrayList <Printer> printerList = new ArrayList<>();

    public PrinterIndex() {

    }

    public void add(Printer printer) {
        this.printerList.add(printer);
    }

    public void remove(Printer printer) {
        this.printerList.remove(printer);
    }

    public void build(File csvFile) throws FileNotFoundException {

        Scanner fileReader = new Scanner(csvFile);


        //Skip header in file
        fileReader.nextLine();


        while (fileReader.hasNextLine()) {
            String string = fileReader.nextLine();
            String[] printerInfoArray = string.split(",");
            buildHelper(printerInfoArray);

        }
    }

    private void buildHelper(String[] printerInfoArray) {

            Printer printer = new Printer(
                    printerInfoArray[0],
                    printerInfoArray[1],
                    printerInfoArray[2],
                    printerInfoArray[3],
                    Integer.parseInt(printerInfoArray[4]),
                    Integer.parseInt(printerInfoArray[5]),
                    Integer.parseInt(printerInfoArray[6]));

            printerList.add(printer);


    }


    public void checkToner() {
        for (Printer p :printerList){

            if(p.getBlackCartridgePercent() < 10) {
                System.out.println(p.getDeviceName() + " has " + p.getBlackCartridgePercent() + "%" + " black toner remaining.");
            }
            if(p.getColorCartridgePercent() < 10) {
                System.out.println(p.getDeviceName() + " has " + p.getColorCartridgePercent() + "%" + " color toner remaining.");
            }
            if((p.getColorCartridgePercent() < 10) || (p.getBlackCartridgePercent() < 10)){
                System.out.println();

            }
        }
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Printer p: printerList){
            sb.append(p);
            //sb.append("\n");
        }

        return sb.toString();

    }
}

