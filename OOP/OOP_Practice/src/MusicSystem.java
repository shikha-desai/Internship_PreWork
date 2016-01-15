
public class MusicSystem {
	
	String Model;
	Car UsedBy; //Association
	
	public MusicSystem() {
		super();
	}

	public MusicSystem(String model, Car UsedBy) {
		super();
		Model = model;
		this.UsedBy = UsedBy;
	}
	
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public Car getUsedBy() {
		return UsedBy;
	}
	public void setOwner(Car UsedBy) {
		this.UsedBy = UsedBy;
	}

}
