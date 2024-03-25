package Modul4;

import java.util.*;

class Barang {
    String nama;
    String brand;
    double harga;
    int stok;

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

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    // public double hargaJual(double faktorMarkup) {
    //     double hargaJual = this.harga * faktorMarkup; // Menghitung harga jual dengan faktor markup
        
    //     return hargaJual;
    // }

    // public double getHargaJual(double faktorMarkup) {
    //     return this.hargaJual(faktorMarkup);
    // }
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

    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    // Method menghitung profit per kasir
    public double hitungProfit(ArrayList<Barang> barangList) {
        double totalProfit = 0;
        for (Barang barang : barangList) {
            totalProfit += (barang.getHarga() - barang.getHarga()) * barang.getStok();
        }
        return totalProfit;
    }
    
    // Method untuk menghitung profit berdasarkan penjualan barang
    public double hitungProfitPenjualan(ArrayList<Barang> barangTerjual) {
        double totalProfit = 0;
        for (Barang barang : barangTerjual) {
            totalProfit += (barang.getHarga() - barang.getHarga()) * barang.getStok();
        }
        return totalProfit;
    }

    // Method menambah stok barang di setiap cabang
    public void tambahStok(ArrayList<Cabang> cabangList, String namaBarang, int tambahStok) {
        for (Cabang cabang : cabangList) {
            for (Barang barang : cabang.barangList) {
                if (barang.nama.equals(namaBarang)) {
                    barang.stok += tambahStok;
                    System.out.println("Stok " + barang.nama + " di cabang " + cabang.nama + " ditambah " + tambahStok);
                }
            }
        }
    }

    public void jualBarang(Barang barang, int jumlah) {
        if (barang.getStok() >= jumlah) {
            barang.setStok(barang.getStok() - jumlah); // Kurangi stok barang yang dijual
            double totalProfit = barang.getHarga() * jumlah;
            System.out.println("Penjualan berhasil. Keuntungan: " + totalProfit);
        } else {
            System.out.println("Stok tidak mencukupi untuk melakukan penjualan.");
        }
    }

}

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Inisialisasi Barang, Cabang, dan Kasir
        // Inisialisasi Barang
        Barang pakaianBarang = new Barang("Baju", "Dogmart", 50000, 100000);
        Barang makananBarang = new Barang("Tahu", "Pung", 10000, 20000);
        Barang elektronikBarang = new Barang("Laptop", "Gucci", 4000000, 5000000);

        // Inisialisasi Cabang
        ArrayList<Barang> barangPakaian = new ArrayList<>(Arrays.asList(pakaianBarang));
        ArrayList<Barang> barangMakanan = new ArrayList<>(Arrays.asList(makananBarang));
        ArrayList<Barang> barangElektronik = new ArrayList<>(Arrays.asList(elektronikBarang));

        // Cabang pakaianCabang = new Cabang("Pakaian", barangPakaian);
        // Cabang makananCabang = new Cabang("Makanan", barangMakanan);
        // Cabang elektronikCabang = new Cabang("Elektronik", barangElektronik);

        // Inisialisasi Kasir
        Kasir kasirAktif = null;
        Kasir kasir1 = new Kasir("John Doe", 25, "john_doe", "password123");
        Kasir kasir2 = new Kasir("Jane Smith", 30, "jane_smith", "hello123");

        System.out.println("Selamat datang!");
        System.out.println("Silakan login:");

        // Inisialisasi daftar cabang
        ArrayList<Cabang> daftarCabang = new ArrayList<>();
        daftarCabang.add(new Cabang("Cabang Makanan", barangMakanan));
        daftarCabang.add(new Cabang("Cabang Elektronik", barangElektronik));
        daftarCabang.add(new Cabang("Cabang Pakaian", barangPakaian));

        // Input username dan password
        System.out.print("Username: ");
        String inputUsername = scanner.next();
        System.out.print("Password: ");
        String inputPassword = scanner.next();

        // Proses login
        if (kasir1.login(inputUsername, inputPassword)) {
            System.out.println("Login berhasil sebagai " + kasir1.nama);
            kasirAktif = kasir1;
            // Tambahkan logika atau menu untuk Kasir 1
        } else if (kasir2.login(inputUsername, inputPassword)) {
            System.out.println("Login berhasil sebagai " + kasir2.nama);
            kasirAktif = kasir2;
            // Tambahkan logika atau menu untuk Kasir 2
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }

        if (kasirAktif != null) {
        int choice = -1;

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
                                
                        System.out.println("Profit Kasir " + cabang.getNama() + ": " + profitKasir);
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

        // Contoh penggunaan method untuk menghitung profit pe
        // Contoh penggunaan method untuk menambah stok barang di setiap cabang
        }
    }
}