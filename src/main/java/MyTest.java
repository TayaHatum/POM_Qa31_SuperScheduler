import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyTest {

    public static void main(String[] args) {
        String anyString = "Mozilla";
        System.out.println(anyString);


// Отобразит 'Moz'
        System.out.println(anyString.substring(0, 3));

// Отобразит 'lla'
        System.out.println(anyString.substring(4, 7));

// Отобразит 'Mozill'
        System.out.println(anyString.substring(0, 6));

// Отобразит 'Mozilla'
        System.out.println(anyString.substring(0, 7));



        String m = "MAY";
        m = m.toLowerCase();
        System.out.println("The month toLowerCase() --->" + m); //may
        m = m.substring(0, 1).toUpperCase() + m.substring(1);
        System.out.println("The month toUpperCase()  --->" + m); //May
        //**********************
        String dataInput = "24";
        // m  ---> May
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MMMM/yyyy");
        LocalDate inputFromApp =  LocalDate.parse(dataInput + "/" + m + "/2022", formatter);

        String date = "24/05/2022";
        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        if(inputFromApp.equals(inputDate)){
            System.out.println("It is equals");
        }else {
            System.out.println("It not is equals");
        }
    }

}
