package com.project.architect.userlogin;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class TestUtil {

    public static byte[] convertToByteArray(String username, String password) throws IOException {
        Map<String,String> arguments = new HashMap<>();
        arguments.put("username", username);
        arguments.put("password", password);

        StringJoiner sj = new StringJoiner("&");
        for(Map.Entry<String,String> entry : arguments.entrySet())
            sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "="
                    + URLEncoder.encode(entry.getValue(), "UTF-8"));
        return sj.toString().getBytes(StandardCharsets.UTF_8);
    }
}
