package shj.mongobdtest.controller;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shj.mongobdtest.model.Person;
import shj.mongobdtest.model.QPerson;
import shj.mongobdtest.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class PersonController {

  private PersonRepository personRepository;

  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Person>> getAll(){
    return new ResponseEntity<List<Person>>(this.personRepository.findAll(), HttpStatus.OK);
  }

  @PostMapping
  public void insert(@RequestBody Person p){
    this.personRepository.insert(p);
  }

  @PutMapping
  public void update(@RequestBody Person p){
    this.personRepository.save(p);
  }

  @GetMapping("{nom}")
  public ResponseEntity<Person> findByName(@PathVariable("nom") String nom){
    return new ResponseEntity<>(this.personRepository.findByNom(nom), HttpStatus.OK);
  }

  @GetMapping(value = "/city/{city}")
  public ResponseEntity<List<Person>> findPeopleByCity(@PathVariable("city") String ville){
    QPerson qPerson = new QPerson("person");
    BooleanExpression filter = qPerson.adresse.ville
                                              .equalsIgnoreCase(ville)
                                              .or(
                                                qPerson.adresse.ville.containsIgnoreCase(ville)
                                              );

    return new ResponseEntity<List<Person>>((List<Person>)this.personRepository.findAll(filter), HttpStatus.OK);
  }
}
