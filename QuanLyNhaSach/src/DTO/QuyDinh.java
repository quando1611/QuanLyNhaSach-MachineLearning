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
public class QuyDinh {
    private String maQuyDinh ;
    private Timestamp ngayCapNhatDate;
    private int soLuongSachConToiThieuDeNhap;
    private int soLuongSachNhapToiThieu;

    
    //call Getter & Setter
    public String getMaQuyDinh() {
        return maQuyDinh;
    }

    public void setMaQuyDinh(String maQuyDinh) {
        this.maQuyDinh = maQuyDinh;
    }

    public Timestamp getNgayCapNhatDate() {
        return ngayCapNhatDate;
    }

    public void setNgayCapNhatDate(Timestamp ngayCapNhatDate) {
        this.ngayCapNhatDate = ngayCapNhatDate;
    }

    public int getSoLuongSachConToiThieuDeNhap() {
        return soLuongSachConToiThieuDeNhap;
    }

    public void setSoLuongSachConToiThieuDeNhap(int soLuongSachConToiThieuDeNhap) {
        this.soLuongSachConToiThieuDeNhap = soLuongSachConToiThieuDeNhap;
    }

    public int getSoLuongSachNhapToiThieu() {
        return soLuongSachNhapToiThieu;
    }

    public void setSoLuongSachNhapToiThieu(int soLuongSachNhapToiThieu) {
        this.soLuongSachNhapToiThieu = soLuongSachNhapToiThieu;
    }
    
}
