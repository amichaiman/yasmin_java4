package ex4.exceptionsTypes;

public class ShapeTypeException extends Exception {

    public ShapeTypeException(String theLines) {
        super(theLines);
    }

    @Override
    public String getMessage() {
        return "The following shape in this line is Invalid: " + super.getMessage();
    }
}
