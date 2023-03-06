package com.example.demoonetomany.Repository;

import com.example.demoonetomany.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)//read only transactional
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("select c from Category c join fetch c.products where c.name = ?1")
    Category fetchByName(String name);
}
