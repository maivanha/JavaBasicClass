package entiy;

public class Cat extends Animal {
	
	private String certification;
	
	final int finVar = 15;
	
	public Cat(String name, String descriptTion, String animalCode, String certification) {
		super(name, descriptTion, animalCode);
		this.certification = certification;
	}

	@Override
	public void screenPrint() {
		System.out.println("Thong tin cua chu cho nay:");
		System.out.println("\tname: " + this.getName());
		System.out.println("\tdescriptTion: " + this.getDescriptTion());
		System.out.println("\tanimalCode: " + this.getAnimalCode());
		System.out.println("\tcertification: " + this.getCertification());
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}
}
