package com.userregistration;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class MongoUser {
    @Id
    private String id;

    private String email;
    private String name;
    private String gender;

   
}
