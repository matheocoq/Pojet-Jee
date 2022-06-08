package fr.eni.ProjetJee.bll;

public class BLLException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BLLException(String s) {
		super(s);
	}
	
	public BLLException(String s,Throwable e) {
		super(s, e);
	}
}
