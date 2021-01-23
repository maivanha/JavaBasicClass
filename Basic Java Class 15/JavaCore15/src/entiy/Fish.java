package entiy;

public class Fish extends Animal {

	public Fish(String name, String descriptTion, String animalCode) {
		super(name, descriptTion, animalCode);
	}

	@Override
	public void screenPrint() {
		System.out.println("Thong tin cua chu cho nay:");
		System.out.println("\tname: " + this.getName());
		System.out.println("\tdescriptTion: " + this.getDescriptTion());
		System.out.println("\tanimalCode: " + this.getAnimalCode());
	}
}
