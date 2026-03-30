package io.github.faisalkhan25.categoryService.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Category {
    @Id
    private String id;
    private String title;
    private String description;
    private Boolean active;
}
