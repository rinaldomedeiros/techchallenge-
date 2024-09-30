package br.com.fiap.soat8.grp14.techchallenge.core.interfaces;

import lombok.Getter;
import org.modelmapper.ModelMapper;

public abstract class AbstractUseCase<I, O> {
    @Getter
    protected final ModelMapper mapper;

    protected AbstractUseCase(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public abstract O execute(I input);

}
