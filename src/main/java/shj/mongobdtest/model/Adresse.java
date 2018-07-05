package shj.mongobdtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {

  private String rue;
  private String ville;
  @Pattern( regexp = "[0-9]{5}")
  private String codePostal;

}
