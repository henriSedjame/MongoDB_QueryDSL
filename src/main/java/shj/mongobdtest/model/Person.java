package shj.mongobdtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Document(collection = "Personnes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String nom;
    @NotEmpty
    private String prenom;
    private int age;
    @Valid
    private Adresse adresse;


}

