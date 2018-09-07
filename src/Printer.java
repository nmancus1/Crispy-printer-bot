

public class Printer {

    private String deviceName;
    private String ipv4Address;
    private String lastCommunication;
    private String serialNumber;
    private int pageCount;
    private int blackCartridgePercent;
    private int colorCartridgePercent;

    public Printer(String deviceName, String ipv4Address, String lastCommunication, String serialNumber, int pageCount, int blackCartridgePercent, int colorCartridgePercent) {
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
