public class WeekDayAlgorithm {
    public String weekDay[] = {"monday","tuesday","wednesday","thursday","friday","saturday"};
    public String month[] = {"January","Febraury","March","April","May","June","July","August","September","October","November","December"};
    public int year[] = new int[2099-1920];

    public static String weekDay(String date){
        String weekDay="";
        int numDay;
        int day  = defineDay(date);
        int month = defineMonth(date);
        int year = defineYear(date);

        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        if (month < 3)
            year -= 1;

       numDay = (year + year / 4 - year / 100 + year / 400 + t[month - 1] + day) % 7;
       switch (numDay){
           case 1 : weekDay= "Monday";
                break;
           case 2: weekDay= "Tuesday";
                break;
           case 3: weekDay= "Wednesday";
                break;
           case 4:weekDay= "Thursday";
                break;
           case 5: weekDay= "Friday";
                break;
           case 6: weekDay="Saturday";
                break;
           case 0:weekDay= "Sunday";
                break;
           default: weekDay= "Something went wrong";
                break;
       }
       return weekDay;
    }

    public static void main(String[] args) {
        System.out.println(weekDay("03 March 2019"));

    }

    private static int defineYear(String date){
        int year = 0;
        for(int i = date.length()-1, j =1;date.charAt(i)!=32;i--,j*=10){
            if(date.charAt(i)!=0x20){
                year = year+ Character.getNumericValue(date.charAt(i))*j;


            }
            else break;
        }
        return year;

    }

    private static int defineDay(String date){
        int day = 0;
        for(int i = 0, j =10;date.charAt(i)!=32;i++,j/=10){
            if(date.charAt(i)!=0x20){
                day = day+ Character.getNumericValue(date.charAt(i))*j;


            }
            else break;
        }
        return day;

    }

    private static int defineMonth(String date){
        int month = 0;

        String monthString= "";
        for(int i = 3;date.charAt(i)!=32;i++){
            if(date.charAt(i)!=0x20){
                monthString = monthString+ date.charAt(i);

            }
            else break;
        }

        switch (monthString){
            case "January": month = 1;
                break;
            case "Febraury": month = 2;
                break;
            case "March": month = 3;
                break;
            case "April": month =4;
                break;
            case "May": month = 5;
                break;
            case "June": month = 6;
                break;
            case "July": month = 7;
                break;
            case "August": month = 8;
                break;
            case "September": month =9;
                break;
            case "October": month = 10;
                break;
            case "November": month = 11;
                break;
            case "December": month = 12;
                break;
            default:month = 1;
        }
        return month;
    }





}
