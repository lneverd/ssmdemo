package com.xiaow.ssmdemo.model;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NmBean {

    private Integer id;
    private Integer nid;
    private Integer mid;
    private Integer counts;

    private String medicine;
    private double price;
    private String logo;
    private String category;

    private double money;

    public NmBean(int nid, int mid, int counts) {
        this.nid = nid;
        this.mid = mid;
        this.counts = counts;
    }
}
