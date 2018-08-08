package com.zfh;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.zfh.inter.LogService;

public class Application {
    private LogService logService;
    /*���Է�ʽע��*/
   // @Inject
   // @Named("springEventService")
   // private LogService logService;

    //@Inject��@Named���ʹ�ôﵽ������ע�룬@Inject��optionalĬ��Ϊfalse��ע��ʱ������������ڣ��򱨴�ֹͣ��
    // ��ʹ��@Inject(optional = true)ʱ�ɴﵽ��Ȼ�����Ƿ���ڵ�Ч��

    /*����������ע��*/
    @Inject
    public  Application(@Named("log4j") LogService logService){
        this.logService = logService;
    }

    public void test(){
        logService.loginfo();
    }
}
