/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DAL.*;
import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 19522
 */
public class Sach_DAL {
    DBConnection connection;
    
    //All
    public ArrayList<Sach> getAllSach()
    {
        connection = new DBConnection();
        ArrayList<Sach> result = new ArrayList<Sach>();
        String query = "select * from Sach";
        System.out.println(query);
        try{
            ResultSet rs = connection.ExcuteQueryGetTable(query);
            while (rs.next()) {                
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTenTG(rs.getString("TenTacGia"));
                sach.setTenTheLoai(rs.getString("TenTheLoai"));
                sach.setSoLuong(rs.getInt("SoLuong"));
                sach.setGia(rs.getFloat("Gia"));
                result.add(sach);
            }
        }catch(SQLException e)
        {
            System.out.println("Null Table!");
        }
        return result;
    }
    
    //Search with Filter
    public ArrayList<Sach> searchSach(String name, String type, String author)
    {
        connection = new DBConnection();
        ArrayList<Sach> result = new ArrayList<Sach>();
        String query = "select * from Sach where TenSach like '%" + name + "%' or TenTheLoai like '%"+ type + "%' or TenTacGia like '%" + author +"%'";
        System.out.println(query);
        try{
            ResultSet rs = connection.ExcuteQueryGetTable(query);
            while (rs.next()) {                
                Sach sach = new Sach();
                sach.setMaSach(rs.getString("MaSach"));
                sach.setTenSach(rs.getString("TenSach"));
                sach.setTenTG(rs.getString("TenTacGia"));
                sach.setTenTheLoai(rs.getString("TenTheLoai"));
                sach.setSoLuong(rs.getInt("SoLuong"));
                sach.setGia(rs.getFloat("Gia"));
                result.add(sach);
            }
        }catch(SQLException e)
        {
            System.out.println("Null Table!");
        }
        return result;
    }
    
    //Add
    public boolean addSach(Sach sach)
    {
        connection = new DBConnection();
        String query = "insert into Sach values ('" + sach.getMaSach() + "','" + sach.getTenSach() + "','" + sach.getTenTG() + "','" + sach.getTenTheLoai() + "','" + sach.getSoLuong() + "','" + sach.getGia() + "')";
        System.err.println(query);
        try {
            ResultSet rs = connection.ExcuteQueryUpdateDB(query);
            return true;
        } catch (Exception e) {
            System.err.println("Failed!");
            return false;
        }
    }
    
    //Update
    public boolean updateSach(Sach sach)
    {
        connection = new DBConnection();
        String query = "update Sach set TenTacGia = '" + sach.getTenTG() + "', TenTheLoai = '" + sach.getTenTheLoai() + "', SoLuong = '" + sach.getSoLuong() + "', Gia = '" + sach.getGia() + "' where TenSach ='" +sach.getTenSach() + "'";
        System.err.println(query);
        try {
            ResultSet rs = connection.ExcuteQueryUpdateDB(query);
            return true;
        } catch (Exception e) {
            System.err.println("Failed!");
            return false;
        }
    }
    
    //Delete
    public boolean deleteSach(String maSach)
    {
        connection = new DBConnection();
        String query = "delete from Sach where MaSach = '" + maSach + "'";
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
