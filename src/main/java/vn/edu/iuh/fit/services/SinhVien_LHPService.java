package vn.edu.iuh.fit.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dto.LopHocPhanResponse;
import vn.edu.iuh.fit.enums.HocKy;
import vn.edu.iuh.fit.models.LopHocPhan;
import vn.edu.iuh.fit.models.SinhVien_LHP;
import vn.edu.iuh.fit.repositories.LopHocPhanRepository;
import vn.edu.iuh.fit.repositories.SinhVien_LHPRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SinhVien_LHPService {
    private final SinhVien_LHPRepository sinhVienLhpRepository;

    public List<LopHocPhanResponse> getByNamHocAndHocKi(long mssv, String namHoc, HocKy hocKy) {
        List<SinhVien_LHP> sinhVienLhps = sinhVienLhpRepository.findBySinhVien_IdAndLopHocPhan_NamHocAndLopHocPhan_HocKy(mssv, namHoc, hocKy);
        return sinhVienLhps.stream().map(this::mapToLopHocPhanResponse).toList();
    }

    private LopHocPhanResponse mapToLopHocPhanResponse(SinhVien_LHP sinhVienLhp) {
        return new LopHocPhanResponse(
                sinhVienLhp.getLopHocPhan().getId(),
                sinhVienLhp.getLopHocPhan().getMonHoc().getTenMon(),
                sinhVienLhp.getLopHocPhan().getTenLHP(),
                sinhVienLhp.getLopHocPhan().getMonHoc().getSoTC(),
                sinhVienLhp.getNhomTH(),
                2500000,//sinhVienLhp.getLopHocPhan().getHocPhi
                LocalDate.of(2023,3,1),
                LocalDate.of(2023,1,1),
                sinhVienLhp.getLopHocPhan().getTrangThaiLHP().name()
        );
    }
}
