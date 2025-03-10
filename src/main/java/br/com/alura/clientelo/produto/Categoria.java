package br.com.alura.clientelo.produto;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
}
