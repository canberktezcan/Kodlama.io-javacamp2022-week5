package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdResponse;

public interface LanguageService {

	public List<GetAllLanguagesResponse> getAll();

	public void add(CreateLanguageRequest createLanguageRequest) throws Exception;

	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception;

	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception;

	public GetByIdResponse getById(int id) throws Exception;

}
