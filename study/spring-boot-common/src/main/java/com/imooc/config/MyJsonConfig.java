package com.imooc.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

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
}
