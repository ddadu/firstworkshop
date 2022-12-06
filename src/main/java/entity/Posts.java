package entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Posts {
    private Integer id;
    private String title;
    private  String body;
    private Integer userId;
    private Timestamp create_data;
}
