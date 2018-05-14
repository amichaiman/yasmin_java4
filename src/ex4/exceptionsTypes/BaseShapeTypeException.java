package ex4.exceptionsTypes;

public class BaseShapeTypeException extends Exception {
    public BaseShapeTypeException(String theLines) {
        super(theLines);
    }

    @Override
    public String getMessage() {
        return "The following base in this line is invalid: " + super.getMessage();
    }
}
