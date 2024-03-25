package Test;

import java.util.ArrayList;

class Jaket {
    private String bahan;

    public Jaket(String bahan) {
        this.bahan = bahan;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

}

class Pelanggan {
    private String nama;

    public Pelanggan(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

public class Test {
    public static void main(String[] args) {
        ArrayList<Jaket> jaketList = new ArrayList<>();
        jaketList.add(new Jaket("Katun"));
        jaketList.add(new Jaket("Kulit"));
        jaketList.add(new Jaket("Denim"));

        ArrayList<Pelanggan> pelangganList = new ArrayList<>();
        pelangganList.add(new Pelanggan("Budi"));
        pelangganList.add(new Pelanggan("Ani"));
        pelangganList.add(new Pelanggan("Cici"));

        // Menampilkan semua jaket
        for (Jaket jaket : jaketList) {
            System.out.println(jaket);
        }

        // Menampilkan semua pelanggan
        for (Pelanggan pelanggan : pelangganList) {
            System.out.println(pelanggan);
        }

        // Mencari jaket berdasarkan bahan
        String bahanDicari = "Kulit";
        Jaket jaketDitemukan = null;
        for (Jaket jaket : jaketList) {
            if (jaket.getBahan().equals(bahanDicari)) {
                jaketDitemukan = jaket;
                break;
            }
        }

        if (jaketDitemukan != null) {
            System.out.println("Jaket dengan bahan " + bahanDicari + " ditemukan: " + jaketDitemukan);
        } else {
            System.out.println("Jaket dengan bahan " + bahanDicari + " tidak ditemukan.");
        }
    }
}
