package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class StandardValidationError extends StandardError {
	
	private static final long serialVersionUID = 1051329724359530313L;

	private List<ValidationError> errorList;
}
