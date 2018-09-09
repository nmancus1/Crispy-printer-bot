/**
 * Nick Mancuso
 *
 * This class represents a printer.  The preferred method of building printer objects is in the PrinterIndex class,
 * using the .build method.  The toString() method uses String.format to provide a formatted line of printer information
 * that corresponds to the header printed in the main method.
 */

public class Printer {

    private String deviceName;                  //Name of printer
    private String ipv4Address;                 //ipv4 address of printer
    private String lastCommunication;           //time of last communication
    private String serialNumber;                //serial number
    private int pageCount;                      //page count
    private int blackCartridgePercent;          //black cartridge %
    private int colorCartridgePercent;          //color cartridge %

    /**
     * @param deviceName - name of printer
     * @param ipv4Address - ipv4 address
     * @param lastCommunication - time of last communication
     * @param serialNumber - serial number
     * @param pageCount - page count
     * @param blackCartridgePercent - black cartridge %
     * @param colorCartridgePercent - color cartridge %
     */
    public Printer(String deviceName, String ipv4Address, String lastCommunication, String serialNumber,
                   int pageCount, int blackCartridgePercent, int colorCartridgePercent) {
        this.deviceName = deviceName;
        this.ipv4Address = ipv4Address;
        this.lastCommunication = lastCommunication;
        this.serialNumber = serialNumber;
        this.pageCount = pageCount;
        this.blackCartridgePercent = blackCartridgePercent;
        this.colorCartridgePercent = colorCartridgePercent;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIpv4Address() {
        return ipv4Address;
    }

    public void setIpv4Address(String ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    public String getLastCommunication() {
        return lastCommunication;
    }

    public void setLastCommunication(String lastCommunication) {
        this.lastCommunication = lastCommunication;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBlackCartridgePercent() {
        return blackCartridgePercent;
    }

    public void setBlackCartridgePercent(int blackCartridgePercent) {
        this.blackCartridgePercent = blackCartridgePercent;
    }

    public int getColorCartridgePercent() {
        return colorCartridgePercent;
    }

    public void setColorCartridgePercent(int colorCartridgePercent) {
        this.colorCartridgePercent = colorCartridgePercent;
    }

    //Returns a formatted String corresponding to the header in main.
    @Override
    public String toString() {
        return String.format("\n%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                this.deviceName,
                this.ipv4Address,
                this.lastCommunication,
                this.serialNumber,
                this.pageCount,
                this.blackCartridgePercent,
                this.colorCartridgePercent);
    }
}
