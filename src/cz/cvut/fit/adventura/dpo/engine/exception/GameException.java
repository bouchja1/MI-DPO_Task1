package cz.cvut.fit.adventura.dpo.engine.exception;

/**
 * @author bouc2162
 *
 * Hern� v�jimka. Pro p��pad nep��tomnosti ��dan� m�stnosti, v�ci...
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
