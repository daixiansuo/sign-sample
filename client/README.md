# Client

> Vue 、iView project

## Build Setup

``` bash
# 安装依赖
npm install
```



## 项目依赖

### qs

**作用：格式化请求参数 使得请求体可以被 server 接收并映射。主要避免 媒体类型不匹配 异常。**

```javascript
// 安装依赖
npm install qs --save

// 哪用导哪
import Qs from 'qs'

// 主要操作
export function login(params) {
  return request({
    method: 'post',
    url: requestURL('/user/login.action'),
    data: Qs.stringify(params)
  })
}
```



### js-md5

**作用：进行 md5 加密**

```javascript
// 安装依赖
npm install js-md5 --save

// main.js
import md5 from 'js-md5'
Vue.prototype.$md5 = md5;

// 平常操作
var sign = this.$md5('需要加密字符串')
```



### vue-cookies

**作用：客户端 存储 token。**

```javascript
// 安装依赖
npm install vue-cookies --save

// main.js
import Vue from 'Vue'
import VueCookies from 'vue-cookies'
Vue.use(VueCookies)

// 平常操作
this.$cookies.set(keyName, time)   
this.$cookies.get(keyName)   
this.$cookies.remove(keyName)  
this.$cookies.isKey(keyName) 
this.$cookies.keys()
```



###### 具体请看项目代码，如果有疑问欢迎加入我们 <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> ，共同交流、共同进步！



## 技术交流

🐾 <a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=dcdd3d66762ab211689194912f87f082e1416c4a95313d48caf179871150fdd8">Hello World</a> &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;   👈

