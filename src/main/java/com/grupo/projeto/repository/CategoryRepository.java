package com.grupo.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo.projeto.model.CategoryModel;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{

	@Query("SELECT obj FROM CategoryModel obj WHERE UPPER(obj.genre) LIKE CONCAT('%',UPPER(:genre),'%')")
	List<CategoryModel> findByDescriptionGenre(@Param("genre") String genre);
	
}
