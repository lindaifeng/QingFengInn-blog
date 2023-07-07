# QingFengInn-blog
个人博客完整源码：如果对你有所帮助，可以给个star鼓励一下
# SpringBoot个人博客项目搭建

注意：最新博客源码已迁移至Gitee：[博客Gitee源码](https://gitee.com/lindaifeng/QingFengInn-blog)
>  **博客Github源码：**[https://github.com/lindaifeng/QingFengInn-blog](https://github.com/lindaifeng/QingFengInn-blog)
>  **个人博客主页：**[http://www.lindaifeng.vip/](http://www.lindaifeng.vip/)


# 一、项目简介：
## 1.1 前言
- 曾几何时，浏览着别人一个个好好看的个人博客的时候，也憧憬着要是有一个属于自己的个人博客网站就好了。
- 随着技术的提升自己也想用Spring boot 搭建一个属于自己的博客系统，刚好前段时间学习了李仁密大神的小而美个人博客项目课受益匪浅。于是琢磨着搭建一款属于自己的博客网站一定非常棒。
- 于是参考了oneStar博主的博客项目，乘热打铁巩固所学习的内容，好让自己熟悉这类项目开发的基本流程。于是有了下面这款"清峰小栈"个人博客项目。
- 本SpringBoot个人博客项目已开源在我的Github上，感兴趣的可以去了解一下，制作不易可以给个star适当鼓励一下。

- 来不及多说上图：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929160908400.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

## 1.2 技术选型
 **下面我将分模块对本项目进行讲解。**

| 工具	  | 名称 |
|--|--|
| 开发工具 | 	IDEA |
| 语言| 	JDK1.8、HTML、css、js |
| 模板引擎 | 	Themleaf |
| 数据库 | 	Mysql5.6 |
| 项目框架| 	SpringBoot|
| ORM | 	Mybatis|
| 项目构建	| 	Maven|
| 运行环境	| 	阿里云Unbuntu7|
# 二、前端页面介绍



本博客前端采用的是Semintic UI前端框架进行页面搭建和themleaf模板引擎进行页面渲染，总体看上去页面源代码是比较清爽和美观的。

具体流程点击：[《前端页面介绍模块》](https://blog.csdn.net/weixin_45019350/article/details/108884202)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929200235354.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)


 1. Semintic UI提供了一系列第三方组件和模板供我们使用，使我们可以更加方便、快捷的搭建出前端模板。
 2. themleaf模板引擎具有开箱即用的特性，是SpringBoot官方推荐的前端模板引擎。它可以完全替代 JSP，可以直接套用模板实现JSTL、 OGNL表达式效果，避免每天套模板、该jstl、改标签的困扰。
 3. 同时在前端页面我引入了雪花动态效果可以很直观的看到细雪纷飞的景色，增强了前端页面的观赏性。
 4. 在左下角我们可以发现一个动漫是的人物，也是引入的一个第三方插件，叫Live2D看板娘，是一个比较经典的博客互动模型，支持换装，换人物，信息互动等功能。也可自定义功能。集成也非常简单网上一找一大堆。
 
# 三、MySql数据库搭建准备
数据库搭建相对比较简单，设计的表结构关系也不是很复杂，具体可以参考一下。

具体流程点击：[《MySql数据库搭建模块》](https://blog.csdn.net/weixin_45019350/article/details/108897466)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929203231455.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

# 四、Idea环境搭建准备
环境搭建主要采用Maven对jar包进行统一管理，考虑的是采用什么技术，用哪个版本更加稳定不会互相冲突，最后导入依赖maven集成即可。

具体流程点击：[《Idea环境搭建模块》](https://blog.csdn.net/weixin_45019350/article/details/108897830)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929203550572.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)
# 五、SprongBoot后台管理界面介绍
## 1.0 后台日志类和自定义异常类功能实现
最先开始的代码准备工作是我们的日志类编写，项目运行过程中出现的一些问题bug都会以日志的方式被记录下来，供我们进行查看，能够让开发人员更容易的发现问题所在，极大程度上提高了工作效率。
随后编写我们的异常处理类，当我们的程序出现异常时我们应该采取对应的措施。进行响应，使得我们的程序即使奔溃了也能够很友好的展示给用户。

具体流程点击：[《后台日志类和自定义异常类功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108905341)

## 1.1 后台登录界面功能实现
登录界面功能点比较简单，主要是对用户名密码进行校验，判断是否和数据库中已存入的用户名密码相匹配。主要功能点是对非管理员登录的所有路径进行统一拦截，以防非管理员用户在地址栏通过输入路径直接访问到后台的情况。
同时也提供了注销功能，能够退出当前账号换号登录。

具体流程点击：[《后台登录功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108905391)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929210110663.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)
## 1.2 后台博客界面功能实现
登入后台后我们就可以对博客的后台数据进行操作了
博客模块主要实现的功能是对自己的个人博客进行保存、发表和新增，删除、修改，全局查询、关键字模糊查询、分页展示和多条件查询等。

具体流程点击：[《后台博客功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108905406)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929211333879.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)
## 1.3 后台分类界面功能实现
分类模块主要实现的功能是可以给我们的博客进行分类，添加分类标签，利于我们对博客进行管理和区分，实现了对分类的新增，查询，编辑，和删除功能等。

具体流程点击：[《后台分类功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108905413)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929211949133.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)
## 1.4 后台友链界面功能实现
友链模块主要实现的功能是可以给我们其他的博客网站朋友们添加一个互相交流的接口，可以链接其他的博客网站并提供图片展示，友链新增，友链查询，友链编辑，和删除功能等。

具体流程点击：[《后台友链功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108905423)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929212817753.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

## 1.5 后台照片墙界面功能实现
照片墙模块主要实现的功能是添加你喜欢的照片，可以是动漫人物，精美壁纸，成长过程等照片进行前端展示，你可以在照片墙上添加时间地点，照片描述等信息，同时也提供了图片链接展示，图片新增，图片查询图片，编辑，和删除功能等。

具体流程点击：[《后台照片墙功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108905436)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929213140929.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

# 六、SpringBoot前台展示界面介绍
## 1.1 前端首页展示功能实现
前台首页展示我主要是实现了博客的分页查询，全局查询，博客名称模糊查询和最热博客推荐查询功能。
同时当点击博客时我们可以跳转到博客详情页面，阅读博客信息，参与博客评论及评论楼中楼技术要点和评论管理员特色回复的实现。
其中的难点就在于楼中楼功能的实现。

具体流程点击：[《前台首页功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108934116)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929214046486.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)
## 1.2 前端分类展示功能实现
前台分页展示我主要是实现了指定id查询，指定分类查询两个功能，当点击分类博客时我们也能查看到指定博客详情信息。
具体代码流程比较简单参考以上几篇博客内容介绍即可。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929215231449.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

## 1.3 前端时间轴展示功能实现
前台时间轴展示我主要是实现了对我的所有博客进行全局查询，按创建时间进行倒叙排列，当点击时间轴上指定博客时我们也能查看到指定博客详情信息。
具体代码流程比较简单参考以上几篇博客内容介绍即可。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929215509194.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

## 1.4  前端音乐盒展示功能实现
前台音乐盒展示我主要是实现了一个第三方插件的集成，引用了一个优秀的音乐盒开源插件，实现了界面音乐的自动播放，歌词展示，轮播等功能。


## 1.5 前端留言板展示功能实现
前台留言展示我主要是实现了指定留言全局查询功能，留言楼中楼功能和管理员回复显示管理员头像功能。
具体业务逻辑可参考：1.1 前端首页展示功能实现中评论功能模块的代码实现。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929215931934.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

## 1.6 前台友链展示功能实现
前台友链展示我主要是实现了友链展示功能，当点击指定友链时会跳转到对方个人博客网站上。功能比较简单就不做过多阐述。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929220149237.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

## 1.7 前台照片墙展示功能实现
前台照片墙展示我主要是实现了照片的全局查询展示功能，当点击指定照片时我们也能查看到制定照片的详情信息这里是前端页面渲染实现的功能，源代码没有这一段代码，项目运行后该代码被渲染出来了（做的时候有掉坑里所以印象深刻）。功能比较简单就不做过多阐述。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929220540735.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)


## 1.8 前台作者介绍展示功能实现
因为作者介绍数据可以不用实时变化，所以可以把页面写死在前端源代码中，当然也可以把数据放后台数据库中实现修改功能等（自行扩展）功能也比较简单就不做过多阐述。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200929220828832.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NTAxOTM1MA==,size_16,color_FFFFFF,t_70#pic_center)

# 七、项目部署到服务器
我们的项目构建好之后，需要部署到服务器别人才能够访问，部署到服务器需要将我们本地项目上传到服务器

具体流程点击：[《项目部署功能模块》](https://blog.csdn.net/weixin_45019350/article/details/108963951)
