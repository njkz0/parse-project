package model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private Integer id;
    private String name;
    private String price;
    private String image;
    private int item_id;
}
