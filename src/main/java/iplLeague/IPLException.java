package iplLeague;

public class IPLException extends Exception {

    enum ExceptionType {
        NO_DATA_AVAIL,FILE_ERROR
    }

    ExceptionType type;

    public IPLException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}
