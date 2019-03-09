
public class Tester {
    public static String  dates[] = new String[5];
    public static WeekDayAlgorithm wd = new WeekDayAlgorithm();

    public static void main(String[] args) {
        dates[0] = "12 March 2019";
        dates[1] = "13 March 2019";
        dates[2] = "04 February 2008";
        dates[3] = "27 November 2000";
        dates[4] = "22 June 1974";


        for(int i = 0;i<dates.length;i++){
            System.out.println("The day for " + dates[i] + " is ");
            System.out.println(wd.weekDay(dates[i]));
            System.out.println("____________________________________");

        }

    }
}
