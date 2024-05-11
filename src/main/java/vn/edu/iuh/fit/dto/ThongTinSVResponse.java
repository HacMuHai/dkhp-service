package vn.edu.iuh.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.iuh.fit.enums.LoaiSinhVien;
import vn.edu.iuh.fit.models.LopHoc;
import vn.edu.iuh.fit.models.NganhHoc;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinSVResponse {
    private long mssv;
    private String hoTen;
    private LocalDate ngaySinh;
    private String urlImage;
    private String loaiSinhVien;
    private boolean isMale;
    private String khoaHoc;
    private String khoa;
    private long maLop;
    private String tenLop;
    private String loaiHinhDaoTao;
    private long maNganh;
    private String tenNganh;
}
