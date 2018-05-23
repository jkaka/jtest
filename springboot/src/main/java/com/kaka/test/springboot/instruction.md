从项目的角度，一共分为七个模块
biz:应用业务逻辑实现层，包括：manager、service、mapper、entities 等
boot: web层，包括：controler和application
call: 调用外部接口访问层，应用访问外部的接口，在这一层封装
client:应用对外提供服务接口,提供第三方调用二方包
    UserService、UserDTO
openservice:应用对外提供服务接口实现层
    UserServiceImpl
common:应用公共调用类(常量类constants、枚举类enums、工具类utils)

调用规范
    boot(controller)调用biz(service/manager)、client(对外提供的接口)
    biz调用call(访问外部系统)
    client中都是接口,实现类写在openservice
    call调用其他系统的client(dubbo方式)、boot(http方式)
    openservice调用biz中的service
    config模块：配置层
    common模块：应用公共相关类包

模块依赖关系
    boot依赖biz和openservice
    biz依赖config、call、client
    openservice依赖biz、client
    client依赖common
    call依赖common、config


