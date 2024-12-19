package com.textprocessingscrum.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataCollection {


    private int id;
    private String data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataCollection dataCollection = (DataCollection) o;
        return id == dataCollection.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}