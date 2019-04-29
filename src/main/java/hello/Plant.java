package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Plant {

	@Id
	@GeneratedValue
	private Long plantId;

	private String plantCode;
	private String plantName;

	protected Plant() {}

	public Plant(Long plantId, String plantCode, String plantName) {
		this.plantId = plantId;
		this.plantCode = plantCode;
		this.plantName = plantName;
	}

	public Long getPlantId() {
		return this.plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}

	public String getPlantCode() {
		return plantCode;
	}

	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	@Override
	public String toString() {
		return String.format("Plant[id=%d, plantCode='%s', plantName='%s']", plantId, plantCode, plantName);
	}

}
