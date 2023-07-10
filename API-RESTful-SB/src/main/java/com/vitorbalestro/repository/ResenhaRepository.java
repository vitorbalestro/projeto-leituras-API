package com.vitorbalestro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vitorbalestro.model.Resenha;

import jakarta.persistence.LockModeType;

public interface ResenhaRepository extends JpaRepository<Resenha, Long> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select r from Resenha r where r.id = :id")
	Optional<Resenha> recuperarResenhaPorIdComLock(@Param("id") Long id);
	
	@Query("select r from Resenha r left join fetch r.livro where r.livro.id = :id")
    List<Resenha> findByLivroId(Long id);
	
	@Modifying
	@Query("delete from Resenha r where r.id=:id")
	void deleteResenhaPorId(@Param("id") Long id);
}
