package com.zfh;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.zfh.inter.LogService;

public class Application {
    private LogService logService;
    /*属性方式注入*/
   // @Inject
   // @Named("springEventService")
   // private LogService logService;

    //@Inject和@Named结合使用达到按名字注入，@Inject的optional默认为false，注入时如果依赖不存在，则报错停止，
    // 当使用@Inject(optional = true)时可达到忽然依赖是否存在的效果

    /*构造器依赖注入*/
    @Inject
    public  Application(@Named("log4j") LogService logService){
        this.logService = logService;
    }

    public void test(){
        logService.loginfo();
    }
}
