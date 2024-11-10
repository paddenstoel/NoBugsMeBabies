package me.nobugs.api.models;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Unicorn {
    private String name;
    private TailColor tailColor;
    @SerializedName("_id")
    private String id;
}
