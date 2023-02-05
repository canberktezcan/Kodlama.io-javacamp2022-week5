/*package kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.Language;
@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language>languages;
	@Autowired
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1,"Java"));
		languages.add(new Language(2,"C#"));
		languages.add(new Language(3,"Phyton"));
	}

	@Override
	public List<Language> getAll() {
		return this.languages;
	}

	@Override
	public void add(Language language) {
		this.languages.add(language);
	}

	@Override
	public void delete(int id) throws Exception {
		for (Language language : languages) {
			if (language.getId() == id) {
				this.languages.remove(language);
			}
		}
	}
	@Override
	public void update(Language language) {
		getById(language.getId()).setName(language.getName());
	}

	@Override
	public Language getById(int id) {
		for (Language language : languages) {
			if (language.getId() == id) {
				return language;
			}
		}
		return null;
	}

}
*/