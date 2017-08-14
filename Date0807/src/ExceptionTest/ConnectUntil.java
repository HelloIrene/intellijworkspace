package ExceptionTest;

public class ConnectUntil {
    public static void connect(String ip, int port) throws SeverTimeOutException {
        boolean isSuccess = openConnect(ip, port);
        if (!isSuccess) {
            throw new SeverTimeOutException("无法连接到主机" + ip, ip, port);
        }
    }

    public static boolean openConnect(String ip, int port) {
        if (ip == "127.0.0.1") {
            return true;
        }
        return false;
    }
}
