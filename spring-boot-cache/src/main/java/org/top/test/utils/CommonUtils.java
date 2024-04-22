package org.top.test.utils;

import java.util.concurrent.ThreadLocalRandom;

public class CommonUtils {

    /**
     * 生成四位随机数1000-9999
     * @return
     */
    public static int generateCode(){
        return ThreadLocalRandom.current().nextInt(1000,9999);
    }
}
