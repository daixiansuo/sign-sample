<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <Row>
      <Input v-model="username" placeholder="username" clearable style="width: 200px"/>
      <Input v-model="password" placeholder="password" clearable style="width: 200px"/>
      <Button type="primary" @click="login">登陆</Button>
      <Button type="primary" @click="logout">退出</Button>
    </Row>

    <br>
    <br>
    <br>

    <Row>
      <Col span="4">
        <br>
      </Col>
      <Col span="4">
        <br>
      </Col>
      <Col span="4">
        <Card>
          <p slot="title">登陆</p>
          <p>输入 username、password 进行登陆操作</p>
          <p>作用：登陆成功后 服务端 返回 token，客户端接收到之后 存放到 cookie 中。并且以后每次请求自动添加到 Header 中。</p>
        </Card>
      </Col>
      <Col span="4">
        <Card>
          <p slot="title">退出</p>
          <p>退出操作 请求会进行签名校验，客户端生成 sign 密文，与请求参数一同放到请求体中向服务端发送，服务的接收到请求参数，进行排序，生成sign，然后进行 sign 比对，匹配放行，反之，打回 </p>
        </Card>
      </Col>
      <Col span="4"></Col>
      <Col span="4"></Col>
    </Row>

  </div>
</template>

<script>

  import API from '@/api'

  export default {
    name: 'HelloWorld',
    data() {
      return {
        msg: '签名校验',
        username: '',
        password: ''
      }
    },
    methods: {
      login() {

        // 项目密文 加密公钥
        let publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQClZPruysUXICP0wgVpIAzGvJmcWzz6+0OnAC1hdcZ+kBA2IQgiatxfFZ2SY6At0s/67e/7uvQqaLhSuAG5eoO05BacPjYg6iCE7+cw4UHkPnp2IMK/Cx/IlRvJdhgctt03GWbOZAzgn6/fPjUG3rgFUqHlOwBOTr7oX8COZsfZHwIDAQAB";

        let JsEncrypt = new JSEncrypt();
        //设置公钥
        JsEncrypt.setPublicKey(publicKey);


        let params = {
          username: this.username,
          password: JsEncrypt.encrypt(this.password)   //加密
        }

        // 登陆请求
        API.common.login(params).then(({data}) => {
          console.log(data)
          if (data && data.code == 0) {
            // token 存到 cookies
            this.$cookie.set("token", data.data.token);
          }
        })

      },

      logout() {
        let params = {
          username: this.username
        }

        // 生成签名
        var sign = makeSign(params, this);
        params.sign = sign;

        // 退出请求
        API.common.logout(params).then(({data}) => {
          console.log(data)
          if (data && data.code == 0) {
            // 清楚 token
            this.$cookies.remove('token');
            alert('退出成功');
          }
        })
      },

    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
