package com.accolite.learningRest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "message")
@Getter
@Setter
public class PrivateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String message;

    @Column
    private Timestamp createdTime;

    @ManyToOne
    @JsonIgnore
    private UserData user;

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }
}
