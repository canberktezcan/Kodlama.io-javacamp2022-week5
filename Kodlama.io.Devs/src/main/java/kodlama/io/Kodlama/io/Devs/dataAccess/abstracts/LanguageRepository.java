package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{

//	void add(Language language);
//	void delete(int id) throws Exception;
//	void update(Language language);
//	Language getById(int id);
//	List<Language> getAll();
}
