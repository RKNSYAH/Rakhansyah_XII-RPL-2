import java.util.Scanner;

public class TempConvert {
    public static void main(String[] args){
        Scanner celcius = new Scanner(System.in);
        System.out.println("Suhu celcius: ");

        int celc = celcius.nextInt();

        float fahreneit = (celc * 9/5) + 32;
        int kelvin = celc + 273;

        celcius.close();

        System.out.println("Fahrenheit : " + fahreneit + ", " + "Kelvin : " + kelvin);
    }
}