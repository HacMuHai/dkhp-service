package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.HocKy;
import vn.edu.iuh.fit.enums.TrangThaiLHP;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lop_hoc_phans")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LopHocPhan  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLHP")
    private long id;
    private String tenLHP;
    private String namHoc;
    private HocKy hocKy;
    private TrangThaiLHP trangThaiLHP;

    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;

    @OneToMany(mappedBy = "lopHocPhan",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<LopTinChi> lopTinChis;

    @OneToMany(mappedBy = "lopHocPhan",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<SinhVien_LHP> sinhVienLhps;

    public LopHocPhan(String tenLHP, String namHoc, HocKy hocKy, TrangThaiLHP trangThaiLHP, MonHoc monHoc) {
        this.tenLHP = tenLHP;
        this.namHoc = namHoc;
        this.hocKy = hocKy;
        this.trangThaiLHP = trangThaiLHP;
        this.monHoc = monHoc;
    }
}
