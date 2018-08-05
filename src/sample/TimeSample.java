package sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Calendar cal = Calendar.getInstance();	//現在日時を保持したカレンダー
		cal.setTimeInMillis(System.currentTimeMillis());
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(cal.getTime());

		try {
			Method1();
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public static void Method1() throws ParseException {
        // 変換対象の日付文字列
        String date1Str = "20140101 01:02:04 005";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");

        // Date型変換
        Date date1 = sdf.parse(date1Str);

        System.out.println(sdf.format(date1));

        Date date2 = new GregorianCalendar(2016, 5 - 1, 2, 15, 0, 0).getTime();

        System.out.println(sdf.format(date2));

        long startTime =date1.getTime();
        long endTime = date2.getTime();

        long spanTime = endTime  - startTime;

    //NG    Date spanDate = new Date(spanTime);

        long days = spanTime / 86400000 ;
        long hours = 0;
        long minutes = 0;
        long seconds = 0;
        if(days > 0) {
        	System.out.println(days);
        }else {
        	System.out.println(days);
        }

        long in1DayMillis  = spanTime % 86400000;
        long in24HoursMillis = 0;
        long in60MinutesMillis = 0;
        long in1SecondMillis = 0;
        long millis = 0;


        if(in1DayMillis > 0) {
        	System.out.println(in1DayMillis);
            hours = in1DayMillis / 3600000;
            in24HoursMillis = in1DayMillis % 3600000;	//時間

            if(in24HoursMillis > 0) {
            	minutes = in24HoursMillis /  60000;
            	in60MinutesMillis = in24HoursMillis % 60000;

            	if(in60MinutesMillis > 0) {
            		seconds = in60MinutesMillis / 1000;
            		in1SecondMillis = in60MinutesMillis % 1000;

            		millis = in1SecondMillis;
            	}
            }
        }

		System.out.println("Method1 終了");
	}

}
