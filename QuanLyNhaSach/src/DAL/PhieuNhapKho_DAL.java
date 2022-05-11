/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.util.ArrayList;
import DTO.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author QUAN DO
 */
public class PhieuNhapKho_DAL {
    
    DBConnection connection;
    
    public ArrayList<PhieuNhapKho> danhsachPhieuNhap()
    {
        connection = new DBConnection();
        ArrayList<PhieuNhapKho> result = new ArrayList<PhieuNhapKho>();
        String query = "select * from PhieuNhapKho";
        System.out.println(query);
        try 
        {
            ResultSet rs = connection.ExcuteQueryGetTable(query);
            while (rs.next())
            {
                PhieuNhapKho phieunhap = new PhieuNhapKho();
                phieunhap.setMaPhieuNhap(rs.getString("MaPhieuNhap"));
                phieunhap.setMaNhaCC(rs.getString("MaNCC"));
                phieunhap.setMaTK(rs.getString("MaTK"));
                phieunhap.setNgayTaoPhieu(rs.getString("NgayTaoPhieu"));
                phieunhap.setNgayNhapKho(rs.getString("NgayNhapKho"));
                result.add(phieunhap);
            }
        }catch (SQLException e)
        {
            System.out.println("Null table");
        }
        return result;
    }
    
    public boolean addPhieuNhapKho(PhieuNhapKho phieunhap)
    {
        connection = new DBConnection();
        String query = "insert into PhieuNhapKho values('" + phieunhap.getMaPhieuNhap() + "', " + phieunhap.getMaNhaCC() + "', '" + phieunhap.getMaTK() + "', '" + phieunhap.getNgayTaoPhieu() + "', '" + phieunhap.getNgayNhapKho() + ")'";
        try {
            ResultSet rs = connection.ExcuteQueryUpdateDB(query);
            return true;
        } catch (Exception e) {
            System.err.println("Failed!");
            return false;
        }
    }
}
