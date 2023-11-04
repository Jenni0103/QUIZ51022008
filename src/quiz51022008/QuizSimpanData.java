/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz51022008;

import java.io.File;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//metode simpan data diinput ke dalam file QUIZ51022008.dat
public class QuizSimpanData {
    public void Simpan(String nama,String nim,String tugas,String quiz,String MID,String FINAL,String total, String h,String lulus) {
    try {
            File file = new File("QUIZ51022008.dat");
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            String data=nama+":"+nim+":"+tugas+":"+quiz+":"+MID+":"+FINAL+":"+total+":"+h+":"+lulus+"\n";

            output.write(data);

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Metode ini untuk membaca data dari file "QUIZ51022008.dat" dan memasukkannya ke dalam objek DefaultTableModel agar data dapat tampil dalam bentuk tabel.
    public DefaultTableModel LihatNilai() {
        DefaultTableModel mahasiswa = new DefaultTableModel();
        mahasiswa.addColumn("No");
        mahasiswa.addColumn("Nama");
        mahasiswa.addColumn("NIM");
        mahasiswa.addColumn("Nilai Tugas");
        mahasiswa.addColumn("Nilai Quiz");
        mahasiswa.addColumn("Nilai MID");
        mahasiswa.addColumn("Nilai Final");
        mahasiswa.addColumn("Nilai Akhir");
        mahasiswa.addColumn("Nilai Huruf");
        mahasiswa.addColumn("Lulus/Tidak Lulus");

        try {
            File file = new File("QUIZ51022008.dat");
            BufferedReader input = new BufferedReader(new FileReader(file));
            
            String line;
            int nbaris = 1;

            while ((line = input.readLine()) != null) {
                String[] barisdata = line.split(":");
                mahasiswa.addRow(new Object[]{nbaris++, barisdata[0], barisdata[1], barisdata[2], barisdata[3], barisdata[4], barisdata[5], barisdata[6], barisdata[7], barisdata[8]});
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mahasiswa;
    }
}
    
