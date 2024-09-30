package br.com.fiap.soat8.grp14.techchallenge.presentation.controllers.util;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class StandardError implements Serializable {

    private HttpStatus status;
    private String message;
    private LocalDateTime timestamp;

}
