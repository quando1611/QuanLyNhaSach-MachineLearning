/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 19522
 */
public class KhachHang_DAL {
    DBConnection connection;
    
    //All
    public ArrayList<KhachHang> getAllKhachHang()
    {
        connection = new DBConnection();
        ArrayList<KhachHang> result = new ArrayList<KhachHang>();
        String query = "select * from KhachHang";
        System.out.println(query);
        try{
            ResultSet rs = connection.ExcuteQueryGetTable(query);
            while (rs.next()) {                
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setDienThoai(rs.getString("DienThoai"));
                khachHang.setEmail(rs.getString("Email"));
                khachHang.setSoSPDaMua(rs.getString("SoSPDaMua"));
                result.add(khachHang);
            }
        }catch(SQLException e)
        {
            System.out.println("Null Table!");
        }
        return result;
    }
    
    //Search
    public ArrayList<KhachHang> searchKhachHang(String search)
    {
        connection = new DBConnection();
        ArrayList<KhachHang> result = new ArrayList<KhachHang>();
        String query = "select * from KhachHang where MaKH like '%" + search + "%' or TenKH like '%" + search+ "%'";
        System.out.println(query);
        try{
            ResultSet rs = connection.ExcuteQueryGetTable(query);
            while (rs.next()) {                
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setDienThoai(rs.getString("DienThoai"));
                khachHang.setEmail(rs.getString("Email"));
                khachHang.setSoSPDaMua(rs.getString("SoSPDaMua"));
                result.add(khachHang);
            }
        }catch(SQLException e)
        {
            System.out.println("Null Table!");
        }
        return result;
    }
    
    public boolean addKhachHang(KhachHang khachHang)
    {
        connection = new DBConnection();
        String query = "insert into KhachHang values ('" + khachHang.getMaKH() + "','" +khachHang.getTenKH()+ "','" + khachHang.getDiaChi() + "','" + khachHang.getDienThoai() + "','" + khachHang.getEmail() + "','" +khachHang.getSoSPDaMua() + "')";
        System.err.println(query);
        try {
            ResultSet rs = connection.ExcuteQueryUpdateDB(query);
            return true;
        } catch (Exception e) {
            System.err.println("Failed!");
            return false;
        }
    }

    
}
