package com.dxs.server.exception;


import com.dxs.server.enums.ResultCode;
import com.dxs.server.utils.result.Result;
import com.dxs.server.utils.result.ResultBuilder;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.Map;


/**
 * 异常处理器
 *
 */
@RestControllerAdvice
@ResponseBody
public class ApiExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public <T> Result<T> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e) {
		logger.info("------->参数解析失败 !" , e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.MESSAGE_NOT_READABLE.getCode())
				.setMsg(ResultCode.MESSAGE_NOT_READABLE.getMsg())
				.build();
	}

	/**
	 * 404 - Page not found
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public <T> Result<T> handlePageNotFoundException() {
		logger.info("------->链接不存在!");
		printLog();
		return new ResultBuilder<T>()
				.setCode(ResultCode.PAGE_NOT_FOUND.getCode())
				.setMsg(ResultCode.PAGE_NOT_FOUND.getMsg())
				.build();
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public <T> Result<T> handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException e) {
		logger.info("------->不支持当前请求方法 !" , e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.METHOD_NOT_ALLOW.getCode())
				.setMsg(ResultCode.METHOD_NOT_ALLOW.getMsg())
				.build();
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public <T> Result<T> handleHttpMediaTypeNotSupportedException(Exception e) {
		logger.info("------->不支持当前媒体类型 !" + e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.UNSUPPORTED_MEDIA_TYPE.getCode())
				.setMsg(ResultCode.UNSUPPORTED_MEDIA_TYPE.getMsg())
				.build();
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(Exception.class)
	public <T> Result<T> handleException(Exception e) {
		logger.info("------->未知错误 !", e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.UNKNOW_ERROR.getCode())
				.setMsg(ResultCode.UNKNOW_ERROR.getMsg())
				.build();
	}

	/**
	 * 500 - 内部错误
	 */
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(IllegalArgumentException.class)
	public <T> Result<T> parameterException(IllegalArgumentException e) {
		logger.info("------->非法参数 !", e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.INVALID_PARAM.getCode())
				.setMsg(e.getMessage().isEmpty()?ResultCode.INVALID_PARAM.getMsg() : e.getMessage())
				.build();
	}




	/**
	 *  业务错误
	 */
	@ExceptionHandler(ApiException.class)
	@ResponseStatus(HttpStatus.OK)
	private <T> Result<T> runtimeExceptionHandler(ApiException e){
		logger.error("------->error !" , e);
		return new ResultBuilder<T>()
				.setCode(e.getErrCode())
				.setMsg(e.getErrMsg())
				.build();
	}

	/**
	 *  spring绑定参数校验错误
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.OK)
	private <T> Result<T> illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
		return new ResultBuilder<T>()
				.setCode(ResultCode.INVALID_PARAM.getCode())
				.setMsg(ResultCode.INVALID_PARAM.getMsg())
				.build();
	}

	/**
	 *  spring方法参数缺失错误
	 */
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.OK)
	private <T> Result<T> illegalParamsExceptionHandler(MissingServletRequestParameterException e) {
		return new ResultBuilder<T>()
				.setCode(ResultCode.INVALID_PARAM.getCode())
				.setMsg(ResultCode.INVALID_PARAM.getMsg())
				.build();
	}



	/**
	 *  spring绑定参数校验错误
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.OK)
	private <T> Result<T> methodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
		logger.error("---------> invalid request!", e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.INVALID_PARAM.getCode())
				.setMsg(ResultCode.INVALID_PARAM.getMsg())
				.build();
	}

	/**
	 * Hibernate validate 参数校验错误
	 */
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.OK)
	private <T> Result<T> bindExceptionHandler(BindException e) {
		logger.error("---------> invalid request!", e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.INVALID_PARAM.getCode())
				.setMsg(e.getFieldError().getDefaultMessage())
				.build();
	}


	/**
	 *  Token过期
	 */
	@ExceptionHandler(TokenExpireException.class)
	@ResponseStatus(HttpStatus.OK)
	private <T> Result<T> expireHandler(TokenExpireException e) {
		logger.error("---------> invalid expire!", e);
		return new ResultBuilder<T>()
				.setCode(e.getErrCode())
				.setMsg(e.getErrMsg())
				.build();
	}

	/**
	 *  Token校验失败
	 */
	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	private <T> Result<T> accessDeniedHandler(AccessDeniedException e) {
		logger.error("---------> User Ban!", e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.ACCESS_DENIED.getCode())
				.setMsg(ResultCode.ACCESS_DENIED.getMsg())
				.build();
	}

	/**
	 *
	 * @param e
	 * @param <T>
	 * @return
	 */
	@ExceptionHandler(SignAuthException.class)
	@ResponseStatus(HttpStatus.OK)
	private <T> Result<T> signAuthHandler(SignAuthException e) {
		logger.error("---------> User Ban!", e);
		return new ResultBuilder<T>()
				.setCode(ResultCode.SIGN_AUTH_NOT_MATCH.getCode())
				.setMsg(ResultCode.SIGN_AUTH_NOT_MATCH.getMsg())
				.build();
	}

	public void printLog(){
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("--------------------------------------------start----------------------------------------------");
		//url
		logger.info("url={}", request.getRequestURL());
		//method
		logger.info("method={}", request.getMethod());
		//ip
		logger.info("ip={}", getIp(request));
		//参数
		logger.info("args={}", showParamter(request.getParameterMap()));
	}

	public String showParamter(Map<String, String[]> map) {
		String result = "";
		for (String key : map.keySet()) {
			result += key + ":" + String.valueOf(map.get(key)[0]) + " ";
		}
		return result;
	}

	public static String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			//多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}
	
}
