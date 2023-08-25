import java.util.Scanner;

public class Kalkulator{

    public static void hitung(){
        Scanner inputObj = new Scanner(System.in);
        System.out.println("Masukkan angka pertama: ");
        float angkaSatu = inputObj.nextFloat();
        System.out.println('\n');
        System.out.println("Masukkan angka kedua: ");
        float angkaKedua = inputObj.nextFloat();
        System.out.println('\n');
        
        System.out.println("Pilih Operasi: " + '\n' + "1. Pertambahan" + '\n' + "2. Perkurangan" + '\n' + "3. Perkalian" + '\n' + "4. Pembagian");
        System.out.println('\n');

        int pilihan = inputObj.nextInt();

        switch (pilihan) {
            case 1:
                System.out.println(angkaSatu + angkaKedua);
                break;
            case 2:
                System.out.println(angkaSatu - angkaKedua);
                break;
            case 3:
                System.out.println(angkaSatu * angkaKedua);
                break;
            case 4:
                System.out.println(angkaSatu / angkaKedua);
                break;
            default:
                break;
        }
        System.out.println("Ulang aplikasi?" + '\n' + "(Y/N)");
        inputObj.nextLine();
        String ulang = inputObj.nextLine();
        if (ulang.equals("y")) {
            hitung();
        }else{
            inputObj.close();
        }
    }
    public static void main(String[] args) {
        hitung();
    }
}