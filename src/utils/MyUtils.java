/**
 * MyUtils.java
 * 
 * All Rights Reserved.
 * Copyright(c) 2016 MinhNX.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;


public class MyUtils {


    private static final String YMD_FORMAT = "yyyy/MM/dd";

    /**
     * Default Constructor.
     */
    private MyUtils() {
    }

    /**
     * Hàm chuyển đối tượng Calendar thành xâu.<br>
     *
     * <pre>
     * Hàm thực hiện chuyển đổi đối tượng Calendar thành xâu kí tự biểu diễn thời gian.
     *
     * A Trình tự xử lý
     * 1. Kiểm tra đối tượng Calendar, nếu là null thì trả về xâu &quot;///&quot;.
     * 2. Nếu khác null thì xử lý đối tượng calendar
     *    2.1 Tạo đối tượng chứa xâu biểu diễn thời gian.
     *    2.2 Tách giá trị ngày, tháng, năm từ đối tượng Calendar và thêm vào xâu biểu diễn thời gian.
     *    2.3 Trả về xâu biểu diễn thời gian.
     * </pre>
     *
     * @param calendar Đối tượng Calendar.
     * @return Xâu biểu diễn đối tượng Calendar.
     */
    public static String toString(Calendar calendar) {

        // Trả về object Calendar là chuỗi ký tự có dạng "YYYY/MM/DD".
        if (calendar == null) {
            return "///";
        } else {
            // Khởi tạo đối tượng biểu diễn xâu thời gian.
            StringBuffer sbYMD = new StringBuffer();
            sbYMD.append(calendar.get(Calendar.YEAR));
            sbYMD.append("/");
            sbYMD.append(calendar.get(Calendar.MONTH) + 1);
            sbYMD.append("/");
            sbYMD.append(calendar.get(Calendar.DATE));
            return sbYMD.toString();
        }
    }

    /**
     * Hàm chuyển đổi thành đối tượng Calendar.<br>
     *
     * <pre>
     * Hàm thực hiện chuyển đổi xâu biểu diễn thời gian về dạng Calendar.
     *
     * ◆ Trình tự xử lý
     * 1. Tạo đối tượng Calendar.
     * 2. Xử lý xâu thời gian
     * 	  2.1 Lấy giá trị năm , ngày , tháng từ xâu thời gian.
     *    2.2 Set giá trị thời gian cho đối tượng Calendar.
     * 3. Trả về giá trị đối tượng Calendar.
     *
     * ◆ Xử lý Exception
     * . Nếu giá trị ngày, tháng, năm của xâu biểu diễn thời gian không ở định dạng số thì xảy ra NumberFormatException.
     *   Thực hiện in ra thông báo.
     * </pre>
     *
     * @param stringYMD Xâu biểu diễn thời gian.
     * @return Trả về đối tượng Calendar.
     */
    public static Calendar toCalendar(String stringYMD) {

        // Khởi tạo đối tượng Calendar.
        Calendar calendar = null;
        try {
            // Khởi tạo đối tượng chứa chuỗi định dạng "YYYY/MM/DD" của đối số.
            StringTokenizer stk = new StringTokenizer(stringYMD, "/");
            if (stk.countTokens() == 3) {

                // Khởi tạo biến chứa năm.
                int year = Integer.parseInt(stk.nextToken());

                // Khởi tạo biến chứa tháng.
                int month = Integer.parseInt(stk.nextToken()) - 1;

                // Khởi tạo biến chứa ngày.
                int day = Integer.parseInt(stk.nextToken());

                // Tạo định dạng cho đối tượng Calendar.
                calendar = Calendar.getInstance();

                // Set vào ngày tháng năm đã lấy.
                calendar.set(year, month, day);
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        // Trả về đối tượng calendar.
        return calendar;
    }

    /**
     * Hàm chuyển đổi thành đối tượng Calendar.<br>
     * 
     * <pre>
     * Hàm chuyển đổi một đối tượng thành đối tượng Calendar.
     * 
     * ◆ Trình tự xử lý
     * 1. Tạo đối tượng chứa kết quả chuyển đổi.
     * 2. Thực hiện chuyển đổi.
     * 3. Trả về kết quả sau chuyển đổi.
     * 
     * ◆ Xử lý Exception
     * . Nếu việc ép kiểu đối tượng về dạng java.sql.Timestamp bị lỗi thì xảy ra ClassCastException.
     *   Thực hiện in ra thông báo.
     * </pre>
     * 
     * @param object Đối tượng cần chuyển đổi.
     * @return Trả về đối tượng Calendar.
     */
    public static Calendar toCalendar(Object object) {

        // Khởi tạo đối tượng chứa kết quả chuyển đổi về dạng Calendar.
        Calendar calendar = null;

        // Thực hiện chuyển đổi.
        try {
            calendar = MyUtils.toCalendar(((java.sql.Timestamp) object)
                .toString());
        } catch (ClassCastException cc) {
            System.out.println(cc.getMessage());
        }

        // Trả về kết quả sau khi chuyển đổi.
        return calendar;
    }

    /**
     * Hàm kiểm tra thời gian hợp lệ.<br>
     * 
     * <pre>
     * Hàm kiểm tra xâu biểu diễn ngày tháng năm có đúng dạng theo yêu cầu không.
     * 
     * ◆ Trình tự xử lý
     * 1. Tạo đối tượng kiểm tra thời gian.
     * 2. Tạo đối tượng thể hiện định dạng thời gian yêu cầu.
     * 3. Thực hiện kiểm tra thời gian hợp lệ.
     * 
     * ◆ Xử lý Exception
     * . Nếu xâu biểu diễn thời gian không chuyển đổi được thành dạng hợp lệ thì xảy ra ParseException.
     *   Thực hiện in ra thông báo.
     * </pre>
     * 
     * @param stringYMD Xâu biểu diễn thời gian cần kiểm tra.
     * @return Trả về true nếu xâu thời gian ở đúng dạng yêu cầu. Trả về false nếu xâu thời gian không ở đúng dạng yêu
     *         cầu.
     */
    public static boolean isValidDate(String stringYMD) {

        // Khởi tạo biến kiểm tra thời gian.
        boolean isExactDate = false;

        // Khởi tạo biến định dạng ngày tháng.
        SimpleDateFormat dateFormat = new SimpleDateFormat(YMD_FORMAT);

        // Set định dạng ngày tháng không cho phép nhận giá trị không hợp lệ.
        dateFormat.setLenient(false);

        // Kiểm tra xâu thời gian có ở định dạng hợp lệ không.
        try {
            dateFormat.parse(stringYMD);
            isExactDate = true;
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        // Trả về kết quả kiểm tra.
        return isExactDate;
    }
}