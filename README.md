# 签名校验 + 重放攻击 + 密文非对称加密  :zzz:

> 小生不足之处，还望各位前辈不吝赐教。<br>

## 项目环境

> server： 基于 springboot 搭建。
>
> client：基于 Vue 搭建。



## 项目规定

###### 注：这里的规定只是指本项目的规定。

#### server

* 接收请求参数统一使用 @RequestParam 注解

#### client

* 请求媒体类型信息：```'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'```



## 签名认证

###### 注：案例说明

### 用户分页列表接口

**请求方法：** **POST | ${url_prefix}/user/list.action**

**请求参数：**

| 参数名   | 类型   | 描述       |
| -------- | ------ | ---------- |
| pageNum  | int    | 当前页数   |
| pageSize | int    | 每页多少个 |
| keyword  | string | 查询关键字 |

### **Client  发送请求**，**示例如下：**

```javascript
// 伪代码描述

// 请求体
let params = {
	pageNum: 1,
	pageSize: 10,
	keyword: '大',
}

// 对 param 请求体中的 参数列表按照 ASCII 进行排序。 排序后如下
params = {
    keyword: '大',
    pageNum: 1,
    pageSize: 10
}

// 把排序后的请求转化为 json 字符串。转换后如下
var A = '{"keyword":"大","pageNum":"1","pageSize":"10"}'

// 把转换后生成的字符串A + Secret 
// 假设 此时 Secret = 'AAAAAAAAAAAAAAAAAAAAAAAA'
var B = '{"keyword":"大","pageNum":"1","pageSize":"10"}AAAAAAAAAAAAAAAAAAAAAAAA'

// 生成签名 sign
var sign = md5(B)

// 再把 sign 放到请求体汇总
params.sign = sign

// 最后的请求体就是
let params = {
	pageNum: 1,
	pageSize: 10,
	keyword: '大',
    sign: sign
}

//... 发送请求。。。
```



### Server 接收请求 校验签名

```java
// SignAuthInterceptor  签名认证拦截器

// 获取 所有请求参数
Map map = request.getParameterMap();
JSONObject params = JSONObject.fromObject(map);

// 获取 请求参数 中 signa
String sign = request.getParameter("sign");

if (StringUtil.isEmpty(sign)){
	logger.warn("sign error: " + params);
	throw new SignAuthException();
}

// 对请求参数进行排序 生成服务端 自己 sign
SortedMap<Object,Object> sort = new TreeMap<>(params);
String checkSign = SignAuthUtil.createSign(APIConstant.SIGN_KEY, sort);

 // 校验 签名
if (sign.equals(checkSign)){
	return true;
}
else {
	logger.warn("sign check error: " + params);
	throw new SignAuthException();
}

```



###### 具体请看项目代码，如果有疑问欢迎加入我们 <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> ，共同交流、共同进步！



## 技术交流

:feet: <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;   :point_left:



