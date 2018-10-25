package com.swp.nlp;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 描述:
 * nlp
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-10-24 12:16 PM
 */
public class Simple {

    //设置APPID/AK/SK
    public static final String APP_ID = "14533559";
    public static final String API_KEY = "RejSqjBBsXZlhK4D12o7FThF";
    public static final String SECRET_KEY = "aUT5YHq5GuTPvBx4t0z8G2j2E9ZYw6q7";

    public static void main(String[] args) {
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

//        // 调用接口
//        String text = "百度是一家高科技公司";
//        JSONObject res = client.lexer(text, null);
//        System.out.println(res.toString(2));

        sample(client);
    }


    public static void sample(AipNlp client) {
        String text1 = "消费是国情的一面镜子。无论是助推更多人的“生活提质”，还是倒逼电商平台的“产品提质”，都有赖于进一步改善居民消费能力和预期。要实现此目标，“深化收入分配制度改革”必不可少，只有完善有利于提高居民消费能力的收入分配制度，增加低收入群体收入，扩大中等收入群体，才能为扩大消费提供根本动力";
        String text2 = "科技发展是国情的一面镜子。无论是改善人民生活水平，还是提高国家实力，都有赖于进一步改善居民消费能里和预期。要实现此目标，完善科技发展制度改革必不可少，只有完善有利于提高科技发展的制度体制，鼓励万众创新科技创业，才能提升科技实力";

        // 传入可选参数调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("model", "CNN");

        // 短文本相似度
        JSONObject res = client.simnet(text1, text2, options);
        System.out.println(res.toString(2));

    }

}
