import Vue from 'vue';
import axios from 'axios';


// 创建axios实例
const service = axios.create({
    timeout: 1000 * 30,
    withCredentials: true,

    headers: {
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
    }
});

// request拦截器
service.interceptors.request.use(config => {
    config.headers['Authorization'] = Vue.cookies.get('token');
    return config;
}, error => {s
    return Promise.reject(error);
});

// response拦截器
 service.interceptors.response.use(response => {
    // console.log(response);
    if (response.data && response.data.code === -1 ||
        response.data && response.data.code === 401) { // -1, token失效 401 没有token
        Vue.cookie.delete('token');
        Vue.router.push({name: 'login'});
    }
    return response;
},  error => {
    return Promise.reject(error);
});

export default service;
