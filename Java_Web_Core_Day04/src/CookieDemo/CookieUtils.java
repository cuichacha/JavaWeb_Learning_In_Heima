package CookieDemo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils{
    public static Cookie findCookie(String name, HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (name.equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
