package com.sunhaibo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;


@Aspect//当前类为切面类
@Component//把切面类加入到IOC容器中
public class HttpAspect {



//    @Before("execution(public * com.sunhaibo.controller.GirlController.*(..))")//Before前监视 execution("")设置切点
//    public void log(){
//        System.out.println("111");
//    }
//
//    @After("execution(public * com.sunhaibo.controller.GirlController.*(..))")//After后监视
//    public void doAfter(){
//        System.out.println("222");
//    }//切点重复

    @Pointcut("execution(public * com.sunhaibo.controller.GirlController.*(..))")//提取出切点
    public void log() {
    }

//    @Before("log()")//切点设为公共log()
//    public void doBefore(){
//        System.out.println("1111");
//    }
//
//    @After("log()")//切点设为公共log()
//    public void doAfter(){
//        System.out.println("222");
//    }//切换成logger

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    //import org.slf4j.Logger;
    //记录器工厂.获取记录器（反射当前类）

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //logger.info("11111111");//记录器式输出

        /**
         * 记录Http请求
         */
       ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       //Servlet请求属性 属性 = （Servlet请求属性）请求环境持有者.获取请求属性()
       HttpServletRequest request = attributes.getRequest();
       //HttpServlet请求 req = 属性.获取请求()


        //url
        logger.info("url={}",request.getRequestURL());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+" . "+joinPoint.getSignature().getName());
        // joinPoint.getSignature().getDeclaringTypeName() 获取类名
        // joinPoint.getSignature().getName()获取类方法

        //参数
        logger.info("args={}",joinPoint.getArgs());



    }

    @After("log()")
    public void doAfter(){
        logger.info("22222222");//记录器式输出
    }

    @AfterReturning(returning = "object", pointcut = "log()")//需两个参数 切点和返回值
    public void doAfterReturning(Object object){
       logger.info("response={}",object.toString());

    }
}
