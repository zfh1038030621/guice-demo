package com.zfh.binder;


import com.google.inject.servlet.ServletModule;
import com.zfh.servlet.TestServlet;

public class MyWebModule extends ServletModule {

    @Override
    protected void configureServlets() {
        //在这里可以完成完成加一些url绑定到我们的servlet上
        //原先这一部分实在web.xml里面配置的
        serve("/test").with(TestServlet.class);
    }
}
