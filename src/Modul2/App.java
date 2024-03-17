package Modul2;
/*
Nama : Adrian Ibrahim Putra Wirahmat (Ranoes Cops || David Martinez)
Nim : 235150407111005
Prodi : Sistem Informasi
Kelas : A
*/


import java.util.Scanner;

// Class Mahasiswa
class Mahasiswa {
    String nama;
    String nim;
    double ipk;
    String angkatan;
    String prodi;
    String status;

    //konstruktorrrrrrrr
    public Mahasiswa(String nama, String nim, double ipk) {
        this.nama = nama;
        this.nim = validateNIM(nim);
        this.ipk = validateIPK(ipk);
        this.angkatan = nim.substring(0, 2);
        this.prodi = getProdiName(Character.getNumericValue(nim.charAt(6)));
        this.status = getStatus();
    }

    private String validateNIM(String nim) {
        if (nim.length() != 15) {
            throw new IllegalArgumentException("NIM harus terdiri dari 15 angka.");
        }
        return nim;
    }

    private Double validateIPK(Double ipk) {
        if (ipk > 4) {
            throw new IllegalArgumentException("IPK Maksimal 4");
        }
        return ipk;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Angkatan: 20" + angkatan);
        System.out.println("Prodi: " + prodi);
        System.out.println("Status: " + status);
        System.out.println("===============================");
        System.out.println();
    }

    private String getProdiName(int prodiCode) {
        switch (prodiCode) {
            case 2:
                return "Teknik Meniup Gelembung";
            case 3:
                return "Teknik Berburu Ubur-Ubur";
            case 4:
                return "Sistem Perhamburgeran";
            case 6:
                return "Pendidikan Chumbucket";
            case 7:
                return "Teknologi Spatula";
            default:
                return "Prodi tidak ditemukan";
        }
    }
    private String getStatus() {
        if ((prodi.equals("Teknik Meniup Gelembung") || prodi.equals("Teknik Berburu Ubur-Ubur")) && ipk >= 3.5) {
            return "Diterima di Beasiswa Salty Spitoon";            
        } else if ((prodi.equals("Sistem Perhamburgeran") || prodi.equals("Pendidikan Chumbucket") || prodi.equals("Teknologi Spatula")) && ipk >= 3.5) {
            return "Diterima di Beasiswa Kotak Imajinasi";
        } else if ((prodi.equals("Teknik Meniup Gelembung") || prodi.equals("Teknik Berburu Ubur-Ubur")) && ipk < 3.5) {
            return "Tidak Diterima di Beasiswa Salty Spitoon";
        } else if ((prodi.equals("Sistem Perhamburgeran") || prodi.equals("Pendidikan Chumbucket") || prodi.equals("Teknologi Spatula")) && ipk < 3.5) {
            return "Tidak Diterima di Beasiswa Kotak Imajinasi";
        } else {
            return "Tidak ada";
        }
    }

}

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Mahasiswa[] mahasiswas = new Mahasiswa[3];
        // 5 Mhasiswa
        for (int i = 0; i < 3; i++) {
            
            boolean validator = false;
            //Mahasiswa mahasiswa = null; //deklarasi outer loop, gk ada work2 aja :v

            while (!validator) {
                try {
                System.out.println("Masukkan data mahasiswa ke-" + (i + 1) + ":");
                System.out.print("Nama: ");
                String nama = input.nextLine();
                System.out.print("Nim: ");
                String nim = input.nextLine();
                System.out.print("Ipk: ");
                double ipk = input.nextDouble();
                input.nextLine();
                
                mahasiswas[i] = new Mahasiswa(nama, nim, ipk);
                validator = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("===============================");
            System.out.println("Data Mahasiswa ke-" + (i + 1) + ":");
            mahasiswas[i].displayInfo();
        }
        /*
        for (Mahasiswa mahasiswa : mahasiswas) {
            mahasiswa.displayInfo();
        }
        */
        input.close();
        }
    }
