package config;

public class WalkConstants {
//	ゲーム説明
	private static final String MANUAL0 = "＜ゲーム説明＞";
	private static final String MANUAL1 = "  主人公は自宅をスタート地点として散歩(移動)する";
	private static final String MANUAL2 = "  散歩で各拠点(公園・カフェ・ホテル・宝くじ)を巡り、幸福度を高めましょう";
	private static final String MANUAL3 = "  ※帰宅または、体力が0になったらゲーム終了です";
	private static final String MANUAL4 = "  ※散歩(移動)で体力を消耗します各拠点(公園・カフェ・ホテル・宝くじ)で体力回復、幸福度UP、お金GET";
	private static final String MANUAL5 = "  (初期値：体力は50(MAXは100)・幸福度は10(MAXは100)・お金は2000円)";
	private static final String MANUAL6 = "＜散歩(移動)方法＞";
	private static final String MANUAL7 = "  左に移動するキーボードの「h」を入力して「enter」押下";
	private static final String MANUAL8 = "  上に移動するキーボードの「j」を入力して「enter」押下";
	private static final String MANUAL9 = "  下に移動するキーボードの「k」を入力して「enter」押下";
	private static final String MANUAL10 = "  右に移動するキーボードの「l」を入力して「enter」押下";

	private static final String[] MANUAL = { MANUAL0,MANUAL1,MANUAL2,MANUAL3,MANUAL4,MANUAL5,"",
												MANUAL6,MANUAL7,MANUAL8,MANUAL9,MANUAL10 };
	public static String getManual(int index) { return MANUAL[index]; }

//	コマンド
	private static final String CMD1 = "散歩を開始する";
	private static final String CMD2 = "散歩を開始しない(今日はもう寝る。)";

	private static final String CMD3 = "おまかせ";

	private static final String CMD4 = "帰宅する";
	private static final String CMD5 = "まだ、散歩する";

	private static final String CMD6 = "ブランコで遊ぶ";
	private static final String CMD7 = "すべり台で遊ぶ";
	private static final String CMD8 = "砂場で遊ぶ";
	private static final String CMD9 = "遊ばない";

	private static final String CMD10 = "入店する";
	private static final String CMD11 = "入店しない";

	private static final String CMD12 = "コーヒーを注文する(\\500)";
	private static final String CMD13 = "ピザを注文する(\\1,000)";
	private static final String CMD14 = "注文しないで退店する";

	private static final String CMD15 = "支払い";
	private static final String CMD16 = "逃げる";

	private static final String CMD17 = "宿泊する(\\2,000)";
	private static final String CMD18 = "宿泊しない";

	private static final String CMD19 = "買う";
	private static final String CMD20 = "買わない";

