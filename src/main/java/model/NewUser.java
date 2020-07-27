package model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewUser {
private String email;
private String phoneNumber;
private String phoneCode;

}
