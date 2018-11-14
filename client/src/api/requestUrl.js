/**
 * 请求地址统一处理／组装
 * @param {*} actionName action方法名称
 */
export default function (actionName) {
    // 非生产环境 && 开启代理, 接口前缀统一使用[/api/]前缀做代理拦截!
    // return ('http://47.96.169.148/web') + actionName;

    // return ('https://njy.jsnjy.net.cn/web') + actionName;
    return ('/api') + actionName;
}
