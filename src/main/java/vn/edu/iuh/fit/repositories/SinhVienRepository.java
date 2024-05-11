package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.SinhVien;
import vn.edu.iuh.fit.pks.SinhVien_LopHocPHanPK;

public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {
}