package com.xiaow.ssmdemo.model;


import com.xiaow.ssmdemo.utils.NotNull;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicineBean {

    private Integer id;
    @NotNull
    private String medicine;
    @NotNull
    private Double price;
    @NotNull
    private int num;
    private String logo;
    @NotNull
    private Integer cid;
    private String category;
}
