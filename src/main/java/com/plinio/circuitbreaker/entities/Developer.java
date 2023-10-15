package com.plinio.circuitbreaker.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Developer {
    @Id
    private String id;
    @JsonProperty("nome")
    private String name;
    @JsonProperty("apelido")
    private String nickName;
    @JsonProperty("nascimento")
    private String birthDate;
    @JsonProperty("stack")
    private ArrayList<String> stack;
}
