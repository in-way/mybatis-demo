# sass前台
# 一、项目路径在project包下，包名按业务划分
## 1.marketing 营销
## 2.purchase 采购
## ...
# 二、请求路径按业务区分，方便后期维护
## 1.按业务区分 /marketing ,/purchase
# 三、前端
## 前端项目编译到webapp对应的业务目录下面，例如marketing，purchase
# 四、实体分层说明
## 对应层用对应的实体，如数据库用db，视图展示用vo
# 五、报文格式统一
## 统一报文格式，方便前端做统一处理 @GbpsRest注解，用于类
## 普通数据请求成功报文 {"status":"1200","message":"请求成功","errorDetail":null,"data":{}}
## 分页采用   startPage()+ getDataTable()返回分页数据
## 分页数据数据请求成功报文 {"status":"1200","message":"请求成功","errorDetail":null,"data":{"statistics":null,"pageSize":100,"data":[1,2,3],"totalCount":100,"pageCount":1,"pageNo":1,"hasPrevious":false,"hasNext":false,"startOfPage":0,"totalPageCount":1}}
# 六、国际化字段命名统一
## 国际化字段统一命名，方便后期统一处理
# 七、配置
## 涉及到的配置需写到配置文件中实现动态可配置，编码在代码中去固定写死
# 八、开发规范
## 参考阿里开发规范
# 九、避免返回null
## 可以返回空数组空对象等，不要返回null,避免空指针异常。
# 十、禁用魔法值
# 十一、传参超过三个以上需建实体
