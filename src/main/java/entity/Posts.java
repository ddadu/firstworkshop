package entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class Posts {
    private Integer postId;
    private String title;
    private  String body;
    private Integer userId;
    private Timestamp postData;
    private boolean delete;
}
