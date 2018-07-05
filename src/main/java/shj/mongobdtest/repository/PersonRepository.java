package shj.mongobdtest.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import shj.mongobdtest.model.Person;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends MongoRepository<Person,String>, QuerydslPredicateExecutor<Person>{

  @Query(value = "{nom:?0}")
  public List<Person> findByQuery(String nom);

  public Person findByNom(String nom);

  /**
   * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
   * entity instance completely.
   *
   * @param entity must not be {@literal null}.
   * @return the saved entity will never be {@literal null}.
   */
  @Override
  <S extends Person> S save(@Valid S entity);
}
