package br.com.alura.aluraAPI.infra;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.alura.aluraAPI.domain.Language;

public interface LanguageRepository extends MongoRepository<Language, String>{

}
