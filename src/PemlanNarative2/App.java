/*
Adrian Ibrahim Putra Wirahmat
235150407111005
SI A
 */

package PemlanNarative2;

import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    String alamat;

    public Mahasiswa(String nim, String nama, String alamat) {
        this.nim = nim;
        this.nama = nama;
        this.alamat = alamat;
    }
}

public class App {

    public static void main(String[] a) {
        ArrayList<Mahasiswa> mahasiswas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean next = true;
        while (next) {
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan Alamat: ");
            String alamat = scanner.nextLine();

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, alamat);
            mahasiswas.add(mahasiswa);

            System.out.print("Tambah lagi? (y/n): ");
            String tambah = scanner.nextLine();

            if (!tambah.equalsIgnoreCase("y")) {
                next = false;
            }
        }

        for (Mahasiswa mahasiswa : mahasiswas) {
            System.out.println("====================================");
            System.out.printf("%-15s | %-10s | %-30s%n", mahasiswa.nama, mahasiswa.nim, mahasiswa.alamat);
            System.out.println("=====================================");
        }
        scanner.close();
    }
}