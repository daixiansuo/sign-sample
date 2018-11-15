import request from '../request'
import requestURL from '../requestUrl'
import Qs from 'qs'


export function login(params) {
  return request({
    method: 'post',
    url: requestURL('/user/login.action'),
    data: Qs.stringify(params)
  })
}


export function logout(params) {
  return request({
    method: 'post',
    url: requestURL('/user/logout.action'),
    data: Qs.stringify(params)
  })
}


export function getFertilizerData1(params) {
  return request({
    method: 'post',
    url: requestURL('/land/getFertilizerData1.action'),
    data: Qs.stringify(params)
  })
}
