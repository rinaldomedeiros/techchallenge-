package br.com.fiap.soat8.grp14.techchallenge.app.exceptions;

import java.io.Serial;

public class DataIntegrityException extends RuntimeException {

	@Serial
    private static final long serialVersionUID = -1265334320427864056L;

	public DataIntegrityException(String message) {

        super(message);
    }
}
