package br.com.fiap.soat8.grp14.techchallenge.data.repositories;

import br.com.fiap.soat8.grp14.techchallenge.data.models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
    Optional<E> findById(Long id);
}
