package vn.edu.iuh.fit.controllers;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.dto.ThongTinSVResponse;
import vn.edu.iuh.fit.enums.HocKy;
import vn.edu.iuh.fit.models.GiaoVien;
import vn.edu.iuh.fit.models.Khoa;
import vn.edu.iuh.fit.models.MonHoc;
import vn.edu.iuh.fit.models.SinhVien;
import vn.edu.iuh.fit.repositories.GiaoVienRepository;
import vn.edu.iuh.fit.repositories.KhoaRepository;
import vn.edu.iuh.fit.repositories.SinhVienRepository;
import vn.edu.iuh.fit.services.MonHocService;
import vn.edu.iuh.fit.services.SinhVienServices;
import vn.edu.iuh.fit.services.SinhVien_LHPService;
import vn.edu.iuh.fit.utils.GsonCustom;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/dkhp")
@RequiredArgsConstructor
public class DKHPController {

    private final SinhVienServices sinhVienServices;
    private final MonHocService monHocService;
    private final SinhVien_LHPService sinhVienLhpService;
    private final Gson gson = GsonCustom.getGsonCustom();
    private final long mssv = 1L;
    @GetMapping("")
    public String test() {
        return "Good";
    }

    @GetMapping("/thongTin")
    @ResponseStatus(HttpStatus.OK)
    public String getSinhVien() {
        ThongTinSVResponse thongTinSV = sinhVienServices.getThongTin(mssv);
        return gson.toJson(thongTinSV);
    }

    @GetMapping("/hocPhanChoDangKy")
    @ResponseStatus(HttpStatus.OK)
    public String getHPChoDK() {
        return gson.toJson(monHocService.getHPChoDK(mssv));
    }

    @GetMapping("/hocPhanDaDangKY")
    @ResponseStatus(HttpStatus.OK)
    public String getByNamHocAndHocKi(@RequestParam String namHoc,@RequestParam int hocKy) {
        return gson.toJson(sinhVienLhpService.getByNamHocAndHocKi(mssv,namHoc, HocKy.fromValue(hocKy)));
    }
}
