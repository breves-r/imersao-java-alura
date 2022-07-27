package br.com.alura.aluraAPI.app;

import org.springframework.web.bind.annotation.RestController;

import br.com.alura.aluraAPI.domain.Language;
import br.com.alura.aluraAPI.infra.LanguageRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LanguageController {

	@Autowired
	private LanguageRepository languageRepository;
	
	@GetMapping("/languages")
	public List<Language> getLanguages() {
		return languageRepository.findAll();
	}
	
	@PostMapping("/languages")
    public Language addLanguage(@RequestBody Language language) {
        return languageRepository.save(language);
    }
}
