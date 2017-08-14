package ExceptionTest;

public class SeverTimeOutException extends Exception {
    public String ip;
    public int port;

    public SeverTimeOutException() {
    }

    public SeverTimeOutException(String inf, String ip, int port) {
        super(inf);
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
