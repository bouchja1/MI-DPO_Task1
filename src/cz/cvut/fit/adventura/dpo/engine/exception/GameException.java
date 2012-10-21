package cz.cvut.fit.adventura.dpo.engine.exception;

/**
 * @author bouc2162
 *
 * Herní výjimka. Pro pøípad nepøítomnosti žádané místnosti, vìci...
 */
public class GameException extends Exception {
	private String message;

	public GameException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
