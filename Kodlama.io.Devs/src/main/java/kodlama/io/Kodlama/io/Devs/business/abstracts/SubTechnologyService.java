package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.entities.SubTechnology;

public interface SubTechnologyService {
	public List<SubTechnology> getAll();
	public void add(SubTechnology subTechnology);
}
