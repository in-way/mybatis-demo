

package com.batis.demo.config.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbps.webex.helper.JacksonHelper;
import com.gbps.webex.log.DefaultWebExLogHandler;
import com.gbps.webex.log.WebExLogHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

@Configuration
public class GbpsWebExConfigure implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (applicationContext == contextRefreshedEvent.getApplicationContext()) {
            try {
                RequestMappingHandlerAdapter adapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
                ObjectMapper objectMapper = applicationContext.getBean(ObjectMapper.class);
                changeObjectMapperInRequestMappingHandlerAdapter(adapter, objectMapper);
            } catch (Exception ex) {
                // expected
                //... do thing
                // ex.printStackTrace();
            }
        }
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = JacksonHelper.buildJsr310ObjectMapper();
        return objectMapper;
    }

    @Bean
    public ValidHandlerManager validMessageManager() {
        ValidHandlerRegistry registry = new ValidHandlerRegistry();
        registerValid(registry);

        ValidHandlerManager validMessageManager = new ValidHandlerManager();
        validMessageManager.init(registry);
        return validMessageManager;
    }

    @Bean
    public ExceptionHandlerManager exceptionHandlerManager() {
        ExceptionHandlerRegistry registry = new ExceptionHandlerRegistry();
        registerExceptions(registry);
        ExceptionHandlerManager exceptionHandlerManager = new ExceptionHandlerManager();
        exceptionHandlerManager.init(registry);
        return exceptionHandlerManager;
    }

    /**
     * ????????????webex???log?????????????????????????????????????????????????????????????????????
     * @return WebExLogHandler ????????????
     */
    @Bean
    public WebExLogHandler webExLogHandler() {
        return new DefaultWebExLogHandler();
    }

    /**
     * ??????????????????????????????
     * ???????????????????????????????????????????????????????????????
     * @return true????????????/false??????????????????
     */
    public boolean isDev() {
        return false;
    }

    /**
     * ???????????????Exception??????????????????????????????
     * @param registry ???????????????????????????registry???registerException?????????
     */
    protected void registerExceptions(ExceptionHandlerRegistry registry) {
        // default nothing...
    }

    /**
     * ???????????????valid??????????????????????????????
     * @param registry ?????????????????????????????????registry???registerValidTrans?????????
     */
    protected void registerValid(ValidHandlerRegistry registry) {
        // default nothing...
    }

    /**
     * ??????ObjectMapper ??? RequestMappingHandlerAdapter???
     * Spring4 ???????????????SpringBoot ????????????????????????Bean?????????
     */
    private void changeObjectMapperInRequestMappingHandlerAdapter(RequestMappingHandlerAdapter adapter, ObjectMapper objectMapper) {
        if (adapter == null) {
            return;
        }
        List<HttpMessageConverter<?>> messageConverters = adapter.getMessageConverters();
        if (messageConverters == null) {
            return;
        }
        for (HttpMessageConverter<?> converter : messageConverters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                ((MappingJackson2HttpMessageConverter) converter).setObjectMapper(objectMapper);
            }
        }
    }
}

