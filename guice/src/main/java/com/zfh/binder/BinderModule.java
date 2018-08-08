package com.zfh.binder;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;
import com.zfh.aop.LoggerAop;
import com.zfh.impl.Log4jLogServiceImpl;
import com.zfh.impl.Slf4jLogServiceImpl;
import com.zfh.inter.LogService;

public class BinderModule extends AbstractModule {
    protected void configure() {
        //默认是多例，单利的话要写Singleton，或者直接在类头部写注解@Singleton
        bind(LogService.class).annotatedWith(Names.named("slf4j"))
                .to(Slf4jLogServiceImpl.class).in(Singleton.class);
        bind(LogService.class).annotatedWith(Names.named("log4j"))
                .to(Log4jLogServiceImpl.class);

        //###################绑定一个拦截器##############################################
        //三个参数分别为：1你要拦截的类   2你要拦截的方法  3拦截器
        bindInterceptor(Matchers.any(),Matchers.any(),new LoggerAop());

        //######################设置单例的其中一个方式##########################################

       // bind(LogService.class)
       //         .to(Log4jLogServiceImpl.class).in(Singleton.class);

        //####################直接注入一个实例#############################################

        /*bind(String.class)
                .annotatedWith(Names.named("JDBC URL"))
                .toInstance("jdbc:mysql://localhost/pizza");
        bind(Integer.class)
                .annotatedWith(Names.named("login timeout seconds"))
                .toInstance(10);*/

        //#####################常量绑定#################################################
        //names注解常量绑定--也可用于一个接口多个实现的绑定
        //bindConstant().annotatedWith(Names.named("maxResults")).to(10);//类似于绑定了一个常量

    }
//###############################################################################
    //当一个对象很复杂，无法使用简单的构造器来生成的时候，
    // 我们可以使用@Provides方法，也就是在配置类中生成一个注解了@Provides的方法。
    // 在该方法中我们可以编写任意代码来构造对象。
    //比方说配置一个数据源
    //有点类似于 spring中的@Bean

//    @Provides
//    TransactionLog provideTransactionLog() {
//        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
//        transactionLog.setJdbcUrl("jdbc:mysql://localhost/pizza");
//        transactionLog.setThreadPoolSize(30);
//        return transactionLog;
//    }
//    @Provides
    //默认情况下Guice会在每次注入的时候创建一个新对象。（多例）
    // 如果希望创建一个单例依赖的话，可以在实现类上应用@Singleton注解。
//    @Singleton
//    public LogService getLogService(){
//        LogService service = new Log4jLogServiceImpl();
//        return  service;
//    }


}
