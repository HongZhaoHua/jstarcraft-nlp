package com.jstarcraft.nlp.regulation;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class UrlTestCase {

    @Test
    public void testUrl() throws Exception {
        URL url = new URL("http://www.host.com:80/path/resource.html?key=value#fragment");
        System.out.println("URL是 " + url.toString());
        System.out.println("协议是 " + url.getProtocol());
        System.out.println("主机是 " + url.getHost());
        System.out.println("端口是 " + url.getPort());
        System.out.println("路径是 " + url.getPath());
        System.out.println("参数是 " + url.getQuery());
        System.out.println("片段是 " + url.getRef());
        System.out.println("默认端口号是 " + url.getDefaultPort());
    }

    @Test
    public void testRegular() {
        String regular = "^(?:([A-Za-z]+):)?(?:\\/{0,3})([0-9.\\-A-Za-z]+)(?::(\\d+))?(?:\\/([^?#]*))?(?:\\?([^#]*))?(?:#(.*))?$";
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher("http://127.0.0.1:80/path/resource.html?key=value#fragment");
        while (matcher.find()) {
            for (int group = 0, size = matcher.groupCount(); group <= size; group++) {
                System.out.println(matcher.group(group));
            }
        }
    }

}
