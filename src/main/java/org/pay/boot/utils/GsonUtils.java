package org.pay.boot.utils;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/11/24 9:01
 */
public class GsonUtils {

    private static Gson gson;
    {
         gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setPrettyPrinting()
                .create();
    }

    public static Gson wxTrans(){
        return gson;
    }

}
