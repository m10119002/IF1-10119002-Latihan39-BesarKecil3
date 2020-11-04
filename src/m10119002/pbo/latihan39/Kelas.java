/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m10119002.pbo.latihan39;

import java.util.Scanner;

/**
 *
 * @author
 * NAMA     : Firman Sahita
 * KELAS    : IF-1
 * NIM      : 10119002
 * Deskripsi Program : Class untuk objek Kelas
 * 
 * 
 */
public class Kelas {
    public String namaPetugas;
    public Mahasiswa[] dataMhs;
    
    private void masukkanNamaPetugas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama Petugas : ");
        namaPetugas = scanner.nextLine();
    }
    
    private Integer masukkanBanyakMahasiswa() {
        Integer banyakMhs_T;
        System.out.print("Masukkan Banyaknya Nilai Mahasiswa : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            banyakMhs_T = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            banyakMhs_T = null;
            System.err.println("ERROR: Pastikan Banyaknya Mahasiswa berupa Angka!");
        } catch (Exception ex) {
            banyakMhs_T = 0;
            System.err.println("ERROR: Terjadi Kesalahan Sistem!");
        }
        return banyakMhs_T;
    }
    
    private Integer masukkanNilaiMahasiswa(int nim) {
        Integer nilai_T;
        System.out.print("Masukkan Nilai Mahasiswa Ke-".
                concat(Integer.toString(nim)).concat(" = "));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            nilai_T = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            nilai_T = null;
            System.err.println("ERROR: Pastikan Nilai Mahasiswa berupa Angka!");
        } catch (Exception ex) {
            nilai_T = 0;
            System.err.println("ERROR: Terjadi Kesalahan Sistem!");
        }
        return nilai_T;
    }
    
    private void masukkanDataNilai() {
        Integer banyakMhs_T = masukkanBanyakMahasiswa();
        while (banyakMhs_T==null) {
            banyakMhs_T = masukkanBanyakMahasiswa();
        }
        if((banyakMhs_T==0) || (banyakMhs_T<0)) return;
        dataMhs = new Mahasiswa[banyakMhs_T];
        for (int i=0; i<banyakMhs_T; i++) {
            Mahasiswa mhs = new Mahasiswa();
            int nim = i+1;
            Integer nilai_T = masukkanNilaiMahasiswa(nim);
            while (nilai_T==null) {
                nilai_T = masukkanNilaiMahasiswa(nim);
            }
            mhs.nim = nim;
            mhs.nilai = nilai_T;
            dataMhs[i] = mhs;
        }
    }
    
    private String cariTerbesar() {
        Integer hasilTerbesar;
        if((dataMhs.length==0) || (dataMhs.length<0)) return null;
        hasilTerbesar = dataMhs[0].nilai;
        for(int i=1; i<dataMhs.length; i++) {
            if(hasilTerbesar<dataMhs[i].nilai) hasilTerbesar=dataMhs[i].nilai;
        }
        return Integer.toString(hasilTerbesar);
    }
    
    private String cariTerkecil() {
        Integer hasilTerkecil;
        if((dataMhs.length==0) || (dataMhs.length<0)) return null;
        hasilTerkecil = dataMhs[0].nilai;
        for(int i=1; i<dataMhs.length; i++) {
            if(hasilTerkecil>dataMhs[i].nilai) hasilTerkecil=dataMhs[i].nilai;
        }
        return Integer.toString(hasilTerkecil);
    }
    
    public void tampilHasil() {
        if((dataMhs.length==0) || (dataMhs.length<0)) return;
        System.out.println("=====Hasil Nilai Mahasiswa=====");
        for (int i=0; i<dataMhs.length; i++) {
            System.out.println("Nilai Mahasiswa Ke-".
                    concat(Integer.toString(dataMhs[i].nim)).concat(" = ").
                    concat(Integer.toString(dataMhs[i].nilai)));
        }
        System.out.println("");
        System.out.println("Nilai Terbesar adalah ".concat(cariTerbesar()));
        System.out.println("Nilai Terkecil adalah ".concat(cariTerkecil()));
        System.out.println("");
        System.out.println("Petugas : ".concat(namaPetugas));
    }
    
    public void mulai() {
        System.out.println("=====Program Nilai Terbesar dan "
                + "Terkecil Nilai Mahasiswa=====");
        masukkanNamaPetugas();
        masukkanDataNilai();
        System.out.println("");
        tampilHasil();
    }
}
