/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.WeekOfSchedule;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Foxxy
 */
public class listDate {
     public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static List<WeekOfSchedule> list(String fromDate, String toDate, String endDate) {
        ArrayList<WeekOfSchedule> dates = new ArrayList<WeekOfSchedule>();
        try {
            Calendar fromCal = Calendar.getInstance();
            fromCal.setTime(dateFormat.parse(fromDate));
            Calendar toCal = Calendar.getInstance();
            toCal.setTime(dateFormat.parse(toDate));

            Calendar endCal = Calendar.getInstance();
            endCal.setTime(dateFormat.parse(endDate));

            while (!fromCal.after(endCal) && !toCal.after(endCal)) {
                dates.add(new WeekOfSchedule(fromCal.getTime(), toCal.getTime()));
                fromCal.add(Calendar.DATE, 7);
                toCal.add(Calendar.DATE, 7);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return dates;
    }
}
