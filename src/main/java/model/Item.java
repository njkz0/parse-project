package model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Item {
    private String name;
    private String price;
    private String image;
    private String id;
}
