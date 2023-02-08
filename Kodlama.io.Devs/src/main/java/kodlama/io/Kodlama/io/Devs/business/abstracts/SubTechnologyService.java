package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.CreateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.DeleteSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.subtechnology.UpdateSubTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.subtechnology.GetAllSubTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.subtechnology.GetSubTechnologyByIdResponse;

public interface SubTechnologyService {
	
	public List<GetAllSubTechnologiesResponse> getAll();
	
	public GetSubTechnologyByIdResponse getSubTechnologyByIdResponse(int id);
	
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) throws Exception;
	
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) throws Exception;
	
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) throws Exception;
}
