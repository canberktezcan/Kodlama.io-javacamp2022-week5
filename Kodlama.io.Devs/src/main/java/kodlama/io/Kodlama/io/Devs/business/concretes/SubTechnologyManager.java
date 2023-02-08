package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.DeleteSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.subtechnology.GetAllSubTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.subtechnology.GetSubTechnologyByIdResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.Language;
import kodlama.io.Kodlama.io.Devs.entities.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {

	SubTechnologyRepository subTechnologyRepository;
	LanguageRepository languageRepository;

	@Autowired
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository,
			LanguageRepository languageRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllSubTechnologiesResponse> getAll() {
		List<SubTechnology> technologies = subTechnologyRepository.findAll();
		List<GetAllSubTechnologiesResponse> technologiesResponse = new ArrayList<GetAllSubTechnologiesResponse>();
		for (SubTechnology subtechnology : technologies) {
			GetAllSubTechnologiesResponse responseItem = new GetAllSubTechnologiesResponse();
			responseItem.setId(subtechnology.getId());
			responseItem.setTechnologyName(subtechnology.getTechnologyName());
			responseItem.setLanguage(subtechnology.getLanguage().getName());
			technologiesResponse.add(responseItem);
		}

		return technologiesResponse;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology = new SubTechnology();
		if (createSubTechnologyRequest.getTechnologyName().isEmpty()) {
			throw new Exception("Alt teknoloji dili boş geçilemez !");
		} else {
			for (SubTechnology addedTechnology : this.subTechnologyRepository.findAll()) {

				if (addedTechnology.getTechnologyName().equals(createSubTechnologyRequest.getTechnologyName())) {
					throw new Exception("Bu teknoloji daha önce eklenmiş !");
				}
			}
			Language language = languageRepository.findById(createSubTechnologyRequest.getLanguageId()).get();
			subTechnology.setTechnologyName(createSubTechnologyRequest.getTechnologyName());
			subTechnology.setLanguage(language);
		}
		subTechnologyRepository.save(subTechnology);

	}

	@Override
	public GetSubTechnologyByIdResponse getSubTechnologyByIdResponse(int id) {
		GetSubTechnologyByIdResponse subTechnologyResponse = new GetSubTechnologyByIdResponse();
		SubTechnology subTechnology = subTechnologyRepository.findById(id).get();
		subTechnologyResponse.setLanguageName(subTechnology.getLanguage().getName());
		subTechnologyResponse.setTechnologyName(subTechnology.getTechnologyName());
		return subTechnologyResponse;
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception {

		if (updateSubTechnologyRequest.getTechnologyName().isEmpty()) {
			throw new Exception("Teknoloji dili boş geçilemez !");
		} else {
			for (SubTechnology addedTechnology : this.subTechnologyRepository.findAll()) {

				if (addedTechnology.getTechnologyName().equals(updateSubTechnologyRequest.getTechnologyName())) {
					throw new Exception("Bu teknoloji daha önce eklenmiş !");
				}
			}
		}
		boolean flag = false;
		for (SubTechnology addedTechnology : this.subTechnologyRepository.findAll()) {
			if (addedTechnology.getId() == updateSubTechnologyRequest.getId()) {
				SubTechnology technology = new SubTechnology();
				Language language = languageRepository.findById(updateSubTechnologyRequest.getLanguageId()).get();
				technology.setId(updateSubTechnologyRequest.getId());
				technology.setTechnologyName(updateSubTechnologyRequest.getTechnologyName());
				technology.setLanguage(language);
				this.subTechnologyRepository.save(technology);
				flag = true;
			}
		}
		if (flag == false)
			throw new Exception("Bu id numarası listede yok !");
	}

	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) throws Exception {
		SubTechnology subTechnology = new SubTechnology();
		subTechnology.setId(deleteSubTechnologyRequest.getId());
		this.subTechnologyRepository.delete(subTechnology);
	}

}
