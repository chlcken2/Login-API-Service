package service.dev.advice.exception;

public class CEmailSignInFailedException extends RuntimeException{
    public CEmailSignInFailedException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public CEmailSignInFailedException(String msg) {
        super(msg);
    }

    public CEmailSignInFailedException() {
        super();
    }

}
