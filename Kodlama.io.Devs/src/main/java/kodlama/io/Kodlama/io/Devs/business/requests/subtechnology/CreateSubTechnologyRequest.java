package kodlama.io.Kodlama.io.Devs.business.requests.subtechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubTechnologyRequest {

	private String technologyName;
	private int languageId;
}
