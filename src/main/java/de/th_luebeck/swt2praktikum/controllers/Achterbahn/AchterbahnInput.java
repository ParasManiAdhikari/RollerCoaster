package de.th_luebeck.swt2praktikum.controllers.Achterbahn;


import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class AchterbahnInput {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AchterbahnInput() {
    }

    public AchterbahnInput(String name){
        this.name = name;
    }

}
