/**
 * 
 */
package br.com.msakaguchi.exception;

/**
 * @author myller
 *
 */
public class ResultadoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResultadoNaoEncontradoException(String message) {
		super(message);
	}
}