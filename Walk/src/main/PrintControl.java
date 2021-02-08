package main;

import config.WalkConstants;

public class PrintControl {

//	マニュアル（遊び方）表示するメソッド
	void printManual() {
		for (int i = 0; i < 12; i++) {
			System.out.println(WalkConstants.getManual(i));
		}
		System.out.println();
	}

// 地図を表示するメソッド
	void printMap() {
		System.out.println();
		for (int i = 0; i < WalkConstants.MAPSIZE; i++) {
			for (int j = 0; j < WalkConstants.MAPSIZE; j++) {
				if (i == WalkMain.userRow && j == WalkMain.userCol) {
					System.out.print("●");
				} else if (WalkMain.wall[i][j]) {
					System.out.print("■");
				} else if (i == WalkConstants.HOMEROW && j == WalkConstants.HOMECOL) {
					System.out.print("家");
				} else if (i == WalkConstants.PARKROW && j == WalkConstants.PARKCOL) {
					System.out.print("公");
				} else if (i == WalkConstants.CAFEROW && j == WalkConstants.CAFECOL) {
					System.out.print("店");
				} else if (i == WalkConstants.HOTELROW && j == WalkConstants.HOTELCOL) {
					System.out.print("宿");
				} else if (i == WalkConstants.LOTOROW && j == WalkConstants.LOTOCOL) {
					System.out.print("宝");
				} else if (i == WalkConstants.PRISONROW && j == WalkConstants.PRISONCOL) {
					System.out.print("刑");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

//	メインコマンドを表示するメソッド
	void printCmdMain(String cmdPattern, String suffixMax) {
		int iMax = Integer.parseInt(suffixMax);
		System.out.println(WalkConstants.FRAME1);
		System.out.println(WalkConstants.FRAME2 + cmdPattern);
		System.out.println(WalkConstants.FRAME1);
		for (int i = 0; i < iMax; i++) {
			switch (cmdPattern) {
				case WalkConstants.STARTCHECKMSG:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getStartCheckCmd(i));
					break;
				case WalkConstants.HOME:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getHomeCmd(i));
					break;
				case WalkConstants.PARK:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getParkCmd(i));
					break;
				case WalkConstants.CAFE:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getCafeCmd(i));
					break;
				case WalkConstants.HOTEL:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getHotelCmd(i));
					break;
				case WalkConstants.LOTO:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getLotoCmd(i));
					break;
				case WalkConstants.PRISON:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getPrisonCmd(i));
					break;
				case WalkConstants.RANDOMEVENTMSG:
					System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getRandomCmd(i));
					break;
			}
		}
		System.out.println(WalkConstants.FRAME1);
		keyboardCmd();
	}

//	カフェ(注文時)のコマンドを表示するメソッド
	void printCafeOrder() {
		System.out.println(WalkConstants.FRAME1);
		for (int i = 0; i < 3; i++) {
			System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getCafeOrderCmd(i));
		}
		System.out.println(WalkConstants.FRAME1);
		keyboardCmd();
	}

//	カフェ(店員)のコメントを表示するメソッド
	void printCafeStaff() {
		System.out.println(WalkConstants.CAFESTAFFMSG);
	}

//	支払いのコマンドを表示するメソッド
	void printPayment() {
		System.out.println(WalkConstants.FRAME1);
		for (int i = 0; i < 2; i++) {
			System.out.println(WalkConstants.FRAME2 + (i + 1) + WalkConstants.COLON + WalkConstants.getPaymentCmd(i));
		}
		System.out.println(WalkConstants.FRAME1);
		keyboardCmd();
	}

//	コマンドを入力場所「>:」を表示するメソッド
	void keyboardCmd() {
		System.out.print(WalkConstants.CMD23);
	}

//	エンディングを表示するメソッド
	void printEnding(String endMsg, String endTitle) {
		System.out.println();
		System.out.println(endMsg);
		System.out.println();
		System.out.println(WalkConstants.ENDTITLEMSG + endTitle);
		System.out.println();
		System.out.println(WalkConstants.FRAME1);
		System.out.println(WalkConstants.FRAME2 + WalkConstants.ENDGAMEMSG);
		System.out.println(WalkConstants.FRAME1);
	}

//	宝くじの当選結果を表示するメソッド
	void printLotoResult(int LotoResult,int money) {
		System.out.println(WalkConstants.getLotoResultMsg(LotoResult) + money);
	}

//	コマンド選択結果を表示するメソッド
	void printFreeMsg(String freeMsg) {
		System.out.println(freeMsg);
		System.out.println();
	}

//	主人公の名前入力を表示するメソッド
	void printUserNameIn() {
		System.out.println();
		System.out.println(WalkConstants.USERNAMEINPUTMSG);
		keyboardCmd();
	}

//	主人公の名前を表示するメソッド
	void printUserName(String name) {
		System.out.println();
		System.out.println(name + WalkConstants.GOWALKMSG);
	}

//	主人公のステータス情報を表示するメソッド
	void printUserStatus(String name) {
		System.out.println();
		System.out.println(name + WalkConstants.USERSTATUSMSG);
	}
	void printUserStatus(int hp,int happiness,int money) {
		System.out.println(WalkConstants.HPMSG + hp);
		System.out.println(WalkConstants.HAPPINESSMSG + happiness);
		System.out.println(WalkConstants.MONEYMSG + money);
	}

//	Hpの回復を表示するメソッド
	void printHpUp(int hpUp) {
		System.out.println(WalkConstants.HPMSG + "+" + hpUp);
	}

//	Hpの消耗を表示するメソッド
	void printHpDown(int hpDown) {
		System.out.println(WalkConstants.HPMSG + hpDown);
	}

//	幸福度の増加を表示するメソッド
	void printHappinessUp(int happinessUp) {
		System.out.println(WalkConstants.HAPPINESSMSG + "+" + happinessUp);
	}

//	幸福度の減少を表示するメソッド
	void printHappinessDown(int happinessDown) {
		System.out.println(WalkConstants.HAPPINESSMSG + happinessDown);
	}

//	お金の増加を表示するメソッド
	void printMoneyUp(int moneyUp) {
		System.out.println(WalkConstants.MONEYMSG + "+" + moneyUp);
	}

//	お金の減少を表示するメソッド
	void printMoneyDown(int moneyDown) {
		System.out.println(WalkConstants.MONEYMSG + moneyDown);
	}

//	移動先が壁（行き止まり）を表示するメソッド
	void printDeadEnd() {
		System.out.println();
		System.out.println(WalkConstants.DEADENDMSG);
	}

//	コマンド選択の入力値エラーを表示するメソッド
	void printInputErr() {
		System.out.println();
		System.out.println(WalkConstants.INPUTERRMSG);
	}

//	地図移動の入力値エラーを表示するメソッド
	void printInputErr2() {
		System.out.println();
		System.out.println(WalkConstants.INPUTERRMSG2);
		for (int i = 7; i < 12; i++) {
			System.out.println(WalkConstants.getManual(i));
		}
		System.out.println();
	}
}
