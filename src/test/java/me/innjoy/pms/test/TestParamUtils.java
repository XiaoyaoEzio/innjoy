package me.innjoy.pms.test;

import com.meituan.hotel.lock.client.params.CustomerPasswordParam;
import me.innjoy.pms.utils.ParamUtils;
import org.junit.Test;

/**
 *
 */
public class TestParamUtils {
    @Test
    public void name() throws Exception {
        CustomerPasswordParam param = new CustomerPasswordParam();
        System.out.println(ParamUtils.verifyNull(param));
    }
}
