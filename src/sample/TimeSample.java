package sample;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ryo_c
 *
 */
public class TimeSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Calendar cal = Calendar.getInstance();	//現在日時を保持したカレンダーよ
		cal.setTimeInMillis(System.currentTimeMillis());
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(cal.getTime());

		try {
			Method3_InsertOracle();
		} catch( Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void Method1() throws ParseException {

		//日付1
        String date1Str      = "20140102 01:02:04 005"; // 変換対象の日付文字列
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");
        Date date1 = sdf.parse(date1Str);

        //日付2
        //Date date2 = new GregorianCalendar(2016, 5 - 1, 2, 15, 0, 0,4).getTime();
        Date date2 = sdf.parse("20160402 15:00:00 024");

        //日付1出力
        System.out.println(sdf.format(date1));
        //日付2出力
        System.out.println(sdf.format(date2));

        //開始日時・終了日時のミリ数を取得
        long startTime =date1.getTime();
        long endTime = date2.getTime();

        long spanTime = endTime  - startTime;

    //NG    Date spanDate = new Date(spanTime);
        long days;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        long millis = 0;

        long remainDayMillis  = 0;
        long remainHourMillis = 0;
        long remainMinuteMillis = 0;
        long remainSecondMillis = 0;

        days = spanTime / 86400000 ;
        System.out.println(days);

        remainDayMillis =spanTime % 86400000;

        if(remainDayMillis > 0) {
        	System.out.println(remainDayMillis);
            hours = remainDayMillis / 3600000;
            remainHourMillis = remainDayMillis % 3600000;	//時間
        }

        if(remainHourMillis > 0) {
        	minutes = remainHourMillis /  60000;
        	remainMinuteMillis = remainHourMillis % 60000;
        }

    	if(remainMinuteMillis > 0) {
    		seconds = remainMinuteMillis / 1000;
    		remainSecondMillis = remainMinuteMillis % 1000;
    		millis = remainSecondMillis;
    	}

		System.out.println("Method1 終了");

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "osakada";

        PreparedStatement ps = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection(url, user, password);

	        Statement stmt = conn.createStatement();
	        String sql = "INSERT INTO xe.emp(id, name,update_dt,update_tm  VALUES (?,?,sysdate,systimest,amp)";
            //実行するSQL文とパラメータを指定する
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 5);
                ps.setString(2, "オレ");

//            java.util.Date d = new java.util.Date();
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date1);
//            cal.set(Calendar.YEAR, 1970);
//            cal.set(Calendar.MONTH, Calendar.JANUARY);
//            cal.set(Calendar.DATE, 1);
//            cal.set(Calendar.HOUR,2);
//            cal.set(Calendar.MINUTE,3);
//            cal.set(Calendar.SECOND,4);
//            cal.set(Calendar.MILLISECOND,5);
            String str = new SimpleDateFormat("yyyy-M-d").format(date1);

    //        java.sql.Date t1  = java.sql.Date.valueOf("2014-1-5");
          //  java.sql.Date t1 = new java.sql.Date(1900,1,1);
            java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
           java.sql.Date t1  = java.sql.Date.valueOf("2009-3-3");

           //t1 = java.sql.Date.valueOf(str);
            //t1.setTime(date1.getTime());

//            Calendar cal2 = Calendar.getInstance();
//            cal2.setTime(date2);
//            cal2.set(Calendar.YEAR, 1970);
//            cal2.set(Calendar.MONTH, Calendar.JANUARY);
//            cal2.set(Calendar.DATE, 1);
//            java.sql.Time t2 = new java.sql.Time(cal2.getTimeInMillis());

            ps.setDate(3, sqlDate);
