
// 签名
export function makeSign(obj, _this) {
  var newkey = Object.keys(obj).sort(); //先用Object内置类的keys方法获取要排序对象的属性名，再利用Array原型上的sort方法对获取的属性名进行排序，newkey是一个数组
  var newObj = {}; //创建一个新的对象，用于存放排好序的键值对
  for (var i = 0; i < newkey.length; i++) {
    //遍历newkey数组
    // console.log(obj[newkey[i]],typeof(obj[newkey[i]]));
    if (typeof obj[newkey[i]] != "string") {
      obj[newkey[i]] = obj[newkey[i]] + "";
    }
    newObj[newkey[i]] = obj[newkey[i]]; //向新创建的对象中按照排好的顺序依次增加键值对
  }
  var objKeySort = newObj; //返回排好序的新对象

  var temp = JSON.stringify(objKeySort) + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
  console.log(temp);
  return _this.$md5(temp);
}

// 获取请求地址传参
export function getParamsByName(name) {
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
    if(pair[0] == name){return pair[1];}
  }
  return(false);
}
