package com.seangogo.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sean on 2017/8/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DynamicUpdate
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
