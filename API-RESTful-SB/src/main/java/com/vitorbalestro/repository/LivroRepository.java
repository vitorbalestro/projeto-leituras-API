package com.vitorbalestro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vitorbalestro.model.Livro;

import jakarta.persistence.LockModeType;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	 
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select l from Livro l where l.id = :id")
	Optional<Livro> recuperarLivroPorIdComLock(@Param("id") Long id);
	
	@Query(
            value = "select l from Livro l order by l.id",
            countQuery = "select count(l) from Livro l"
    )
	Page<Livro> recuperarLivrosPaginados(Pageable pageable);
	
	@Query("select l from Livro l left join fetch l.categoria where l.categoria.id = :id")
    List<Livro> findByCategoriaId(Long id);
	
}

