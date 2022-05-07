/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.TaiKhoan_DAL;
import DTO.TaiKhoan;
import java.util.ArrayList;

/**
 *
 * @author 19522
 */
public class TaiKhoan_BUS {
    TaiKhoan_DAL taikhoan_DAL = new TaiKhoan_DAL();
    
   public ArrayList<TaiKhoan> getAllTaiKhoan()
    {
        return taikhoan_DAL.getAllTaiKhoan();
    }
    
    public ArrayList<TaiKhoan> searchTaiKhoan(String hoten, String email, int sdt )
    {
        return taikhoan_DAL.searchTaiKhoan(hoten, email, sdt);
    }
    
    public boolean addTaiKhoan(TaiKhoan taikhoan)
    {
        return taikhoan_DAL.addTaiKhoan(taikhoan);
    }
    
    public boolean  updateTaiKhoan(TaiKhoan taikhoan)
    {
        return taikhoan_DAL.updateTaiKhoan(taikhoan);
    }
    
    public boolean deleteTaiKhoan(String maTK)
    {
        return taikhoan_DAL.deleteTaiKhoan(maTK);
    }
    
}