	private static final String CMD21 = "刑期を務める";
	private static final String CMD22 = "脱獄する";
	public static final String CMD23 = ">:";

//	コマンド:散歩開始
	private static final String[] STARTCHECKCMD = { CMD1,CMD2 };
	public static String getStartCheckCmd(int index) { return STARTCHECKCMD[index]; }

//	コマンド:自宅(散歩終了(帰宅))
	private static final String[] HOMECMD = { CMD4,CMD5 };
	public static String getHomeCmd(int index) { return HOMECMD[index]; }

//	コマンド:公園
	private static final String[] PRAKCMD = { CMD6,CMD7,CMD8,CMD9,CMD3 };
	public static String getParkCmd(int index) { return PRAKCMD[index]; }

//	コマンド:カフェ①
	private static final String[] CAFECMD = { CMD10,CMD11,CMD3 };
	public static String getCafeCmd(int index) { return CAFECMD[index]; }

//	コマンド:カフェ②（注文）
	private static final String[] CAFEORDERCMD = { CMD12,CMD13,CMD14 };
	public static String getCafeOrderCmd(int index) { return CAFEORDERCMD[index]; }

//	コマンド:ホテル
	private static final String[] HOTELCMD = { CMD17,CMD18,CMD3 };
	public static String getHotelCmd(int index) { return HOTELCMD[index]; }

//	コマンド:宝くじ売り場
	private static final String[] LOTOCMD = { CMD19,CMD20,CMD3 };
	public static String getLotoCmd(int index) { return LOTOCMD[index]; }

//	コマンド:刑務所
	private static final String[] PRISONOFFICERCMD = { CMD21,CMD22,CMD3 };
	public static String getPrisonCmd(int index) { return PRISONOFFICERCMD[index]; }

//	コマンド:共通（支払い）
	private static final String[] PAYMENTCMD = { CMD15,CMD16 };
	public static String getPaymentCmd(int index) { return PAYMENTCMD[index]; }

//	コマンド:枠線
	public static final String FRAME1 = "################################################################################";
	public static final String FRAME2 = "# ";

//	コマンド:コロン
	public static final String COLON = " : ";

//	地図のサイズ
	public static final int MAPSIZE = 15;

//	拠点位置情報
	public static final int HOMEROW = 2;
	public static final int HOMECOL = 8;
	public static final int PARKROW = 2;
	public static final int PARKCOL = 10;
	public static final int CAFEROW = 4;
	public static final int CAFECOL = 13;
	public static final int HOTELROW = 12;
	public static final int HOTELCOL = 7;
	public static final int LOTOROW = 8;
	public static final int LOTOCOL = 5;
	public static final int PRISONROW = 13;
	public static final int PRISONCOL = 9;

//	拠点(※コマンドパターン含む)
	public static final String HOME = "＜自宅＞";
	public static final String PARK = "＜公園＞";
	public static final String CAFE = "＜カフェ＞";
	public static final String HOTEL = "＜ホテル＞";
	public static final String LOTO = "＜宝くじ売り場＞";
	public static final String PRISON = "＜刑務所＞";

//	メッセージ
	public static final String STARTCHECKMSG = "散歩ゲームを開始しますか？";
	public static final String USERNAMEINPUTMSG = "【主人公の名前を入力してください】";
	public static final String INPUTERRMSG = "正しい選択が行われませんでした。再度選択してください";
	public static final String INPUTERRMSG2 = "地図移動キーの入力に誤りがあります。正しい移動キーを入力してください";
	public static final String GOWALKMSG = " は散歩に出かけた！！ﾍ(*--)ﾉ！！";
	public static final String EXMSG = "例外が発生しました";
	public static final String DEADENDMSG = "！！壁！！（ドーン！！）行き止まりです";
	public static final String USERSTATUSMSG = "のステータス情報";
	public static final String HPMSG = "体力   : ";
	public static final String HAPPINESSMSG = "幸福度 : ";
	public static final String MONEYMSG = "所持金 : ";
	public static final String MONEYLOSEMSG = "...お金が足りなかった...";
	public static final String MOVEMSG = "は移動した";
	public static final String CAFESTAFFMSG = "(カフェ店員) ＞＞ ちっ！！ひやかしかよ！";
	public static final String ESCAPETRUEMSG = "支払いせずに逃げました！！成功！！";
	public static final String ESCAPEFALSEMSG = "支払いせずに逃げました！！..失敗..刑務所へ。。。";

	private static final String LOTORESULTMSG0 = "残念！ハズレ!";
	private static final String LOTORESULTMSG1 = "1等！当選金は ：";
	private static final String LOTORESULTMSG2 = "2等！当選金は ：";
	private static final String LOTORESULTMSG3 = "3等！当選金は ：";
	private static final String LOTORESULTMSG4 = "4等！当選金は ：";
	private static final String[] LOTORESULTMSG = { LOTORESULTMSG0,LOTORESULTMSG1,LOTORESULTMSG2,
													LOTORESULTMSG3,LOTORESULTMSG4 };
	public static String getLotoResultMsg(int index) { return LOTORESULTMSG[index]; }

//	エンディングメッセージ
	public static final String ENDTITLEMSG = "  【散歩ゲーム結果 - ＜称号＞ 】： ";
	public static final String ENDTITLE0 = "自宅警備員";
	public static final String ENDTITLE1 = "ノープラン人生";
	public static final String ENDTITLE2 = "牢獄の囚人";
	public static final String ENDTITLE3 = "脱獄囚";
	public static final String ENDTITLE4 = "死刑囚";
	public static final String ENDTITLE5 = "夢遊病の青年";
	public static final String ENDTITLE6 = "健康的な青年";
	public static final String ENDTITLE7 = "リア充な青年";
	public static final String ENDTITLE8 = "幸福な青年";

	public static final String ENDGAMEMSG = "散歩ゲーム終了";
	public static final String ENDINGMSG0 = "お家でゴロゴロ過ごしました...";
	public static final String ENDINGMSG1 = "体力がなくなりました..行き倒れ...＿|￣|○...";
	public static final String ENDINGMSG2 = "刑務所で一生過ごしました...＿|￣|○...";
	public static final String ENDINGMSG3 = "脱獄に成功しました...でも...脱獄囚...＿|￣|○...";
	public static final String ENDINGMSG4 = "脱獄に失敗しました...死罪...＿|￣|○...";
	public static final String ENDINGMSG5 = "帰宅しました。充実した日を過ごしました(*^-^*)";

//	ステータス情報のリテラル値
	public static final int MONEYINIT = 1000;
	public static final int HPMAX = 100;
	public static final int HPINIT = 50;
	public static final int HAPPINESSMAX = 100;
	public static final int HAPPINESSHPINIT = 10;

}
