package dao;

import org.springframework.data.repository.CrudRepository;

import models.Tries;

public interface TriesRepository extends CrudRepository<Tries, String> {

}
