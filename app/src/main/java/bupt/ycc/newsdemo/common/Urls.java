package bupt.ycc.newsdemo.common;

/**
 * Description : 接口API的URL
 * Author : lauren
 * Email  : lauren.liuling@gmail.com
 * Blog   : http://www.liuling123.com
 * Date   : 15/12/13
 */
public class Urls {

    //http://c.m.163.com/nc/article/headline/T1348647909107/0-5.html  头条

    public static final int PAZE_SIZE = 20;

    public static final String HOST = "http://c.m.163.com/";
    public static final String END_URL = "-" + PAZE_SIZE + ".html";
    public static final String END_DETAIL_URL = "/full.html";
    // 头条
    public static final String TOP_URL = HOST + "nc/article/headline/";
    public static final String TOP_ID = "T1348647909107";
    // 新闻详情
    public static final String NEW_DETAIL = HOST + "nc/article/";

    public static final String COMMON_URL = HOST + "nc/article/list/";


    //娱乐
    public static final String ENTERTAIN_ID = "T1348648517839";

    //财经
    public static final String ECONOMY_ID = "T1348648756099";

    // 笑话
    public static final String JOKE_ID = "T1350383429665";

    //社会
    public static final String SOCIETY_ID = "T1348648037603";

    // 图片
    public static final String IMAGES_URL = "http://api.laifudao.com/open/tupian.json";

    // 天气预报url
    public static final String WEATHER = "http://wthrcdn.etouch.cn/weather_mini?city=";

    //百度定位
    public static final String INTERFACE_LOCATION = "http://api.map.baidu.com/geocoder";

}
