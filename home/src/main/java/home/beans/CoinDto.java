package home.beans;

public class CoinDto {
	private int coinNo;
	private String coinName;
	private int coinAmount;	
	
	public CoinDto() {
		super();
	}
	
	public int getCoinNo() {
		return coinNo;
	}
	public void setCoinNo(int coinNo) {
		this.coinNo = coinNo;
	}
	public String getCoinName() {
		return coinName;
	}

	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public int getCoinAmount() {
		return coinAmount;
	}
	public void setCoinAmount(int coinAmount) {
		this.coinAmount = coinAmount;
	}

	@Override
	public String toString() {
		return "CoinDto [coinNo=" + coinNo + ", coinName=" + coinName + ", coinAmount=" + coinAmount + "]";
	}
	
}
