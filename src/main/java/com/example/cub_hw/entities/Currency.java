package com.example.cub_hw.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Currency {
    @Id
    @Column(name = "CODE_EN")
    private String codeEN;
    @Column(name = "CODE_CHN")
    private String codeCHN;

    public String getCodeEN() {
        return this.codeEN;
    }

    public void setCodeEN(String codeEN) {
        this.codeEN = codeEN;
    }

    public String getCodeCHN() {
        return this.codeCHN;
    }

    public void setCodeCHN(String codeCHN) {
        this.codeCHN = codeCHN;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "codeEN='" + codeEN + '\'' +
                ", codeCHN='" + codeCHN + '\'' +
                '}';
    }
}
