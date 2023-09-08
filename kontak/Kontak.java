import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Kontak extends BukuTelepon{

    Kontak(String email, String nama, String notelp) {
        super(email, nama, notelp);
    }
    public static void main(String[] args){
        Aplikasi startPoint = new Aplikasi("", "", "");
        try {
            FileInputStream fileInput = new FileInputStream("kontak.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            daftarTelp = (ArrayList<BukuTelepon>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
            System.out.println(daftarTelp);
        } catch (IOException | ClassNotFoundException e) {
        }
        startPoint.aplikasi();

    }

    public void kontak(){
         if(daftarTelp.size() > 0){
             for(int i = 0; i < daftarTelp.size(); i++){
                 email = daftarTelp.get(i).email;
                 nama = daftarTelp.get(i).nama;
                 notelp = daftarTelp.get(i).notelp;
                 System.out.println(String.format("%s, {email: %s, nama: %s, notelp: %s},", i + 1, email, nama, notelp));
             }
         }
        else{
            System.out.println("Tidak ada kontak terdaftar");
        }
    }
}
class Aplikasi extends Kontak{
    Scanner pilihan = new Scanner(System.in);
    Aplikasi(String email, String nama, String notelp) {
        super(email, nama, notelp);
    }
    
    public void aplikasi(){
        Kontak kontak = new Kontak("", "", "");
        
        System.out.println("");
        System.out.println("1. Tambah kontak");
        System.out.println("2. Tampilkan kontak");
        System.out.println("3. Hapus kontak");
        System.out.println("4. Tutup aplikasi");
        int pilih = pilihan.nextInt();
        System.out.println("");

        switch (pilih) {
            case 1:
                kontak.tambah();
                aplikasi();
                break;
            case 2:
                kontak.kontak();
                aplikasi();
                break;
            case 3:
                kontak.kontak();
                kontak.hapus();
                aplikasi();
                break;
            case 4:
                pilihan.close();
                inputKontak.close();
                kontak.save();
                break;
        
            default:
                break;
        }
    }
}
class BukuTelepon implements Serializable{
    public static ArrayList<BukuTelepon> daftarTelp = new ArrayList<>();
    String email;
    String nama;
    String notelp;
    transient Scanner inputKontak = new Scanner(System.in);
    BukuTelepon(String email,String nama, String notelp){
        this.nama = nama;
        this.email = email;
        this.notelp = notelp;
    }


    public void save(){
        try {
            FileOutputStream fileOutput = new FileOutputStream("kontak.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(daftarTelp);
            objectOutput.close();
            fileOutput.close();
            System.out.println("Daftar kontak berhasil disimpan!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan kontak." + e);
        }
    }
    public void tambah(){
        System.out.print("Masukkan email anda: ");
        String emailin = inputKontak.nextLine();
        System.out.print("Masukkan nama anda: ");
        String namain = inputKontak.nextLine();
        System.out.print("Masukkan nomor telepon anda: ");
        String notelpin = inputKontak.nextLine();
        
        daftarTelp.add(new BukuTelepon(emailin, namain, notelpin));
    }
    public void hapus(){
        if(daftarTelp.size() > 0){
            System.out.println("Kontak mana yang ingin dihapus? (Masukkan angka) ");
            int hapus = inputKontak.nextInt() - 1;
            if(hapus >= daftarTelp.size()){
                System.out.println("Pilihan tidak valid");
                hapus();
            }
            else{
                daftarTelp.remove(hapus);
                
                System.out.println("");
                System.out.println("Kontak terhapus");
            }
        }
        else{
            System.out.println("Tidak ada kontak terdaftar");
        }
    }
}
