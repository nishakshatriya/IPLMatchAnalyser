package iplLeague;

public class IPLException extends Exception {

    enum ExceptionType {
        FILE_NOT_FOUND
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
