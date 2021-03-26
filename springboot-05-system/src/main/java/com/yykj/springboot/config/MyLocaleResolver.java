package com.yykj.springboot.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 自定义国际化
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        // TODO: 1.获取默认地区信息对象
        Locale locale = Locale.getDefault();

        // TODO: 2.根据参数配置自定义地区信息
        String lang = request.getParameter("l");
        if(!StringUtils.isEmpty(lang)){
            String[] arr = lang.split("_");
            locale = new Locale(arr[0], arr[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
