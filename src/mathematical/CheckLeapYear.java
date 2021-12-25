package mathematical;

/**
 * Output :
 * 1997 : is NOT a leap year
 * 2000 : is a leap year
 * 2012 : is a leap year
 * 2014 : is NOT a leap year
 */
public class CheckLeapYear {
    public static void main(String[] args) {
        CheckLeapYear.isLeapYear(1997);
        CheckLeapYear.isLeapYear(2000);
        CheckLeapYear.isLeapYear(2012);
        CheckLeapYear.isLeapYear(2014);
    }

    public static void isLeapYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
            System.out.println(year + " : is a leap year");
        else
            System.out.println(year + " : is NOT a leap year");
    }
}
