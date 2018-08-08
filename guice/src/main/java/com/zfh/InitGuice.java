package com.zfh;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.zfh.binder.BinderModule;
import org.junit.BeforeClass;
import org.junit.Test;

public class InitGuice {
    private static Injector injector;

    /*����һ��guice������*/
    @BeforeClass
    public static void init() {
        //Stage �����ַ�ʽ
        //TOOL����С���ۣ���Щ���ܻ��޷�ʹ�ã�
        //DEVELOPMENT��������������������У�飩
        //PRODUCTION���쳣��������ܣ�������Ƚ�����
        //Guice.createInjector(Stage.PRODUCTION, new ModuleA());
        //Guice.createInjector(new ModuleA());//Ĭ��DEVELOPMENT

        injector = Guice.createInjector(
                new BinderModule()
                /*���binder д��*/
                //new BinderModuleA(),
                //new BinderModuleB()
        );
    }

    @Test
    public void test(){
        //ʹ��ע������getInstance������ȡĿ����
        Application app = injector.getInstance(Application.class);
        app.test();
    }
}
