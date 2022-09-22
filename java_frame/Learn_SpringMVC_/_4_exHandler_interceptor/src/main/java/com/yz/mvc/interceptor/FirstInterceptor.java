package com.yz.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("First.preHandler ======================================");
        return true; //! true 放行
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("First.postHandle ======================================");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("First.afterCompletion =================================");
    }
}
/*
    ! filter 和 interceptor 都能拦截请求，区别：执行时机不同：
        SpringMVC中，拦截器用于：拦截控制器方法的执行
        因：只有DispatcherServlet有控制器,so拦截器只作用于DispatcherServlet处理的请求

        1. filter
        2. dispatcherServlet
        3. 所有 interceptor.preHandle()
            返回值：是否放行，true放行，即调用控制器方法；
                   false拦截，即不调用控制器方法和postHandle，直接调用afterComplation
        4. 执行controller方法 （结果封装为modelAndView）
        5. 所有 interceptor.postHandle( )
        6. 渲染视图（model填入view）
        7. 所有 interceptor.afterComplation( )

DispatcherSevlet.doDispatch() 部分代码
            ! 3
            if (!mappedHandler.applyPreHandle(processedRequest, response)) {
                return;
            }
            ! 4
            mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
            ! 5
            mappedHandler.applyPostHandle(processedRequest, response, mv);
            processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);

processDispatchResult()
            ! 6
			render(mv, request, response);
			! 7
			mappedHandler.triggerAfterCompletion(request, response, null);*/
/*
! 多个拦截器执行顺序：
eg: 5个interceptor（配置文件中的顺序：12345）
            正常（都未被拦截）      拦截3（interceptorIndex为2的索引）
pre                 12345         123
post                54321         不执行
afterCompletion     54321         21

以下：用（正常：）和（拦截3：）代表两种case，数字表示执行顺序
! HandlerExceptionChain.applyPreHandle()
		for (int i = 0; i < this.interceptorList.size(); i++) {
			HandlerInterceptor interceptor = this.interceptorList.get(i);
			if (!interceptor.preHandle(request, response, this.handler)) {
				triggerAfterCompletion(request, response, null);  // 拦截3：1. interceptorIndex = 2的索引
				return false;    // 拦截3：3. 回到 DispatcherSevlet.doDispatch()后，直接返回，不再执行之后的（控制器方法，postHandle等
			}
			this.interceptorIndex = i;
		}
		return true; // 正常：1. 继续执行 DispatcherSevlet.doDispatch()中，之后的代码

! HandlerExceptionChain.applyPostHandle()
        // 只有all拦截器都不拦截，才执行该方法
        // 正常：2. 按逆序调用 postHandle
		for (int i = this.interceptorList.size() - 1; i >= 0; i--) {
			HandlerInterceptor interceptor = this.interceptorList.get(i);
			interceptor.postHandle(request, response, this.handler, mv);
		}

! HandlerExceptionChain.triggerAfterCompletion()
        // 拦截3：2. 对于3之前的拦截器，按逆序调用 AfterCompletion
        // 正常：3. 对所有拦截器，按逆序调用 AfterCompletion
		for (int i = this.interceptorIndex; i >= 0; i--) {
			HandlerInterceptor interceptor = this.interceptorList.get(i);
			try {
				interceptor.afterCompletion(request, response, this.handler, ex);
			}
			catch (Throwable ex2) {
				logger.error("HandlerInterceptor.afterCompletion threw exception", ex2);
			}
		}
 */