package com.myplantdiary.enterprise.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data
class Plant {
    @SerializedName("id")
    private Integer id;
    @SerializedName("genus")
    private String genus;
    @SerializedName("species")
    private String species;
    @SerializedName("cultivar")
    private String cultivar;
    @SerializedName("common")
    private String common;
}
