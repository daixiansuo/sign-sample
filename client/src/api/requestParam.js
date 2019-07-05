
// 必须使用 Qs 对请求参数处理
import Qs from 'qs'
// 引入 md5 加密
import md5 from 'js-md5'
// UUID 工具
const uuid = require('uuid/v4')

/**
 * 请求参数统一处理: 签名 - 重放攻击
 * @param {*} params 参数对象
 */
export default function (params) {

  // 防止重放攻击 timestamp + nonce
  params.timestamp = new Date().getTime();
  params.nonce = uuid();

  // 生成签名  --  Secret : 项目签名秘钥  存放位置自己定义即可
  params.sign = makeSign(params, "JM:JNZ:B1A4ABB4F43A3721B06518112A9");

  console.log(params)

  return Qs.stringify(params);
}

function makeSign(params, secret) {

  // 单层json对象 对 key 进行 ascii 进行排序
  let ksort = Object.keys(params).sort()

  let result = '';
  for (let i = 0; i < ksort.length; i++) {
    result = result + ksort[i] + "=" + params[ksort[i]] + "&";
  }

  // 拼接 - 秘钥
  result = result + "secret=" + secret;
  // 生成 - 签名
  let sign = md5(result).toUpperCase();

  return sign;
}

