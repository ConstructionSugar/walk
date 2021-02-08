package main;

import java.util.Scanner;

import config.WalkConstants;

public class WalkMain {

	static PrintControl p1 = new PrintControl();
	static 	ActionControl a1 = new ActionControl();

	static boolean[][] wall;

	static int userRow = WalkConstants.HOMEROW;
	static int userCol = WalkConstants.HOMECOL;

	public static void main(String[] args) {

		wall = new boolean[WalkConstants.MAPSIZE][WalkConstants.MAPSIZE];

		a1.openingAction();

		createMap();

		while (true) {
			p1.printMap();
			a1.PrintUserStatus();

			Scanner sc = new Scanner(System.in);
			String moveKeys = "";
			char moveKey;
			try {
				moveKeys = sc.next();
				moveKey = moveKeys.charAt(moveKeys.length() - 1);
				a1.moveUsr(moveKey);

				if (userRow == WalkConstants.HOMEROW && userCol == WalkConstants.HOMECOL) {
					a1.goHomeAction();
				} else if (userRow == WalkConstants.PARKROW && userCol == WalkConstants.PARKCOL) {
					a1.parkAction();
				} else if (userRow == WalkConstants.CAFEROW && userCol == WalkConstants.CAFECOL) {
					a1.cafeAction();
				} else if (userRow == WalkConstants.HOTELROW && userCol == WalkConstants.HOTELCOL) {
					a1.hotelAction();
				} else if (userRow == WalkConstants.LOTOROW && userCol == WalkConstants.LOTOCOL) {
					a1.lotoAction();
				} else if (userRow == WalkConstants.PRISONROW && userCol == WalkConstants.PRISONCOL) {
					a1.prisonAction();
				} else {
					a1.randomAction();
				}
			} catch (Exception ex) {
				System.out.println("例外が発生しました");
				System.out.println(ex);
				sc.close();
				System.exit(0);
			}
		}
	}

// 地図を作成するメソッド
	static void createMap() {
		// 初期化
		for (int i = 0; i < WalkConstants.MAPSIZE; i++) {
			for (int j = 0; j < WalkConstants.MAPSIZE; j++) {
				wall[i][j] = true;
			}
		}
		// 道路の作成
		for (int i = 1; i < WalkConstants.MAPSIZE-1; i++) {
			for (int j = 1; j < WalkConstants.MAPSIZE-1; j++) {
				switch (i) {
					case 1:
						wall[i][j] = false;
						break;
					case 2:
						if (j == 1 || j == 5 || j == 8 || j == 10 || j == 12 ) {wall[i][j] = false;}
						break;
					case 3:
						if (j == 1 || j == 2 || j == 5 || j == 12 ) {wall[i][j] = false;}
						break;
					case 4:
						if (j == 2 || j > 4 ) {wall[i][j] = false;}
						break;
					case 5:
						if (j == 2 || j == 5 || j == 12 ) {wall[i][j] = false;}
						break;
					case 6:
						if (j == 2 || j > 3 && j < 11 || j == 12 || j == 13) {wall[i][j] = false;}
						break;
					case 7:
						if (j == 2 || j == 9 || j == 13 ) {wall[i][j] = false;}
						break;
					case 8:
						if (j == 2 || j == 5 || j == 9 || j == 12 || j == 13 ) {wall[i][j] = false;}
						break;
					case 9:
						if (j == 2 || j > 3 && j < 13) {wall[i][j] = false;}
						break;
					case 10:
						if (j == 1 || j == 2 || j == 5 || j == 10 ) {wall[i][j] = false;}
						break;
					case 11:
						if (j == 1 || j > 4 && j <13 ) {wall[i][j] = false;}
						break;
					case 12:
						if (j < 6 || j == 7 || j == 12 ) {wall[i][j] = false;}
						break;
					case 13:
						if (j == 1 || j == 9 || j > 11 ) {wall[i][j] = false;}
						break;
				}
			}
		}
	}
}
