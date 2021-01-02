package com.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "User")
public class User {
    @Id
    private int userId;
    private String userName;
    private String emailId;
    private String mobileNumber;
    private String createdOn;
    @LastModifiedDate
    private Date updatedOn;
    private UserStatus userStatus;
}
