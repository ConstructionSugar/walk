package human;

import config.WalkConstants;

public class User extends Human {

	static WalkConstants w1 = new WalkConstants();

	private int hp;
	private int happiness;
	private int money;
	private int pedometer;

	public int getHp() { return hp; }
	public void setHp(int hp) { this.hp = hp; }

	public int getHappiness() { return happiness; }
	public void setHappiness(int happiness) { this.happiness = happiness; }

	public int getMoney() { return money; }
	public void setMoney(int money) { this.money = money; }

	public int getPedometer() { return pedometer; }
	public void setPedometer(int pedometer) { this.pedometer = pedometer; }

	public User() {
		this.hp = WalkConstants.HPINIT;
		this.happiness = WalkConstants.HAPPINESSHPINIT;
		this.money = WalkConstants.MONEYINIT;
		this.pedometer = 0;
	}
}
