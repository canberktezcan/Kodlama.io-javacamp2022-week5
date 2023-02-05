package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.SubTechnologyService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService {

	SubTechnologyRepository subTechnologyRepository;
	
	public SubTechnologyManager(SubTechnologyRepository subTechnologyRepository) {
		this.subTechnologyRepository = subTechnologyRepository;
	}

	@Override
	public List<SubTechnology> getAll() {
		
		return subTechnologyRepository.findAll();
	}

	@Override
	public void add(SubTechnology subTechnology) {
		subTechnologyRepository.save(subTechnology);
		
	}

}
