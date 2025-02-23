package vn.edu.iuh.fit.utils;

import com.google.gson.*;
import vn.edu.iuh.fit.dto.HocPhanResponse;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class GsonCustom {
    private static Gson gson;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder.registerTypeAdapter(HocPhanResponse.class, new HocPhanResponseSerializer());
        gson = gsonBuilder.setPrettyPrinting().create();
    }

    public static Gson getGsonCustom() {
        return gson;
    }

}

