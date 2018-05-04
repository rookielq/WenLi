package cn.lvhaosir.common.base;

import cn.lvhaosir.utils.EmptyUtil;
import cn.lvhaosir.utils.JavaEmail;
import cn.lvhaosir.utils.JsonReturnData;
import cn.lvhaosir.utils.WebConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lvhaosir on 2018/5/4.
 */

@Controller
@RequestMapping("/common")
public class CommonController {


    @RequestMapping("/sendEmail")
    @ResponseBody
    public JsonReturnData sendEmail(Integer id , String content ) {
        if ( EmptyUtil.isEmpty(id) || id <= 0 || EmptyUtil.isEmpty(content)  ) {
            return new JsonReturnData(WebConstant.VALID_DATA,"没有接收到有效数据");
        }
        int sendEmail = JavaEmail.sendEmail("smtp.qq.com", "985694388@qq.com", "yoqmpkijjnyhbedg", "985694388@qq.com", new String[]{"985694388@qq.com", "heyxhazx1003@163.com"}, "文理周记app意见反馈：", content + "////反馈id为" + id, "text/html;charset=utf-8");
        if (sendEmail > 0 ){
            return new JsonReturnData(WebConstant.SUCCESS,"邮件已成功发送");
        } else {
            return new JsonReturnData(WebConstant.ERROR, "发送失败，服务器异常");
        }
    }


}
