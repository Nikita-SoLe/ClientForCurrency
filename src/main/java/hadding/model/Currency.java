package hadding.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
        private Integer id;
        private String name;
        private Integer  quantity;
        private Double currency;
        private String ost;
}
