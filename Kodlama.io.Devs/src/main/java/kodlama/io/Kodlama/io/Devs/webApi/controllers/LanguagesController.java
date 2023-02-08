package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetLanguageByIdResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll() {
		return this.languageService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		this.languageService.add(createLanguageRequest);
	}

	@GetMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
		this.languageService.delete(deleteLanguageRequest);
	}

	@PostMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		this.languageService.update(updateLanguageRequest);
	}

	@GetMapping("/getById")
	public GetLanguageByIdResponse getById(int id) throws Exception {
		return languageService.getById(id); 
	}

}
