package shj.mongobdtest.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import shj.mongobdtest.model.Adresse;
import shj.mongobdtest.model.Person;
import shj.mongobdtest.repository.PersonRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Component
@Profile(value = "dev")
public class DBSeeder implements CommandLineRunner {


  private PersonRepository personRepository;

  public DBSeeder(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  /**
   * Callback used to run the bean.
   *
   * @param args incoming main method arguments
   * @throws Exception on error
   */
  @Override
  public void run(String... args) throws Exception {

    Person p1 = new Person(null,"SEDJAME","", 31, new Adresse("14 rue de la paix", "bordeaux", "33000"));
    Person p2 = new Person(null,"LE NAIN", "Chloe", 27, new Adresse("rue de capucins", "Pessac", "33250"));
    Person p3 = new Person(null,"KOKOU", "Alvin", 15, new Adresse("2avenue des peties", "Paris", "75789"));
    Person p4 = new Person(null,"RAGOON", "Patricia", 41, new Adresse("4 rue de la marelle", "Mans", "480"));


    this.personRepository.deleteAll();

    List<Person> people = Arrays.asList(p1, p2, p3, p4);
    people.forEach(p-> {
      try {
        this.personRepository.save(p);
      }catch (Exception e){
        System.out.println("ERREUR : " + e.getMessage());
      }
    });

    //this.personRepository.saveAll(people);

  }
}
