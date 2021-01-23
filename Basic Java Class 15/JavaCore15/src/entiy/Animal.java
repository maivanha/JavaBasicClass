package entiy;

public abstract class Animal implements AnimalInterface {
	private String name;
	private String descriptTion;
	private String animalCode;
	private int avrAge;
	private int curAge;
	private double ratio;
	
	public Animal(String name, String descriptTion, String animalCode) {
		this.name = name;
		this.descriptTion = descriptTion;
		this.animalCode = animalCode;
	}
	
	@Override
	public double calculateRatio() {
		return ((double)this.getCurAge()) / this.getAvrAge();
	}
	
	@Override
	public void compare(AnimalInterface anInter) {
		if( this.calculateRatio() > anInter.calculateRatio()) 
			System.out.println(this.getName() + " gia hon so voi " + ((Animal)anInter).getName());
		else 
			System.out.println(this.getName() + " tre hon so voi " + ((Animal)anInter).getName());
	}
	
	public int compareTo(AnimalInterface anInter) {
		if( this.calculateRatio() > anInter.calculateRatio()) 
			return 1;
		else 
			return -1;
	}
	
	public abstract void screenPrint();
	
	@Override
	public void screenPrint(String message) {
		screenPrint();
		System.out.println("\ttin nhan gui kem:" + message);
	}
	
	public int getAvrAge() {
		return avrAge;
	}

	public void setAvrAge(int avrAge) {
		this.avrAge = avrAge;
	}

	public int getCurAge() {
		return curAge;
	}

	public void setCurAge(int curAge) {
		this.curAge = curAge;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescriptTion() {
		return descriptTion;
	}
	public void setDescriptTion(String descriptTion) {
		this.descriptTion = descriptTion;
	}
	public String getAnimalCode() {
		return animalCode;
	}
	public void setAnimalCode(String animalCode) {
		this.animalCode = animalCode;
	}
}
