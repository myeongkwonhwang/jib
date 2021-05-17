package com.j2kb.jibapi.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
@Data
public class Authority {
    @Id
    @Column(name = "authority_name", length = 50)
    private String name;
}
