package com.zfh;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zfh.binder.BinderModule;
import org.junit.BeforeClass;
import org.junit.Test;

public class InitGuice {
    private static Injector injector;

    /*创建一个guice的容器*/
    @BeforeClass
    public static void init() {
        //Stage 的三种方式
        //TOOL（最小代价，有些功能会无法使用）
        //DEVELOPMENT（快速启动，但不会做校验）
        //PRODUCTION（，异常检能启动会比较查与性慢）
        //Guice.createInjector(Stage.PRODUCTION, new ModuleA());
        //Guice.createInjector(new ModuleA());//默认DEVELOPMENT

        injector = Guice.createInjector(
                new BinderModule()
                /*多个binder 写法*/
                //new BinderModuleA(),
                //new BinderModuleB()
        );
    }

    @Test
    public void test(){
        //使用注入器的getInstance方法获取目标类
        Application app = injector.getInstance(Application.class);
        app.test();
    }
}
