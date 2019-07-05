import request from '../request'
import requestURL from '../requestUrl'
import requestParam from '../requestParam'


export function login(params) {
  return request({
    method: 'post',
    url: requestURL('/auth/login'),
    data: requestParam(params)
  })
}


export function logout(params) {
  return request({
    method: 'post',
    url: requestURL('/user/logout.action'),
    data: requestParam(params)
  })
}
