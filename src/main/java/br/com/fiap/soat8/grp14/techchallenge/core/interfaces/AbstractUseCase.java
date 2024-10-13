package br.com.fiap.soat8.grp14.techchallenge.core.interfaces;

import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class AbstractUseCase<I, O> {

    @Autowired
    ModelMapper modelMapper;

    protected AbstractUseCase() {
    }

    public abstract O execute(I input);

}
