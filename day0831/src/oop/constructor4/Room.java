package oop.constructor4;

public class Room {

	//멤버 변수
	private String name;
	private int numberOfPeople;
	private int lowSeasonPrice;
	private int semiPeakSeasonPrice;
	private int peakSeasonPrice;

	//멤버 메소드
	public void setName(String name) {
		this.name = name;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		//2명 미만일 경우 2명으로 설정하기 위한 코드
		if(numberOfPeople < 2) {
			numberOfPeople = 2;
		}
		this.numberOfPeople = numberOfPeople;
	}
	public void setLowSeasonPrice(int lowSeasonPrice) {
		if(lowSeasonPrice < 0) {
			return;
		}
		this.lowSeasonPrice = lowSeasonPrice;
	}
	public void setSemiPeakSeasonPrice(int semiPeakSeasonPrice) {
		if(semiPeakSeasonPrice < 0) {
			return;
		}
		this.semiPeakSeasonPrice = semiPeakSeasonPrice;
	}
	public void setPeakSeasonPrice(int peakSeasonPrice) {
		if(peakSeasonPrice < 0) {
			return;
		}
		this.peakSeasonPrice = peakSeasonPrice;
	}

	public String getName() {
		return this.name;
	}
	public int getNumberOfPeople() {
		return this.numberOfPeople;
	}
	public int getLowSeasonPrice() {
		return this.lowSeasonPrice;
	}
	public int getSemiPeakSeasonPrice() {
		return this.semiPeakSeasonPrice;
	}
	public int getPeakSeasonPrice() {
		return this.peakSeasonPrice;
	}

	//생성자
	//[1] 이름 + 인원수 + 비성수기요금 
	//[2] 이름 + 인원수 + 비성수기요금 + 성수기요금
	//[3] 이름 + 인원수 + 비성수기요금 + 준성수기요금 + 성수기요금
	public Room(String name, int numberOfPeople, int lowSeasonPrice) {
		this.setName(name);
		this.setNumberOfPeople(numberOfPeople);
		this.setLowSeasonPrice(lowSeasonPrice);
		this.setSemiPeakSeasonPrice(lowSeasonPrice);
		this.setPeakSeasonPrice(lowSeasonPrice);
	}

	public Room(String name, int numberOfPeople, int lowSeasonPrice, int peakSeasonPrice) {
		this.setName(name);
		this.setNumberOfPeople(numberOfPeople);
		this.setLowSeasonPrice(lowSeasonPrice);
		this.setSemiPeakSeasonPrice(peakSeasonPrice);
		this.setPeakSeasonPrice(peakSeasonPrice);
	}

	public Room(String name, int nuberOfPeople, int lowSeasonPrice, 
										int semiPeakSeasonPrice, int peakSeasonPrice) {
		this.setName(name);
		this.setNumberOfPeople(nuberOfPeople);
		this.setLowSeasonPrice(lowSeasonPrice);
		this.setSemiPeakSeasonPrice(semiPeakSeasonPrice);
		this.setPeakSeasonPrice(peakSeasonPrice);
	}

	public void showInfo() {
		System.out.println("<객실 정보>");
		System.out.println("객실명 : "+this.name);//this.getName()
		System.out.println("이용인원 : "+this.numberOfPeople+"명");//this.getNumberOfPeople()
		System.out.println("비수기 : "+this.lowSeasonPrice+"원");//this.getLowSeasonPrice()
		System.out.println("준성수기 : "+this.semiPeakSeasonPrice+"원");//this.getSemiSeasonPrice()
		System.out.println("성수기 : "+this.peakSeasonPrice+"원");//this.getPeakSeasonPrice()
	}
}
