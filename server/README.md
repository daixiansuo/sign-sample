# Server 

> 小生不足之处，还望各位前辈不吝赐教。<br>

## 项目环境

> server： 基于 springboot 搭建。
>



## 项目结构 

```shell
src
 ├─main
       ├─java
          └─com
             └─dxs
                 └─server
                     ├─annotation 			# 登录认证注解
                     ├─aop				    # 全局日志处理
                     ├─config 				# 拦截器配置 与 Redis 配置
                     ├─constant				# 常量
                     ├─controller			# 测试接口
                     ├─enums				# 异常枚举
                     ├─exception			# 全局异常处理
                     ├─interceptor 			 # 登录认证 与 签名认证 拦截器
                     ├─redis				# redis 操作库
                     │  └─constant
                     └─utils				# 工具类
                     	└─result

```





## 签名生成

```java
public static String createSign(String key, SortedMap<Object, Object> parameters) {
        String sb = new String();
        JSONObject params = new JSONObject();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                params.put(k, v.toString());
            }
        }
        String result = params.toString().replaceAll("]","");
        result = result.replaceAll("\\[","") + key;

        System.out.println(result);
        String sign = MD5Util.MD5Encode(result);
        return sign;
    }
```



###### 具体请看项目代码，如果有疑问欢迎加入我们 <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> ，共同交流、共同进步！



## 技术交流

:feet: <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;   :point_left:



