package Modul4v2;

import java.text.NumberFormat;
import java.util.*;

class Barang {
    String nama;
    String brand;
    double harga;
    int stok;
    int terjual;

    public Barang(String nama, String brand, int harga, int stok) {
        this.nama = nama;
        this.brand = brand;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setTerjual(int terjual) {
        this.terjual = terjual;
    }

    public int getTerjual() {
        return terjual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

}

class Cabang {
    String nama;
    ArrayList<Barang> barangList;

    public Cabang(String nama, ArrayList<Barang> barangList) {
        this.nama = nama;
        this.barangList = barangList;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Barang> getBarangList() {
        return barangList;
    }

    public void setBarangList(ArrayList<Barang> barangList) {
        this.barangList = barangList;
    }

    

    // Method untuk menampilkan informasi barang di cabang
    public void tampilkanInfoBarang() {
        System.out.println("Informasi Barang di Cabang " + nama + ":");
        for (Barang barang : barangList) {
            System.out.println("Nama: " + barang.nama);
            System.out.println("Stok: " + barang.stok);
            System.out.println("Harga: " + barang.harga);
            System.out.println("----------------------");
        }
    }
}

class Kasir {
    String nama;
    int umur;
    String username;
    String password;
    boolean isLog;

    public Kasir(String nama, int umur, String username, String password) {
        this.nama = nama;
        this.umur = umur;
        this.username = username;
        this.password = password;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLog(boolean logged) {
        this.isLog = logged;
    }

    public boolean isLog(){
        return isLog;

    }
    
    // Method untuk menghitung profit berdasarkan penjualan barang
    public double hitungProfit(ArrayList<Barang> barangList) {
        double totalProfit = 0;
        for (Barang barang : barangList) {
            totalProfit += barang.getHarga() * barang.getTerjual();
        }
        return totalProfit;
    }
    
    // Method untuk menghitung profit berdasarkan penjualan barang
    public double hitungProfitPenjualan(ArrayList<Barang> barangTerjual) {
        double totalProfit = 0;
        for (Barang barang : barangTerjual) {
            totalProfit += barang.getHarga() * barang.getTerjual();
        }
        return totalProfit;
    }
    public void jualBarang(Barang barang, int jumlah) {
        if (barang.getStok() >= jumlah) {
            barang.setStok(barang.getStok() - jumlah); // Kurangi stok barang yang dijual
            double totalProfit = barang.getHarga() * jumlah;
            NumberFormat kurensiUS = NumberFormat.getCurrencyInstance(Locale.US);
            System.out.println("Penjualan berhasil\nKeuntungan: " + kurensiUS.format(totalProfit));
        } else {
            System.out.println("Stok tidak mencukupi untuk melakukan penjualan.");
        }
    }

}

class Login {
    ArrayList<Kasir> kasirs;
    

    public Login() {
        kasirs = new ArrayList<>();
    }

    public void addKasir(String nama, int umur,String username, String password) {
        kasirs.add(new Kasir(nama, umur, username, password));
    }

    public boolean login(String username, String password) {
        for (Kasir kasir : kasirs) {
            if (kasir.getUsername().equals(username) && kasir.getPassword().equals(password)) {
               kasir.setLog(true);
                return true;
            }
        }
        return false;
    }
}


public class Main {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inisialisasi Cabang
        ArrayList<Barang> Pakaian = new ArrayList<>();
        ArrayList<Barang> Makanan = new ArrayList<>();
        ArrayList<Barang> Elektronik = new ArrayList<>();

        //Pakaian
        Pakaian.add(new Barang("Baju Tidur", "Dogmart", 50000, 100000));
        Pakaian.add(new Barang( "Bat Suit", "Ghotam Fashion", 100000, 500));
        Pakaian.add(new Barang( "Bat Suit", "Ghotam Fashion", 100000, 500));
        Pakaian.add(new Barang( "Bat Suit", "Ghotam Fashion", 100000, 500));
        Pakaian.add(new Barang( "Bat Suit", "Ghotam Fashion", 100000, 500));

        //Makanan
        Makanan.add(new Barang("batsnack", "nestle", 20000, 100));
        Makanan.add(new Barang("susu kelelawar", "cimory", 400000, 100));
        Makanan.add(new Barang("gedang batman", "cimory", 90000, 100));
        Makanan.add(new Barang("ting ting", "garuda", 10000, 100));
        Makanan.add(new Barang("penyetan wuhan", "purnama", 100000, 100));
        
        //Elektronik
        Elektronik.add(new Barang("Bat Mobile", "", 100000, 100));
        Elektronik.add(new Barang("Bat Cycle", "", 1000000, 100));
        Elektronik.add(new Barang("Bat Stunbat", "", 600000, 100));
        Elektronik.add(new Barang("Bat Map", "", 700000, 100));
        Elektronik.add(new Barang("Bat Hack", "", 9000000, 100));
        

        
        //inisisalisasi Login
        Login login = new Login();

        login.addKasir("Admin", 34, "admin", "admin123");
        login.addKasir("david", 14, "user2", "pass2");

        System.out.println("Selamat datang Wayne Enterprise");
        System.out.println("Silakan login:");
        System.out.println("=======================================================");

        // Inisialisasi daftar cabang
        ArrayList<Cabang> daftarCabang = new ArrayList<>();
        daftarCabang.add(new Cabang("Cabang Makanan", Makanan));
        daftarCabang.add(new Cabang("Cabang Elektronik", Elektronik));
        daftarCabang.add(new Cabang("Cabang Pakaian", Pakaian));

        // Inisialisasi Kasir
        Kasir kasirAktif = null;
        while (true) {
            System.out.print("masukan username: ");
            String username = scanner.nextLine();
            System.out.print("masukan password: ");
            String password = scanner.nextLine();

            if (login.login(username, password)) {
                System.out.println("Login successful!");
                break;
            } else {
                System.out.println(" username atau password salah.");
            }
        }

        for (Kasir kasir : login.kasirs) {
            if (kasir.isLog()) {
                kasirAktif = kasir;
                break;
            }
        }

        if (kasirAktif != null) {
        int choice = -1;
        System.out.println("=======================================================");
        System.out.println("WELCOME " + kasirAktif.getNama());

        while (choice != 0) {
            System.out.println("Menu:");
            System.out.println("1. Lihat Stok Barang");
            System.out.println("2. Penjualan");
            System.out.println("3. Tambah Stok Barang");
            System.out.println("4. Hitung Keuntungan");
            System.out.println("0. Logout");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Lihat Stok Barang
                    System.out.println("Pilih Cabang:");
                    // Tampilkan daftar cabang yang tersedia untuk dipilih
                    for (int i = 0; i < daftarCabang.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarCabang.get(i).getNama());
                    }
                    
                    System.out.print("Pilihan Anda: ");
                    int pilihanCabang = scanner.nextInt();
                    
                    if (pilihanCabang >= 1 && pilihanCabang <= daftarCabang.size()) {
                        Cabang cabangPilihan = daftarCabang.get(pilihanCabang - 1);
                        cabangPilihan.tampilkanInfoBarang(); // Memanggil method tampilkanInfoBarang() dari kelas Cabang
                    } else {
                        System.out.println("Pilihan Cabang tidak valid.");
                    }
                    break;
                    case 2:
                    // Penjualan
                    System.out.println("Pilih Cabang:");
                    // Tampilkan daftar cabang yang tersedia untuk dipilih
                    for (int i = 0; i < daftarCabang.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarCabang.get(i).getNama());
                    }
                    
                    System.out.print("Pilihan Cabang: ");
                    int pilihanCabangA = scanner.nextInt();
                    
                    if (pilihanCabangA >= 1 && pilihanCabangA <= daftarCabang.size()) {
                        Cabang cabangPilihan = daftarCabang.get(pilihanCabangA - 1);
                        cabangPilihan.tampilkanInfoBarang(); // Menampilkan info barang di cabang yang dipilih
                        System.out.print("Pilih Barang yang Akan Dijual: ");
                        int pilihanBarang = scanner.nextInt();
                        
                        if (pilihanBarang >= 1 && pilihanBarang <= cabangPilihan.getBarangList().size()) {
                            Barang barangDijual = cabangPilihan.getBarangList().get(pilihanBarang - 1);
                            System.out.print("Jumlah Barang yang Dijual: ");
                            int jumlah = scanner.nextInt();
                            
                            kasirAktif.jualBarang(barangDijual, jumlah); // Memproses penjualan
                            System.out.println();
                            barangDijual.setTerjual(jumlah);
                        } else {
                            System.out.println("Pilihan Barang tidak valid.");
                        }
                    } else {
                        System.out.println("Pilihan Cabang tidak valid.");
                    }
                    break;
                case 3:
                    System.out.println("Pilih Cabang untuk Menambah Stok Barang:");
                    for (int i = 0; i < daftarCabang.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarCabang.get(i).getNama());
                    }
                    
                    System.out.print("Pilihan Cabang: ");
                    int pilihanCabangTambahStok = scanner.nextInt();
                    
                    if (pilihanCabangTambahStok >= 1 && pilihanCabangTambahStok <= daftarCabang.size()) {
                        Cabang cabangPilihanTambahStok = daftarCabang.get(pilihanCabangTambahStok - 1);
                        
                        System.out.println("Pilih Barang untuk Menambah Stok:");
                        cabangPilihanTambahStok.tampilkanInfoBarang(); // Menampilkan info barang di cabang yang dipilih
                        
                        System.out.print("Pilih Barang: ");
                        int pilihanBarangTambahStok = scanner.nextInt();
                        
                        if (pilihanBarangTambahStok >= 1 && pilihanBarangTambahStok <= cabangPilihanTambahStok.getBarangList().size()) {
                            Barang barangTambahStok = cabangPilihanTambahStok.getBarangList().get(pilihanBarangTambahStok - 1);
                            
                            System.out.print("Jumlah Stok yang Akan Ditambah: ");
                            int jumlahTambahStok = scanner.nextInt();
                            
                            barangTambahStok.setStok(barangTambahStok.getStok() + jumlahTambahStok); // Menambah stok barang
                            
                            System.out.println("Stok " + barangTambahStok.getNama() + " di cabang " + cabangPilihanTambahStok.getNama() + " ditambah " + jumlahTambahStok);
                        } else {
                            System.out.println("Pilihan Barang tidak valid.");
                        }
                    } else {
                        System.out.println("Pilihan Cabang tidak valid.");
                    }
                    break;
                case 4:                
                    // Menghitung profit dari setiap cabang
                    for (Cabang cabang : daftarCabang) {
                        double profitKasir = kasirAktif.hitungProfit(cabang.getBarangList());
                         System.out.println("======================="+ "PROFIT" +"============================="); 
                         NumberFormat kurensiUS = NumberFormat.getCurrencyInstance(Locale.US);
                         System.out.printf("%s %s %n",cabang.getNama(), kurensiUS.format(profitKasir));                 
                         System.out.println();
                        
                    }                
                    break;
                case 0:
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
scanner.close();
        
        }
    }
}
