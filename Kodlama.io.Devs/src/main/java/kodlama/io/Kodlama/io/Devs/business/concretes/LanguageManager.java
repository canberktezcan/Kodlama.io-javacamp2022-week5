package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetLanguageByIdResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository, SubTechnologyRepository subTechnologyRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languageResponse = new ArrayList<GetAllLanguagesResponse>();
		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}
		return languageResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {

		if (createLanguageRequest.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez !");
		} else {
			for (Language addedLanguage : this.languageRepository.findAll()) {
				if (addedLanguage.getName().equals(createLanguageRequest.getName())) {
					throw new Exception("Bu kurs daha önce eklenmiş !");
				}
			}

			Language language = new Language();
			language.setName(createLanguageRequest.getName());
			this.languageRepository.save(language);
		}

	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language = new Language();
		language.setId(deleteLanguageRequest.getId());
		this.languageRepository.delete(language);

	}

	@Override
	public GetLanguageByIdResponse getById(int id) throws Exception {
		GetLanguageByIdResponse languageResponse = new GetLanguageByIdResponse();
		Language language = languageRepository.findById(id).get();
		languageResponse.setName(language.getName());
		return languageResponse;
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {

		if (updateLanguageRequest.getLanguageName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez !");
		} else {
			for (Language addedLanguage : this.languageRepository.findAll()) {

				if (addedLanguage.getName().equals(updateLanguageRequest.getLanguageName())) {
					throw new Exception("Bu kurs daha önce eklenmiş !");
				}
			}
		}
		boolean flag = false;
		for (Language addedLanguage : this.languageRepository.findAll()) {
			if (addedLanguage.getId() == updateLanguageRequest.getId()) {
				Language language = new Language();
				language.setId(updateLanguageRequest.getId());
				language.setName(updateLanguageRequest.getLanguageName());
				this.languageRepository.save(language);
				flag = true;
			}
		}
		if (flag == false)
			throw new Exception("Bu id numarası listede yok !");

	}

}
