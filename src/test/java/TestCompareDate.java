import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by qyw on 2017/6/23.
 */
public class TestCompareDate {

    @Test
    public  void testDate() throws Exception{

        Calendar c = Calendar.getInstance();

        c.set(2016,5,4);
        Date before =c.getTime();

        c.set(2016,5,5);
        Date now=c.getTime();

        c.set(2016,5,6);
        Date after=c.getTime();

        //before早于now，返回负数，可用于判断活动开始时间是否到了
        int compareToBefore=before.compareTo(now);
        System.out.println("compareToBefore = "+compareToBefore);

        int compareToIntNow=now.compareTo(now);
        System.out.println("compareToIntNow = "+compareToIntNow);

        //after晚于now，返回正数，可用于判断活动结束时间是否到了
        int compareToIntAfter=after.compareTo(now);
        System.out.println("compareToIntAfter = "+compareToIntAfter);
    }
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
    }





    public static void main(String[] args)
    {
        String dateStr = "2015-1-1 21:21:28";
        String dateStr2 = "2015-1-2 1:21:28";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date date2 = format.parse(dateStr2);
            Date date = format.parse(dateStr);

            System.out.println("两个日期的差距：" + differentDays(date,date2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
