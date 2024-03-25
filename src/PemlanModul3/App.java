/* 
Adrian Ibrahim Putra Wirahmat
235150407111005
SI A
20-03-24
*/

package PemlanModul3;

// Buku
class Buku {
    private String judulBuku;
    private String penulis;
    private int tahunTerbit;

    public Buku(String judulBuku, String penulis, int tahunTerbit) {
        this.judulBuku = judulBuku;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    // Getter dan Setter untuk atribut Buku
    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
}

// Kategori
class Kategori {
    private String namaKategori;
    private Buku[] daftarBuku;
    private int jumlahBuku;

    public Kategori(String namaKategori, Buku[] daftarBuku) {
        this.namaKategori = namaKategori;
        this.daftarBuku = daftarBuku;
        this.jumlahBuku = daftarBuku.length;
    }

    // Getter untuk atribut Kategori
    public String getNamaKategori() {
        return namaKategori;
    }

    public Buku[] getDaftarBuku() {
        return daftarBuku;
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }

    // Method displayInfo() untuk menampilkan informasi buku dalam kategori
    public void displayInfo() {
        System.out.println("Kategori: " + namaKategori);
        System.out.println("Daftar Buku:");
        System.out.println("===================");

        for (Buku buku : daftarBuku) {
            System.out.println("Judul: " + buku.getJudulBuku());
            System.out.println("Penulis: " + buku.getPenulis());
            System.out.println("Tahun Terbit: " + buku.getTahunTerbit());
            System.out.println("-------------------");
        }
    }
}

public class App {
    public static void main(String[] args) {
        // Membuat objek Buku untuk setiap kategori
        Buku[] bukuTeknologi = {
            new Buku("Judul Buku Teknologi 1", "Penulis Teknologi 1", 2020),
            new Buku("Judul Buku Teknologi 2", "Penulis Teknologi 2", 2021),
            new Buku("Judul Buku Teknologi 3", "Penulis Teknologi 3", 2022)
        };
        
        Buku[] bukuSejarah = {
            new Buku("Judul Buku Sejarah 1", "Penulis Sejarah 1", 2018),
            new Buku("Judul Buku Sejarah 2", "Penulis Sejarah 2", 2019),
            new Buku("Judul Buku Sejarah 3", "Penulis Sejarah 3", 2020)
        };

        Buku[] bukuFilosofi = {
            new Buku("Judul Buku Filosofi 1", "Penulis Filosofi 1", 2066),
            new Buku("Judul Buku Filosofi 2", "Penulis Filosofi 2", 2420),
            new Buku("Judul Buku Filosofi 3", "Penulis Filosofi 3", 2069)
        };

        Buku[] bukuHukum = {
            new Buku("Judul Buku Hukum 1", "Penulis Hukum 1", 2077),
            new Buku("Judul Buku Hukum 2", "Penulis Hukum 2", 2011),
            new Buku("Judul Buku Hukum 3", "Penulis Hukum 3", 2008)
        };
        // Membuat objek Kategori untuk setiap kategori
        Kategori kategoriTeknologi = new Kategori("Teknologi", bukuTeknologi);
        Kategori kategoriSejarah = new Kategori("Sejarah", bukuSejarah);
        Kategori kategoriFilosofi = new Kategori("Filosofi", bukuFilosofi);
        Kategori kategoriHukum = new Kategori("Hukum", bukuHukum);



        System.out.println("Welcome to Perpustakaan Universitas Tadika Mesra");
        System.out.println("Ini Adalah Buku-buku Kami");
        System.out.println("===================");

        // Menampilkan informasi buku per kategori
        kategoriTeknologi.displayInfo();
        System.out.println();
        kategoriSejarah.displayInfo();
        System.out.println();
        kategoriFilosofi.displayInfo();
        System.out.println();
        kategoriHukum.displayInfo();

    }
}