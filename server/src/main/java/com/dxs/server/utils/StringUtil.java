package com.dxs.server.utils;


import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ChenXin on 2016/7/29.
 */
public class StringUtil {


    /**
     * 获取 request 对象中的 json 对象字符串
     * @param inputStream
     * @return
     */
    public static String getRequestJsonString(InputStream inputStream){

        StringBuffer str = new StringBuffer();
        String result = null;
        try {
            BufferedInputStream in = new BufferedInputStream(inputStream);
            int i;
            char c;
            while ((i = in.read()) != -1) {
                c = (char) i;
                str.append(c);
            }
            result = new String(str.toString().getBytes("ISO-8859-1"),"UTF-8");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }



    /**
     * 生成 UUID
     * @return
     */
    public static String getPkId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 截取字符串指定指定字符第N此出现的位置
     * @Parameter str 指定字符串
     * @Parameter c  指定字符
     * @Parameter  times  自定出现的次数
     * */
    public static int getIndex(String str, String c, int times) {
        int index = 0;
        String[] arr = str.split(c);
        int length = arr.length > times ? times : arr.length;
        for (int i = 0; i < length; i++) {
            index += arr[i].length();
        }
        return index + times - 1;
    }

    /**
     * 是否是整数
     * @param value
     */
    public static boolean isIntege(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^-?[1-9]\\d*$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是正整数
     * @param value
     */
    public static boolean isIntege1(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[1-9]\\d*$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是负整数
     * @param value
     */
    public static boolean isIntege2(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^-[1-9]\\d*$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是数字
     * @param value
     */
    public static boolean isNum(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^([+-]?)\\d*\\.?\\d+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是正数（正整数 + 0）
     * @param value
     */
    public static boolean isNum1(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[1-9]\\d*|0$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是负数（负整数 + 0）
     * @param value
     */
    public static boolean isNum2(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^-[1-9]\\d*|0$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是浮点数
     * @param value
     */
    public static boolean isDecmal(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^([+-]?)\\d*\\.\\d+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是正浮点数
     * @param value
     */
    public static boolean isDecmal1(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是负浮点数
     * @param value
     */
    public static boolean isDecmal2(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*)$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是浮点数
     * @param value
     */
    public static boolean isDecmal3(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^-?([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0)$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是非负浮点数（正浮点数 + 0）
     * @param value
     */
    public static boolean isDecmal4(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*|0?.0+|0$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是非正浮点数（负浮点数 + 0）
     * @param value
     */
    public static boolean isDecmal5(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^(-([1-9]\\d*.\\d*|0.\\d*[1-9]\\d*))|0?.0+|0$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是邮件
     * @param value
     */
    public static boolean isEmail(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是颜色
     * @param value
     */
    public static boolean isColor(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[a-fA-F0-9]{6}$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是url
     * @param value
     */
    public static boolean isUrl(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
//        p=p.compile("^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是中文
     * @param value
     */
    public static boolean isChinese(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是ACSII字符
     * @param value
     */
    public static boolean isAscii(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[\\x00-\\xFF]+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是邮编
     * @param value
     */
    public static boolean isZipcode(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^\\d{6}$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是手机
     * @param value
     */
    public static boolean isMobile(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^(13|14|15|18)[0-9]{9}$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是ip地址
     * @param value
     */
    public static boolean isIp(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是非空
     * @param value
     */
    public static boolean isNotempty(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^\\S+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是图片
     * @param value
     */
    public static boolean isPicture(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是压缩文件
     * @param value
     */
    public static boolean isRar(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("(.*)\\.(rar|zip|7zip|tgz)$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是日期
     * @param value
     */
    public static boolean isDate(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是QQ号码
     * @param value
     */
    public static boolean isQq(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[1-9]*[1-9][0-9]*$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是电话号码的函数(包括验证国内区号,国际区号,分机号)
     * @param value
     */
    public static boolean isTel(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
     * @param value
     */
    public static boolean isUsername(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^\\w+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是字母
     * @param value
     */
    public static boolean isLetter(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[A-Za-z]+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是大写字母
     * @param value
     */
    public static boolean isLetter_u(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[A-Z]+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是大写字母
     * @param value
     */
    public static boolean isLetter_l(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^[a-z]+$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }

    /**
     * 是否是价格
     * @param value
     */
    public static boolean isPrice(String value){
        Pattern p=null;//正则表达式
        Matcher m=null;//操作符表达式
        boolean b=false;
        p=p.compile("^([1-9]{1}[0-9]{0,}(\\.[0-9]{0,2})?|0(\\.[0-9]{0,2})?|\\.[0-9]{1,2})$");
        m=p.matcher(value);
        b=m.matches();
        return b;
    }


    /******************************************************************/
    /*根据需要添加*/
    /******************************************************************/

    /**
     * 是否是用户身份
     * @param value
     * @return
     */
//    public static boolean isIdentity(String value){
//        for(String identity: IdentityConstant.printAllIdentity()){
//            if(identity.equals(value)){
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 是否是第三方平台类型
     * @param value
     * @return
     */
    public static boolean isThirdType(String value){
        if("QQ".equals(value)||"weChat".equals(value)){
            return true;
        }
        return true;
    }

    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input) || ("null").equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
}
