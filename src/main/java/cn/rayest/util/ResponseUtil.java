package cn.rayest.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class ResponseUtil {
    public static void write(HttpServletResponse response, JSONObject jsonObject) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(jsonObject.toString());
        out.flush();
        out.close();
    }
}
