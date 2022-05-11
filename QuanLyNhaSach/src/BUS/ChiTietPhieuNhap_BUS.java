/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.DBConnection;
import DTO.*;
import DAL.*;
import java.util.ArrayList;

/**
 *
 * @author QUAN DO
 */
public class ChiTietPhieuNhap_BUS {
    ChiTietPhieuNhap_DAL chitietphieunhap_DAL = new ChiTietPhieuNhap_DAL();
    
    public boolean addChiTietPhieuNhap(ChiTietPhieuNhap chitietnhap)
    {
        return chitietphieunhap_DAL.addChiTietPhieuNhap(chitietnhap);
    }
    
    ArrayList<ChiTietPhieuNhap> danhsachChiTietPhieuNhap(String manhap)
    {
        return chitietphieunhap_DAL.danhSachChiTietPhieuNhap(manhap);
    }
    
    public boolean deleteChiTietPhieuNhap(String manhap)
    {
        return chitietphieunhap_DAL.deleteChiTietPhieuNhap(manhap);
    }
    
}
