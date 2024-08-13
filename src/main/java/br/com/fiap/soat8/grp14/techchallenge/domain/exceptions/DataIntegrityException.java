package br.com.fiap.soat8.grp14.techchallenge.domain.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = -1265334320427864056L;

	public DataIntegrityException(String message) {

        super(message);
    }
}
