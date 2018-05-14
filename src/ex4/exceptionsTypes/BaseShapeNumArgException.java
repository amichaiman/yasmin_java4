package ex4.exceptionsTypes;

public class BaseShapeNumArgException extends Exception {
	public BaseShapeNumArgException(String theLines) {
        super(theLines);
    }
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invlid number of arguments in line: " + super.getMessage();
	}
}
