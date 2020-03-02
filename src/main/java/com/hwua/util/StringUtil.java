package com.hwua.util;

public class StringUtil {
    public static String replaceStr(String str) {
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        str = str.replaceAll(" ", "&nbsp;");
        return str;
    }
}
