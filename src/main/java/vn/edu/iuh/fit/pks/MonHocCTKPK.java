package vn.edu.iuh.fit.pks;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Setter @Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MonHocCTKPK  implements Serializable {
    private long chuongTrinhKhung;
    private long monHoc;

}