//            ps.setTime(4, t2);

            int i = ps.executeUpdate();

            //処理件数を表示する
            System.out.println("結果：" + i);

	} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}

	}


	public static void Method2() throws ParseException {

		//日付1
        String date1Str      = "20140102 01:02:04 005"; // 変換対象の日付文字列
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");
        Date date1 = sdf.parse(date1Str);

        //日付2
        //Date date2 = new GregorianCalendar(2016, 5 - 1, 2, 15, 0, 0,4).getTime();
        Date date2 = sdf.parse("20160402 15:00:00 024");

        //日付1出力
        System.out.println(sdf.format(date1));
        //日付2出力
        System.out.println(sdf.format(date2));

        Calendar myCal1 = Calendar.getInstance();
        Calendar myCal2 = Calendar.getInstance();
        myCal1.setTime(date1);
        myCal2.setTime(date2);

        //開始日時・終了日時のミリ数を取得
        long startTime  = myCal1.getTimeInMillis();
        long endTime    = myCal2.getTimeInMillis();

        long spanTime = endTime  - startTime;

    //NG    Date spanDate = new Date(spanTime);
        long days;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        long millis = 0;

        long remainDayMillis  = 0;
        long remainHourMillis = 0;
        long remainMinuteMillis = 0;
        long remainSecondMillis = 0;

        days = spanTime / 86400000 ;
        System.out.println(days);

        remainDayMillis =spanTime % 86400000;

        if(remainDayMillis > 0) {
        	System.out.println(remainDayMillis);
            hours = remainDayMillis / 3600000;
            remainHourMillis = remainDayMillis % 3600000;	//時間
        }

        if(remainHourMillis > 0) {
        	minutes = remainHourMillis /  60000;
        	remainMinuteMillis = remainHourMillis % 60000;
        }

    	if(remainMinuteMillis > 0) {
    		seconds = remainMinuteMillis / 1000;
    		remainSecondMillis = remainMinuteMillis % 1000;
    		millis = remainSecondMillis;
    	}

		System.out.println("Method2 計算終了");

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user = "root";
        String password = "osakada";

        PreparedStatement ps = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection(url, user, password);

		    Calendar calendar = Calendar.getInstance();
		    calendar.set(2006, 4, 14, 9, 24, 32);
		    calendar.set(Calendar.MILLISECOND,515);

	        Statement stmt = conn.createStatement();
	        String sql = "INSERT INTO world.staticinfo(id, name, startTime,endTime,endTime2)  VALUES (?,?,?,?,?)";
            //実行するSQL文とパラメータを指定する
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 5);
            ps.setString(2, "オ");

            String str = new SimpleDateFormat("yyyy-M-d").format(date1);

        //    java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
            java.sql.Timestamp t1  = new java.sql.Timestamp(calendar.getTimeInMillis());
            java.sql.Timestamp t2  = new java.sql.Timestamp(calendar.getTimeInMillis());
            Calendar cal3 = Calendar.getInstance();
            Date dt3 = new java.util.Date();
            cal3.setTime(dt3);

            java.sql.Timestamp t3  = new java.sql.Timestamp(cal3.getTimeInMillis());

            ps.setTimestamp(3, t1);
            ps.setTimestamp(4, t2);
            ps.setTimestamp(5, t3);

            int i = ps.executeUpdate();

            //処理件数を表示する
            System.out.println("結果：" + i);

	} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
	}

	}


	/**
	 * @throws ParseException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static void Method3_InsertOracle() throws ParseException, SQLException, ClassNotFoundException {

		//日付1
        String date1Str      = "20140102 01:02:04 005"; // 変換対象の日付文字列
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");
        Date date1 = sdf.parse(date1Str);

        //日付2
        //Date date2 = new GregorianCalendar(2016, 5 - 1, 2, 15, 0, 0,4).getTime();
        Date date2 = sdf.parse("20160402 15:00:00 024");

        //日付1出力
        System.out.println(sdf.format(date1));
        //日付2出力
        System.out.println(sdf.format(date2));

        //開始日時・終了日時のミリ数を取得
        long startTime =date1.getTime();
        long endTime = date2.getTime();

        long spanTime = endTime  - startTime;

    //NG    Date spanDate = new Date(spanTime);
        long days;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        long millis = 0;

        long remainDayMillis  = 0;
        long remainHourMillis = 0;
        long remainMinuteMillis = 0;
        long remainSecondMillis = 0;

        days = spanTime / 86400000 ;
        System.out.println(days);

        remainDayMillis =spanTime % 86400000;

        if(remainDayMillis > 0) {
        	System.out.println(remainDayMillis);
            hours = remainDayMillis / 3600000;
            remainHourMillis = remainDayMillis % 3600000;	//時間
        }

        if(remainHourMillis > 0) {
        	minutes = remainHourMillis /  60000;
        	remainMinuteMillis = remainHourMillis % 60000;
        }

    	if(remainMinuteMillis > 0) {
    		seconds = remainMinuteMillis / 1000;
    		remainSecondMillis = remainMinuteMillis % 1000;
    		millis = remainSecondMillis;
    	}

		System.out.println("Method3 途中");

        Connection conn = null;

        String user = "system";
        String password = "osakada";

        PreparedStatement ps = null;
	    try {

	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,password);

	//        	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	//		    conn = DriverManager.getConnection(url, user, password);

		        Statement stmt = conn.createStatement();
		        String sql = "INSERT INTO emp(emp_id, mp_name, update_dt,update_tm) " +
		        	         "VALUES (?,?,?,?)";
//OK		                      "VALUES (?,?,sysDate,systimestamp)";
	            //実行するSQL文とパラメータを指定する"x);
	            String str = new SimpleDateFormat("yyyy-M-d").format(date1);

	    //        java.sql.Date t1  = java.sql.Date.valueOf("2014-1-5");
	          //  java.sql.Date t1 = new java.sql.Date(1900,1,1);
	            long curMillis = Calendar.getInstance().getTimeInMillis();
	            java.sql.Date sqlDate = new java.sql.Date(curMillis);
	            java.sql.Timestamp sqlTimeStamp =  new java.sql.Timestamp(curMillis);
//	            java.sql.Date sqlDate1 = new java.sql.Date(date1);
//	           java.sql.Date t1  = java.sql.Date.valueOf("2009-3-3");
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, 4);
	            ps.setString(2, "おいら");
	            ps.setDate(3, sqlDate);
	            ps.setTimestamp(4, sqlTimeStamp);

	            ps.executeUpdate();

	            String sql2 = "select seq_01.nextval from dual";
	            int seqno = 0;
	            ResultSet rs2 = stmt.executeQuery(sql2);
	            if(rs2.next()) {
	               seqno = rs2.getInt("nextval");
	            }
	            System.out.println("SEQNO:" + String.valueOf(seqno));


		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	/**
	 * @throws UnknownHostException
	 *
	 */
	public static void Method4() throws UnknownHostException {

        //オブジェクトを取得
        InetAddress ia = InetAddress.getLocalHost();
        String ip = ia.getHostAddress();       //IPアドレス
        String hostname = ia.getHostName();    //ホスト名

        //画面表示
        System.out.println("IPアドレス：" + ip);
        System.out.println("ホスト名：" + hostname);

	}

}
