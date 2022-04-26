/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

/**
 *
 * @author 19522
 */
public class PhieuNhapKho {
    private String maPhieuNhap;
    private Timestamp ngayNhapKho;
    private Timestamp ngayTaoPhieu;
    private String maTK;
    private String maNhaCC;

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public Timestamp getNgayNhapKho() {
        return ngayNhapKho;
    }

    public void setNgayNhapKho(Timestamp ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }

    public Timestamp getNgayTaoPhieu() {
        return ngayTaoPhieu;
    }

    public void setNgayTaoPhieu(Timestamp ngayTaoPhieu) {
        this.ngayTaoPhieu = ngayTaoPhieu;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getMaNhaCC() {
        return maNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        this.maNhaCC = maNhaCC;
    }
    
    
}
