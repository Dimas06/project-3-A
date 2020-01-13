/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi;
// import bumbu-bumbu yang diperlukan

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


/**
 *
 * @author dimas_06
 */
public class Aplikasi {

           static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/cafe_anomali";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            // register driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                showMenu();
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertdaftarkopi();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    updatedaftarkopi();
                    break;
                case 4:
                    deletedaftarkopi();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showData() {
        String sql = "SELECT * FROM daftarkopi";

        try {
            rs = stmt.executeQuery(sql);
            
            System.out.println("+--------------------------------+");
            System.out.println("|    DATA KOPI DI CAFE_ANOMALI   |");
            System.out.println("+--------------------------------+");

              while(rs.next()){
           int id_kopi = rs.getInt("id_kopi");
                String nama = rs.getString("nama");
                String pengirim = rs.getString("pengirim");
                String penerima = rs.getString("penerima");
                String alamat = rs.getString("alamat");



            

                
                System.out.println(String.format("%d. %s. %s. %s. -- (%s)", id_kopi, nama, pengirim, penerima, alamat));
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    static void insertdaftarkopi() {
        try {
            // ambil input dari user
            System.out.print("id_kopi: ");
            String id_kopi = input.readLine().trim();
            System.out.print("nama: ");
            String nama = input.readLine().trim();
            System.out.print("Pengirim: ");
            String pengirim = input.readLine().trim();
            System.out.print("Penerima: ");
            String penerima = input.readLine().trim();
            System.out.print("alamat: ");
            String alamat = input.readLine().trim();
 
            // query simpan
            String sql = "INSERT INTO daftarkopi (id_kopi, nama, pengirim, penerima, alamat) VALUE('%s', '%s', '%s', '%s', '%s')";
            sql = String.format(sql,id_kopi, nama, pengirim, penerima, alamat);

            // simpan buku
            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    } 

    static void updatedaftarkopi() {
        try {
            
            // ambil input dari user
            System.out.print("ID yang mau diedit: ");
            int id_kopi = Integer.parseInt(input.readLine());
            System.out.print("Nama: ");
            String nama = input.readLine().trim();
            System.out.print("Pengirim: ");
            String pengirim = input.readLine().trim();
            System.out.print("Penerima: ");
            String penerima = input.readLine().trim();
            System.out.print("Alamat: ");
            String alamat = input.readLine().trim();

            // query update
            String sql = "UPDATE daftarkopi SET nama='%s', pengirim='%s', penerima='%s', Alamat='%s' WHERE id_kopi=%d";
            sql = String.format(sql, nama, pengirim, penerima, alamat, id_kopi);

            // update data daftarkopi
            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deletedaftarkopi() {
        try {
            
            // ambil input dari user
            System.out.print("ID yang mau dihapus: ");
            int iddaftarkopi = Integer.parseInt(input.readLine());
            
            // buat query hapus
            String sql = String.format("DELETE FROM daftarkopi WHERE id_kopi=%d", iddaftarkopi);

            // hapus data
            stmt.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



   

