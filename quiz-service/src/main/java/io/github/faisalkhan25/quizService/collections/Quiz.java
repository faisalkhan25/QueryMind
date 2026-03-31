package io.github.faisalkhan25.quizService.collections;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection = "quiz")
public class Quiz {

    @Id
    private String id;
    @Field("quiz_title")
    private String title;
    private String category;
    private String description;
    private Long maxMarks;
    private Double timeLimit;
    private String createdBy;
    private String totalQuestions;
    private String imageUrl;
    private Long passingMarks;
}
