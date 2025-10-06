import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;


public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        List <String> months = Arrays.asList("janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "oct", "novembre", "décembre");
        String monthName = months.get(dateTime.getMonthValue() - 1);
        return "Le " + dateTime.getDayOfMonth() + " " + monthName + ". de l'an " + dateTime.getYear() + " à " + dateTime.getHour() + "h" + dateTime.getMinute() + "m et " + dateTime.getSecond() + "s";
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) {
            return null;
        }
        List <String> months = Arrays.asList("gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "settembre", "ottobre", "novembre", "Dicembre");
        String monthName = months.get(date.getMonthValue() - 1);
        String year = date.getYear() + "";
        return monthName + " " + date.getDayOfMonth() + " " + year.substring(2, year.length());
    }

    public static String formatIso(LocalTime time) {
        if (time == null) {
            return null;
        }
        if (time.getNano() == 0) {
            return time.getHour() + ":" + time.getMinute() + ":" + time.getSecond();
        }
        
        return time.getHour() + ":" + time.getMinute() + ":" + time.getSecond() + "." + time.getNano();
    }
}
