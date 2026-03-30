package io.github.faisalkhan25.categoryService.repositories;


import io.github.faisalkhan25.categoryService.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
