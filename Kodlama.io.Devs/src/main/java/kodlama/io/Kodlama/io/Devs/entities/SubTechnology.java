package kodlama.io.Kodlama.io.Devs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="subtechnologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubTechnology {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="technology_name")
	private String technologyName;

	@ManyToOne
	@JoinColumn(name="language_id")
	public Language language;

}
