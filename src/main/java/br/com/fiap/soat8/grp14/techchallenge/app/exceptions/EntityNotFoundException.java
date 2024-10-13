package br.com.fiap.soat8.grp14.techchallenge.app.exceptions;

import java.io.Serial;

public class EntityNotFoundException extends RuntimeException {

	@Serial
    private static final long serialVersionUID = 6110481248669701084L;

	public EntityNotFoundException(String message) {

        super(message);
    }

}
