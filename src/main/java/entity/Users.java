package entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Users {
    private Integer userid;
    private String username;
    private String password;
    private String email;
    private Timestamp create_data;
    private Boolean active;

}
