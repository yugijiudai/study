package com.imooc.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.constants.DateConstant;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.text.SimpleDateFormat;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-11
 */
public class MyJsonConfig {

    public static FastJsonHttpMessageConverter getFastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(PrettyFormat);
        fastConvert.setFastJsonConfig(fastJsonConfig);
        return fastConvert;
    }



    public static MappingJackson2HttpMessageConverter getJackson2Date() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat(DateConstant.yyyMMddHHmmss));
        converter.setObjectMapper(mapper);
        return converter;
    }
}
