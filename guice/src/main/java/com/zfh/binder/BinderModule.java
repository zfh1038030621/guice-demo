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
        //Ĭ���Ƕ����������Ļ�ҪдSingleton������ֱ������ͷ��дע��@Singleton
        bind(LogService.class).annotatedWith(Names.named("slf4j"))
                .to(Slf4jLogServiceImpl.class).in(Singleton.class);
        bind(LogService.class).annotatedWith(Names.named("log4j"))
                .to(Log4jLogServiceImpl.class);

        //###################��һ��������##############################################
        //���������ֱ�Ϊ��1��Ҫ���ص���   2��Ҫ���صķ���  3������
        bindInterceptor(Matchers.any(),Matchers.any(),new LoggerAop());

        //######################���õ���������һ����ʽ##########################################

       // bind(LogService.class)
       //         .to(Log4jLogServiceImpl.class).in(Singleton.class);

        //####################ֱ��ע��һ��ʵ��#############################################

        /*bind(String.class)
                .annotatedWith(Names.named("JDBC URL"))
                .toInstance("jdbc:mysql://localhost/pizza");
        bind(Integer.class)
                .annotatedWith(Names.named("login timeout seconds"))
                .toInstance(10);*/

        //#####################������#################################################
        //namesע�ⳣ����--Ҳ������һ���ӿڶ��ʵ�ֵİ�
        //bindConstant().annotatedWith(Names.named("maxResults")).to(10);//�����ڰ���һ������

    }
//###############################################################################
    //��һ������ܸ��ӣ��޷�ʹ�ü򵥵Ĺ����������ɵ�ʱ��
    // ���ǿ���ʹ��@Provides������Ҳ������������������һ��ע����@Provides�ķ�����
    // �ڸ÷��������ǿ��Ա�д����������������
    //�ȷ�˵����һ������Դ
    //�е������� spring�е�@Bean

//    @Provides
//    TransactionLog provideTransactionLog() {
//        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
//        transactionLog.setJdbcUrl("jdbc:mysql://localhost/pizza");
//        transactionLog.setThreadPoolSize(30);
//        return transactionLog;
//    }
//    @Provides
    //Ĭ�������Guice����ÿ��ע���ʱ�򴴽�һ���¶��󡣣�������
    // ���ϣ������һ�����������Ļ���������ʵ������Ӧ��@Singletonע�⡣
//    @Singleton
//    public LogService getLogService(){
//        LogService service = new Log4jLogServiceImpl();
//        return  service;
//    }


}
