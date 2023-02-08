package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.language.GetLanguageByIdResponse;

public interface LanguageService {

	public List<GetAllLanguagesResponse> getAll();

	public GetLanguageByIdResponse getById(int id) throws Exception;
	
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception;

	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;

	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;

	

}
