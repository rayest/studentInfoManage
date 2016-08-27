package cn.rayest.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rayest on 2016/8/24 0024.
 */
public class ResponseUtil {
    public static void write(HttpServletResponse response,  Object object) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(object.toString());
        out.flush();
        out.close();
    }
}
