package br.com.fiap.soat8.grp14.techchallenge.domain.exceptions;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6110481248669701084L;

	public EntityNotFoundException(String message) {

        super(message);
    }

}
