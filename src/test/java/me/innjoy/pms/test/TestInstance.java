package me.innjoy.pms.test;

import com.meituan.hotel.lock.client.params.SendManagerPasswordParam;
import me.innjoy.pms.pojo.dto.ResultDto;
import me.innjoy.pms.utils.ParamUtils;
import org.junit.Test;

/**
 *
 */
public class TestInstance {
    @Test
    public void name() throws Exception {
        SendManagerPasswordParam param = new SendManagerPasswordParam();
        ResultDto resultDto = ParamUtils.verifyNull(param);
        System.out.println(resultDto.getMessage());
    }
}
