package main;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import config.WalkConstants;
import human.User;

public class ActionControl {

	User u1 = new User();
	PrintControl p1 = new PrintControl();

	boolean errFlg = false;
//	Scanner sc = new Scanner(System.in) ;

//	オープニングの処理をするメソッド
	void openingAction() {
		if (!errFlg) { p1.printManual(); }
		p1.printCmdMain(WalkConstants.STARTCHECKMSG,"2");
		Scanner sc = new Scanner(System.in) ;
		try {
			int startCkCmd = sc.nextInt();
			System.out.println(startCkCmd);
			startCheckCmd(startCkCmd) ;
		} catch (InputMismatchException ex) {
			inputErr();
			openingAction();
		}
	}

//	ゲームの開始確認コマンド結果を処理するメソッド
	void startCheckCmd(int startCkCmd) {
		switch (startCkCmd) {
			case 1:
				p1.printUserNameIn();
				Scanner sc = new Scanner(System.in) ;
				try {
					String name = sc.next();
					u1.setName(name) ;
					p1.printUserName(u1.getName());
					WalkMain.userRow--;
				} catch (InputMismatchException ex) {
					inputErr();
					startCheckCmd(1);
				}
				break;
			case 2:
				p1.printEnding(WalkConstants.ENDINGMSG0,WalkConstants.ENDTITLE0);
				System.exit(0);
				break;
			default:
				inputErr();
				openingAction();
				break;
		}
	}

//	主人公の地図移動を処理するメソッド
	void moveUsr(char moveKey) {
		int exuserRow = WalkMain.userRow, exuserCol = WalkMain.userCol;

		switch (moveKey) {
			case 'j':	// 上
				exuserRow--;
				break;
			case 'k':	// 下
				exuserRow++;
				break;
			case 'h':	// 左
				exuserCol--;
				break;
			case 'l':	// 右
				exuserCol++;
				break;
			default:
				p1.printInputErr2();
				return;
		}
		int recoverHp = hpUpDownUser(-1);
		hpCheckUser();
		if (WalkMain.userRow != WalkConstants.HOMEROW && WalkMain.userCol != WalkConstants.HOMECOL) {
			p1.printFreeMsg(u1.getName() + WalkConstants.MOVEMSG);
			p1.printHpDown(recoverHp);
		}

		if (WalkMain.wall[exuserRow][exuserCol]) {
			p1.printDeadEnd();
			recoverHp = hpUpDownUser(-2);
			hpCheckUser();
			p1.printHpDown(recoverHp);
			return;
		}

		WalkMain.userRow = exuserRow;
		WalkMain.userCol = exuserCol;
	}

//	主人公ステータス情報表示を処理するメソッド
	void PrintUserStatus() {
		p1.printUserStatus(u1.getName());
		p1.printUserStatus(u1.getHp(),u1.getHappiness(),u1.getMoney());
		p1.keyboardCmd();
	}

//	ランダムイベントを処理するメソッド
	void randomAction() {
		Random rand = new Random();
		int num = rand.nextInt(10);
		if (num == 1) {
			p1.printCmdMain(WalkConstants.RANDOMEVENTMSG,"3");
			Scanner sc = new Scanner(System.in) ;
			try {
				int randomCmd = sc.nextInt();
				switch (randomCmd) {
				case 1:
					int recoverHp = hpUpDownUser(20);
					p1.printHpUp(recoverHp);
					break;
				case 2:
					int recoverHappiness = happinessUpDownUser(20);
					p1.printHappinessUp(recoverHappiness);
					break;
				case 3:
					moneyUpDownUser(2000);
					p1.printMoneyUp(2000);
					break;
				default:
					inputErr();
					randomAction();
					break;
				}
			} catch (InputMismatchException ex) {
				inputErr();
				randomAction();
			}
		} else if (num == 4) {
			System.out.println(WalkConstants.HPLOST);
			int recoverHp = hpUpDownUser(-5);
			hpCheckUser();
			p1.printHpDown(recoverHp);
		}
	}

//	帰宅時(家)の処理メソッド
	void goHomeAction() {
		p1.printCmdMain(WalkConstants.HOME,"2");
		Scanner sc = new Scanner(System.in) ;
		try {
			int homeCmd = sc.nextInt();
			switch (homeCmd) {
			case 1:
				String walkResult = walkResultCheck();
				p1.printEnding(WalkConstants.ENDINGMSG5,walkResult);
				System.exit(0);
				break;
			case 2:
				WalkMain.userRow--;
				break;
			default:
				inputErr();
				goHomeAction();
				break;
			}
		} catch (InputMismatchException ex) {
			inputErr();
			goHomeAction();
		}
	}

//	公園到着時の処理をするメソッド
	void parkAction() {
		p1.printCmdMain(WalkConstants.PARK,"5");
		int parkCmd;
		Scanner sc = new Scanner(System.in) ;
		try {
			int parkInCmd = sc.nextInt();
			if (parkInCmd == 5) {
				Random rand = new Random();
				parkCmd = rand.nextInt(4) + 1;
			} else {
				parkCmd = parkInCmd;
			}
			if (parkCmd < 1 || parkCmd > 4) {
				inputErr();
				parkAction();
			} else {
				p1.printFreeMsg(WalkConstants.getParkCmd(parkCmd - 1));
				WalkMain.userRow--;
			}
			switch (parkCmd) {
			case 1:
			case 2:
			case 3:
				int recoverHp = hpUpDownUser(-5);
				hpCheckUser();
				p1.printHpDown(recoverHp);
				int recoverHappiness = happinessUpDownUser(10);
				p1.printHappinessUp(recoverHappiness);
				break;
			}
		} catch (InputMismatchException ex) {
			inputErr();
			parkAction();
		}
	}

//	カフェ(店)到着時の処理をするメソッド
	void cafeAction() {
		p1.printCmdMain(WalkConstants.CAFE,"3");
		int cafeCmd;
		Scanner sc = new Scanner(System.in) ;
		try {
			int cafeInCmd = sc.nextInt();
			Random rand = new Random();
			if (cafeInCmd == 3) {
				cafeCmd = rand.nextInt(2) + 1;
			} else {
				cafeCmd = cafeInCmd;
			}
			if (cafeCmd < 1 || cafeCmd > 2) {
				inputErr();
				cafeAction();
			} else {
				p1.printFreeMsg(WalkConstants.getCafeCmd(cafeCmd - 1));
				WalkMain.userCol--;
			}
			if (cafeCmd == 1) { cafeOrderAction(); }
		} catch (InputMismatchException ex) {
			inputErr();
			cafeAction();
		}
	}

//	カフェ(店)注文時の処理をするメソッド
	void cafeOrderAction() {
		p1.printCafeOrder();
		Scanner sc = new Scanner(System.in) ;
		try {
			int cafeOrderInCmd = sc.nextInt();
			switch (cafeOrderInCmd) {
				case 1:
					p1.printFreeMsg(WalkConstants.getCafeOrderCmd(cafeOrderInCmd - 1));
					System.out.println(cafeOrderInCmd);
					if (u1.getMoney() >= 500) {
						paymentAction(20,-500,30);
					} else {
						p1.printFreeMsg(WalkConstants.MONEYLOSEMSG);
					}
					break;
				case 2:
					p1.printFreeMsg(WalkConstants.getCafeOrderCmd(cafeOrderInCmd - 1));
					System.out.println(cafeOrderInCmd);
					if (u1.getMoney() >= 1000) {
						paymentAction(50,-1000,50);
					} else {
						p1.printFreeMsg(WalkConstants.MONEYLOSEMSG);
					}
					break;
				case 3:
					p1.printCafeStaff();
					int recoverHappiness = happinessUpDownUser(-10);
					p1.printHappinessDown(recoverHappiness);
					break;
				default:
					inputErr();
					cafeOrderAction();
					break;
			}
		} catch (InputMismatchException ex) {
			inputErr();
			cafeOrderAction();
		}
	}

//	支払いの処理をするメソッド
	void paymentAction(int hp,int money, int happiness) {
		p1.printPayment();
		Scanner sc = new Scanner(System.in) ;
		try {
			int paymentInCmd = sc.nextInt();
			int recoverHappiness;
			Random rand = new Random();
			switch (paymentInCmd) {
				case 1:
					p1.printFreeMsg(WalkConstants.getPaymentCmd(paymentInCmd - 1));
					int recoverHp = hpUpDownUser(hp);
					hpCheckUser();
					p1.printHpUp(recoverHp);
					recoverHappiness = happinessUpDownUser(happiness);
					p1.printHappinessUp(recoverHappiness);
					moneyUpDownUser(money);
					p1.printMoneyDown(money);
					break;
				case 2:
					p1.printFreeMsg(WalkConstants.getPaymentCmd(paymentInCmd - 1));
					recoverHp = hpUpDownUser(hp);
					hpCheckUser();
					p1.printHpUp(recoverHp);
					recoverHappiness = happinessUpDownUser(-20);
					p1.printHappinessDown(recoverHappiness);
					int num = rand.nextInt(2);
					if (num == 0) {
						p1.printFreeMsg(WalkConstants.ESCAPETRUEMSG);
					} else {
						p1.printFreeMsg(WalkConstants.ESCAPEFALSEMSG);
						WalkMain.userRow = WalkConstants.PRISONROW;
						WalkMain.userCol = WalkConstants.PRISONCOL;
						prisonAction();
					}
					break;
				default:
					inputErr();
					paymentAction(hp,money,happiness);
					break;
			}
		} catch (InputMismatchException ex) {
			inputErr();
			paymentAction(hp,money,happiness);
		}
	}

//	ホテル(宿)到着時の処理をするメソッド
	void hotelAction() {
		p1.printCmdMain(WalkConstants.HOTEL,"3");
		int hotelCmd;
		Scanner sc = new Scanner(System.in) ;
		try {
			int hotelInCmd = sc.nextInt();
			Random rand = new Random();
			if (hotelInCmd == 3) {
				hotelCmd = rand.nextInt(2) + 1;
			} else {
				hotelCmd = hotelInCmd;
			}
			if (hotelCmd < 1 || hotelCmd > 2) {
				inputErr();
				hotelAction();
			} else {
				p1.printFreeMsg(WalkConstants.getHotelCmd(hotelCmd - 1));
				WalkMain.userRow--;
			}
			if (hotelCmd == 1) {
				if (u1.getMoney() >= 2000) {
					paymentAction(WalkConstants.HPMAX,-2000,50);
				} else {
					p1.printFreeMsg(WalkConstants.MONEYLOSEMSG);
				}
			}
		} catch (InputMismatchException ex) {
			inputErr();
			hotelAction();
		}	}

//	宝くじ売り場(宝)到着時の処理をするメソッド
	void lotoAction() {
		p1.printCmdMain(WalkConstants.LOTO,"3");
		int lotoCmd;
		Scanner sc = new Scanner(System.in) ;
		try {
			int lotoInCmd = sc.nextInt();
			Random rand = new Random();
			if (lotoInCmd == 3) {
				lotoCmd = rand.nextInt(2) + 1;
			} else {
				lotoCmd = lotoInCmd;
			}
			if (lotoCmd < 1 || lotoCmd > 2) {
				inputErr();
				lotoAction();
			} else {
				p1.printFreeMsg(WalkConstants.getLotoCmd(lotoCmd - 1));
				WalkMain.userRow++;
			}
			switch (lotoCmd) {
				case 1:
					if (u1.getMoney() >= 1000) {
						moneyUpDownUser(-1000);
						int random = rand.nextInt(9);
						if (random == 0) {
							p1.printLotoResult(0,0);
						} else if (random == 1) {
							p1.printLotoResult(1,100000);
							moneyUpDownUser(100000);
						} else if (random == 2) {
							p1.printLotoResult(2,10000);
							moneyUpDownUser(10000);
						} else if (random > 2 && random < 6) {
							p1.printLotoResult(3,5000);
							moneyUpDownUser(5000);
						} else {
							p1.printLotoResult(4,1000);
							moneyUpDownUser(1000);
						}
					} else {
						p1.printFreeMsg(WalkConstants.MONEYLOSEMSG);
					}
					break;
			}
		} catch (InputMismatchException ex) {
			inputErr();
			lotoAction();
		}
	}

//	刑務所(刑)到着時の処理をするメソッド
	void prisonAction() {
		p1.printCmdMain(WalkConstants.PRISON,"3");
		int prisonCmd;
		Scanner sc = new Scanner(System.in) ;
		try {
			int prisonInCmd = sc.nextInt();
			Random rand = new Random();
			if (prisonInCmd == 3) {
				prisonCmd = rand.nextInt(2) + 1;
			} else {
				prisonCmd = prisonInCmd;
			}
			if (prisonCmd < 1 || prisonCmd > 2) {
				inputErr();
				prisonAction();
			} else {
				p1.printFreeMsg(WalkConstants.getPrisonCmd(prisonCmd - 1));
			}
			if (prisonCmd == 1) {
				p1.printEnding(WalkConstants.ENDINGMSG2,WalkConstants.ENDTITLE2);
				System.exit(0);
			} else {
				hpUpDownUser(-30);
				hpCheckUser();
				happinessUpDownUser(-100);
				int random = rand.nextInt(9) + 1;
				if (random < 3) {
					p1.printEnding(WalkConstants.ENDINGMSG3,WalkConstants.ENDTITLE3);
					System.exit(0);
				} else {
					p1.printEnding(WalkConstants.ENDINGMSG4,WalkConstants.ENDTITLE4);
					System.exit(0);
				}
			}
			System.exit(0);
		} catch (InputMismatchException ex) {
			inputErr();
			prisonAction();
		}
	}

// 主人公の体力を増減させるメソッド
	int hpUpDownUser(int hp) {
		int recoverHp = Math.min(WalkConstants.HPMAX - u1.getHp(), hp);
		u1.setHp(u1.getHp() + recoverHp);
		return recoverHp;
	}

// 主人公の体力を判定処理のメソッド
	void hpCheckUser() {
		if (u1.getHp() <= 0) {
			p1.printEnding(WalkConstants.ENDINGMSG1,WalkConstants.ENDTITLE1);
			System.exit(0);
		}
	}

// 主人公の幸福度を増減させるメソッド
	int happinessUpDownUser(int happiness) {
		int recoverHappiness = Math.min(WalkConstants.HPMAX - u1.getHappiness(), happiness);
		u1.setHappiness(u1.getHappiness()+ recoverHappiness);
		return recoverHappiness;
	}

// 主人公のお金を増減させるメソッド
	void moneyUpDownUser(int money) {
		int nowMoney = u1.getMoney() + money;
		u1.setMoney(nowMoney);
	}

// 結果判定の処理メソッド
	String walkResultCheck() {
		String walkResult = WalkConstants.ENDTITLE5;
		int happiness = u1.getHappiness();
		int money = u1.getMoney();
		if (money > 1000 && money < 5000) {
			happiness = happiness + 20;
		} else if (money >= 5000 && money < 10000) {
			happiness = happiness + 30;
		} else if (money >= 10000) {
			happiness = happiness + 50;
		}
		if (happiness < 20) {
			walkResult = WalkConstants.ENDTITLE5;
		} else if (happiness < 50) {
			walkResult = WalkConstants.ENDTITLE6;
		} else if (happiness < 80) {
			walkResult = WalkConstants.ENDTITLE7;
		} else if (happiness >= 80) {
			walkResult = WalkConstants.ENDTITLE8;
		}
		return walkResult;
	}

//	入力値エラーをコントロールするメソッド
	void inputErr() {
		errFlg = true;
		p1.printInputErr();
		System.out.println();
	}
}
