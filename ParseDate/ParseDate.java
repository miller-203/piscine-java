import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        
        String res = new String();
        String tmp = new String();
        List mouth = Arrays.asList("january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december");
        if ((mouth.indexOf((stringDate.split(" ", 0)[2]).toLowerCase()) + 1) < 10 ) {
            tmp += "0" + (mouth.indexOf((stringDate.split(" ", 0)[2]).toLowerCase()) + 1);
        } else {
            tmp += mouth.indexOf(stringDate.split(" ", 0)[2]) + 1;            
        }
        res += stringDate.split(" ", 0)[3] + "-" + tmp + "-" + stringDate.split(" ", 0)[1];
        return  LocalDate.parse(res);
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null) {
            return null;
        }
        String hours = stringDate.split(",", 0)[0];
        String minutes = (stringDate.split(",", 0)[1]).split("and", 0)[0];
        String seconds = (stringDate.split(",", 0)[1]).split("and", 0)[1];
        String res = new String();
        String tmp = new String();
        for (int i = 1; i < hours.split(" ").length; i++) {
            tmp += hours.split(" ")[i] + " ";
        }
        tmp = tmp.trim();

        if (tmp.equals("hours in the evening")) {
            hours = Integer.parseInt(hours.split(" ", 0)[0]) + 12 + "";
        } else {
            hours = hours.split(" ", 0)[0];
        }
        res += hours + ":" + minutes.split(" ")[1] + ":" + seconds.split(" ")[1];
        return LocalTime.parse(res);
    }
}
