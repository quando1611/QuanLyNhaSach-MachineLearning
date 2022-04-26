/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.*;
import DAL.*;
import java.util.ArrayList;
/**
 *
 * @author 19522
 */
public class KhachHang_BUS {
    KhachHang_DAL khachHang_DAL = new KhachHang_DAL();
    
    public ArrayList<KhachHang> getAllKhachHang()
    {
        return khachHang_DAL.getAllKhachHang();
    }
    
    public ArrayList<KhachHang> seacrhKhachHang(String search)
    {
        return khachHang_DAL.searchKhachHang(search); 
    }
    
    public boolean addKhachHang(KhachHang khachHang)
    {
        return khachHang_DAL.addKhachHang(khachHang);
    }
}
