package com.wanandroid.app.chwanandroid.home.bean;

import com.wanandroid.app.chwanandroid.base.basehttp.BaseBean;

import java.util.List;

/**
 * create time on  2019/7/26
 * function: 首页文章列表bean
 */
public class HomeArticleListBean extends BaseBean {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>上一个问题，我们提问了Handler的同步屏障机制，除此以外，还有个比较有意思的对象：<\/p><br><p>IdleHandler<br><\/p><br><p>1. 它有什么能力？<\/p><p>2. 它有什么用处？<\/p><p>3. 能想到一些合适的场景么。<\/p><br><p>本周2/3.<\/p><br><p>本计划这周把编辑器改成markdown的，不过忘了带电脑回家，目测需要到8月中旬了。<\/p><br>","envelopePic":"","fresh":true,"id":8723,"link":"https://www.wanandroid.com/wenda/show/8723","niceDate":"13小时前","origin":"","prefix":"","projectLink":"","publishTime":1564060179000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 听说过Handler中的IdleHandler吗？","type":0,"userId":2,"visible":1,"zan":9},{"apkLink":"","author":"shifujun","chapterId":473,"chapterName":"Shadow","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":8734,"link":"https://juejin.im/post/5d2ec812e51d45778f076de3","niceDate":"15小时前","origin":"","prefix":"","projectLink":"","publishTime":1564052514000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Shadow对插件包管理的设计","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" shifujun","chapterId":473,"chapterName":"Shadow","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8733,"link":"https://juejin.im/post/5d37dcf1e51d4510664d17d4","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1563975504000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Shadow对PackageManager的处理方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"键盘上的麒麟臂","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8732,"link":"https://www.jianshu.com/p/df44146d636e","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563895948000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle终于懂了（一）带你玩转Project","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CPPAlien","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8731,"link":"https://www.jianshu.com/p/ba127b56811b","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563895356000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"Android主项目和Module中R类的区别","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"FeelsChaotic","chapterId":229,"chapterName":"AOP","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8730,"link":"https://www.jianshu.com/p/0f1c7b3e907f","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563894820000,"superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"AOP 最后一块拼图 | AST 抽象语法树 &mdash;&mdash; 最轻量级的AOP方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"占小狼","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8729,"link":"https://www.jianshu.com/p/e694f1e868ec","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893981000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"谈谈ConcurrentHashMap1.7和1.8的不同实现","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AxeChen","chapterId":70,"chapterName":"retrofit","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8728,"link":"https://www.jianshu.com/p/2e8b400909b7","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893947000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"封装Retrofit2+RxJava2网络请求框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Anlia","chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8727,"link":"https://www.jianshu.com/p/db01b37b6231","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893846000,"superChapterId":94,"superChapterName":"自定义控件","tags":[],"title":"Android知识总结&mdash;&mdash;Path常用方法解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"叫我怪兽好了","chapterId":478,"chapterName":"DataBinding","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8726,"link":"https://juejin.im/post/5d3697f8f265da1bad57468c","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893818000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"看一看 DataBinding","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Carson_Ho","chapterId":470,"chapterName":"协程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8725,"link":"https://blog.csdn.net/carson_ho/article/details/96965702","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893764000,"superChapterId":470,"superChapterName":"Kotlin","tags":[],"title":"Android：这是一份全面 &amp; 详细的Kotlin入门学习指南","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"GitCode8","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8724,"link":"https://juejin.im/post/5d307615f265da1b6b1d0dd9","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893740000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"代码洁癖症的我，学习Lint学到心态爆炸","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>1. 首先至少要知道<span style=\"font-size: 16px;\">同步屏障机制是什么？<\/span><\/p><br><p>2. 思考下，为什么要有这个机制？<\/p><br><p>本周1/3，家有喜事，最近熬夜已懵逼。<\/p>","envelopePic":"","fresh":false,"id":8710,"link":"https://www.wanandroid.com/wenda/show/8710","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563874193000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日问答 Handler应该是大家再熟悉不过的类了，那么其中有个同步屏障机制，你了解多少呢？","type":0,"userId":2,"visible":1,"zan":17},{"apkLink":"","author":"AlexLiuSheng","chapterId":340,"chapterName":"硬件相关","collect":false,"courseId":13,"desc":"本框架只适用于支持蓝牙3.0协议的设备进行数据连接传输，也就是通常说的经典蓝牙，通常手机与手机之间的连接都属于经典蓝牙模式范畴，而一般连接外设耳机等设备，大多 属于BLE蓝牙（低功耗蓝牙），这两种蓝牙除了名字有相同之外，通信方式、原理、协议完全不一样。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8722,"link":"http://www.wanandroid.com/blog/show/2629","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/AlexLiuSheng/EasyBluetoothFrame","publishTime":1563870177000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=340"}],"title":"一款适用经典蓝牙的快速开发框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"teprinciple","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"Kotlin开发，支持AndroidX 、Md5签名验证、自定义UI、自动删除安装包、通知栏图片自定义；适配中英文，支持Android9.0\r\n","envelopePic":"https://wanandroid.com/blogimgs/92ca6ece-6ed7-4a2e-a071-7c161f50d788.png","fresh":false,"id":8721,"link":"http://www.wanandroid.com/blog/show/2628","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/teprinciple/UpdateAppUtils","publishTime":1563870010000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"一行代码帮你搞定Android版本更新","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AICareless","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"AopArms编写了Android开发中常用的一套注解，如日志、异步处理、缓存、SP、延迟操作、定时任务、重试机制、try-catch安全机制、过滤频繁点击、拦截等，后续还会有更多更强大的注解功能加入\r\n","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8719,"link":"http://www.wanandroid.com/blog/show/2626","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/AICareless/AopArms","publishTime":1563869938000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AopArms一款基于AOP的Android注解框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"cn-ljb","chapterId":385,"chapterName":"架构","collect":false,"courseId":13,"desc":"快捷、高效、低耦合的Android MVP架构。\r\n\r\n* 支持Java、Kotlin混编；\r\n* 支持自动生成代码。","envelopePic":"https://wanandroid.com/blogimgs/297e7e42-cad3-4e9c-b37b-d2d16c3fe5be.png","fresh":false,"id":8718,"link":"http://www.wanandroid.com/blog/show/2625","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/cn-ljb/mvp-kotlin","publishTime":1563869908000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=385"}],"title":"Kotlin-MVP架构 -  支持Kotlin&amp;Java混编、支持代码自动生成","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"mCyp","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Android Jetpack + MVVM 构建的项目","envelopePic":"https://wanandroid.com/blogimgs/1b695b09-7220-4b68-ad08-3e2009335493.png","fresh":false,"id":8717,"link":"http://www.wanandroid.com/blog/show/2624","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/mCyp/Hoo","publishTime":1563869830000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"项目从零到一，Android Jetpack就够了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lulululbj","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"该类库利用 Kotlin 语言特性合理封装了 Android 开发中的常用操作，同时也收集了开发过程中的常用工具类。 旨在做同样的事情，写最少的代码，提升开发效率。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8716,"link":"http://www.wanandroid.com/blog/show/2623","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/lulululbj/AndroidUtilCodeKTX","publishTime":1563869719000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AndroidUtilCodeKTX ！是时候提升你的开发效率了 ！(持续更新中...)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"chinalwb","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"这是一个简单的画廊实现. 受到 Flipboard App 的样式启发,总想做一个类似的效果试试. 目前实现原理特别简单, 一个自定义 view 加上内部维护的三个 bitmap 对象, 加上手势控制(ACTION_MOVE 和 fling &mdash; VelocityTracker)以及 camera.rotateX","envelopePic":"https://wanandroid.com/blogimgs/b9a57f25-fff5-46dc-8dd8-f822f17abd5b.png","fresh":false,"id":8714,"link":"http://www.wanandroid.com/blog/show/2621","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"https://github.com/chinalwb/flipGallery","publishTime":1563806055000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"简单实现可以翻转的画廊","type":0,"userId":-1,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":338,"size":20,"total":6753}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean  extends BaseBean{
        /**
         * curPage : 1
         * datas : [{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>上一个问题，我们提问了Handler的同步屏障机制，除此以外，还有个比较有意思的对象：<\/p><br><p>IdleHandler<br><\/p><br><p>1. 它有什么能力？<\/p><p>2. 它有什么用处？<\/p><p>3. 能想到一些合适的场景么。<\/p><br><p>本周2/3.<\/p><br><p>本计划这周把编辑器改成markdown的，不过忘了带电脑回家，目测需要到8月中旬了。<\/p><br>","envelopePic":"","fresh":true,"id":8723,"link":"https://www.wanandroid.com/wenda/show/8723","niceDate":"13小时前","origin":"","prefix":"","projectLink":"","publishTime":1564060179000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 听说过Handler中的IdleHandler吗？","type":0,"userId":2,"visible":1,"zan":9},{"apkLink":"","author":"shifujun","chapterId":473,"chapterName":"Shadow","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":true,"id":8734,"link":"https://juejin.im/post/5d2ec812e51d45778f076de3","niceDate":"15小时前","origin":"","prefix":"","projectLink":"","publishTime":1564052514000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Shadow对插件包管理的设计","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":" shifujun","chapterId":473,"chapterName":"Shadow","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8733,"link":"https://juejin.im/post/5d37dcf1e51d4510664d17d4","niceDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1563975504000,"superChapterId":461,"superChapterName":"常见开源库源码解析","tags":[],"title":"Shadow对PackageManager的处理方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"键盘上的麒麟臂","chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8732,"link":"https://www.jianshu.com/p/df44146d636e","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563895948000,"superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle终于懂了（一）带你玩转Project","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"CPPAlien","chapterId":198,"chapterName":"基础概念","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8731,"link":"https://www.jianshu.com/p/ba127b56811b","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563895356000,"superChapterId":168,"superChapterName":"基础知识","tags":[],"title":"Android主项目和Module中R类的区别","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"FeelsChaotic","chapterId":229,"chapterName":"AOP","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8730,"link":"https://www.jianshu.com/p/0f1c7b3e907f","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563894820000,"superChapterId":227,"superChapterName":"注解 & 反射 & AOP","tags":[],"title":"AOP 最后一块拼图 | AST 抽象语法树 &mdash;&mdash; 最轻量级的AOP方法","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"占小狼","chapterId":245,"chapterName":"集合相关","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8729,"link":"https://www.jianshu.com/p/e694f1e868ec","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893981000,"superChapterId":245,"superChapterName":"Java深入","tags":[],"title":"谈谈ConcurrentHashMap1.7和1.8的不同实现","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AxeChen","chapterId":70,"chapterName":"retrofit","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8728,"link":"https://www.jianshu.com/p/2e8b400909b7","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893947000,"superChapterId":98,"superChapterName":"网络访问","tags":[],"title":"封装Retrofit2+RxJava2网络请求框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Anlia","chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8727,"link":"https://www.jianshu.com/p/db01b37b6231","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893846000,"superChapterId":94,"superChapterName":"自定义控件","tags":[],"title":"Android知识总结&mdash;&mdash;Path常用方法解析","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"叫我怪兽好了","chapterId":478,"chapterName":"DataBinding","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8726,"link":"https://juejin.im/post/5d3697f8f265da1bad57468c","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893818000,"superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"看一看 DataBinding","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"Carson_Ho","chapterId":470,"chapterName":"协程","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8725,"link":"https://blog.csdn.net/carson_ho/article/details/96965702","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893764000,"superChapterId":470,"superChapterName":"Kotlin","tags":[],"title":"Android：这是一份全面 &amp; 详细的Kotlin入门学习指南","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"GitCode8","chapterId":228,"chapterName":"辅助 or 工具类","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8724,"link":"https://juejin.im/post/5d307615f265da1b6b1d0dd9","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563893740000,"superChapterId":135,"superChapterName":"项目必备","tags":[],"title":"代码洁癖症的我，学习Lint学到心态爆炸","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>1. 首先至少要知道<span style=\"font-size: 16px;\">同步屏障机制是什么？<\/span><\/p><br><p>2. 思考下，为什么要有这个机制？<\/p><br><p>本周1/3，家有喜事，最近熬夜已懵逼。<\/p>","envelopePic":"","fresh":false,"id":8710,"link":"https://www.wanandroid.com/wenda/show/8710","niceDate":"2天前","origin":"","prefix":"","projectLink":"","publishTime":1563874193000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日问答 Handler应该是大家再熟悉不过的类了，那么其中有个同步屏障机制，你了解多少呢？","type":0,"userId":2,"visible":1,"zan":17},{"apkLink":"","author":"AlexLiuSheng","chapterId":340,"chapterName":"硬件相关","collect":false,"courseId":13,"desc":"本框架只适用于支持蓝牙3.0协议的设备进行数据连接传输，也就是通常说的经典蓝牙，通常手机与手机之间的连接都属于经典蓝牙模式范畴，而一般连接外设耳机等设备，大多 属于BLE蓝牙（低功耗蓝牙），这两种蓝牙除了名字有相同之外，通信方式、原理、协议完全不一样。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8722,"link":"http://www.wanandroid.com/blog/show/2629","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/AlexLiuSheng/EasyBluetoothFrame","publishTime":1563870177000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=340"}],"title":"一款适用经典蓝牙的快速开发框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"teprinciple","chapterId":358,"chapterName":"项目基础功能","collect":false,"courseId":13,"desc":"Kotlin开发，支持AndroidX 、Md5签名验证、自定义UI、自动删除安装包、通知栏图片自定义；适配中英文，支持Android9.0\r\n","envelopePic":"https://wanandroid.com/blogimgs/92ca6ece-6ed7-4a2e-a071-7c161f50d788.png","fresh":false,"id":8721,"link":"http://www.wanandroid.com/blog/show/2628","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/teprinciple/UpdateAppUtils","publishTime":1563870010000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=358"}],"title":"一行代码帮你搞定Android版本更新","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"AICareless","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"AopArms编写了Android开发中常用的一套注解，如日志、异步处理、缓存、SP、延迟操作、定时任务、重试机制、try-catch安全机制、过滤频繁点击、拦截等，后续还会有更多更强大的注解功能加入\r\n","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8719,"link":"http://www.wanandroid.com/blog/show/2626","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/AICareless/AopArms","publishTime":1563869938000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AopArms一款基于AOP的Android注解框架","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"cn-ljb","chapterId":385,"chapterName":"架构","collect":false,"courseId":13,"desc":"快捷、高效、低耦合的Android MVP架构。\r\n\r\n* 支持Java、Kotlin混编；\r\n* 支持自动生成代码。","envelopePic":"https://wanandroid.com/blogimgs/297e7e42-cad3-4e9c-b37b-d2d16c3fe5be.png","fresh":false,"id":8718,"link":"http://www.wanandroid.com/blog/show/2625","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/cn-ljb/mvp-kotlin","publishTime":1563869908000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=385"}],"title":"Kotlin-MVP架构 -  支持Kotlin&amp;Java混编、支持代码自动生成","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"mCyp","chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"Android Jetpack + MVVM 构建的项目","envelopePic":"https://wanandroid.com/blogimgs/1b695b09-7220-4b68-ad08-3e2009335493.png","fresh":false,"id":8717,"link":"http://www.wanandroid.com/blog/show/2624","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/mCyp/Hoo","publishTime":1563869830000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"项目从零到一，Android Jetpack就够了","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"lulululbj","chapterId":367,"chapterName":"资源聚合类","collect":false,"courseId":13,"desc":"该类库利用 Kotlin 语言特性合理封装了 Android 开发中的常用操作，同时也收集了开发过程中的常用工具类。 旨在做同样的事情，写最少的代码，提升开发效率。","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"id":8716,"link":"http://www.wanandroid.com/blog/show/2623","niceDate":"2天前","origin":"","prefix":"","projectLink":"https://github.com/lulululbj/AndroidUtilCodeKTX","publishTime":1563869719000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=367"}],"title":"AndroidUtilCodeKTX ！是时候提升你的开发效率了 ！(持续更新中...)","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"chinalwb","chapterId":323,"chapterName":"动画","collect":false,"courseId":13,"desc":"这是一个简单的画廊实现. 受到 Flipboard App 的样式启发,总想做一个类似的效果试试. 目前实现原理特别简单, 一个自定义 view 加上内部维护的三个 bitmap 对象, 加上手势控制(ACTION_MOVE 和 fling &mdash; VelocityTracker)以及 camera.rotateX","envelopePic":"https://wanandroid.com/blogimgs/b9a57f25-fff5-46dc-8dd8-f822f17abd5b.png","fresh":false,"id":8714,"link":"http://www.wanandroid.com/blog/show/2621","niceDate":"2019-07-22","origin":"","prefix":"","projectLink":"https://github.com/chinalwb/flipGallery","publishTime":1563806055000,"superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=323"}],"title":"简单实现可以翻转的画廊","type":0,"userId":-1,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 338
         * size : 20
         * total : 6753
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean extends BaseBean {
            /**
             * apkLink :
             * author : xiaoyang
             * chapterId : 440
             * chapterName : 官方
             * collect : false
             * courseId : 13
             * desc : <p>上一个问题，我们提问了Handler的同步屏障机制，除此以外，还有个比较有意思的对象：</p><br><p>IdleHandler<br></p><br><p>1. 它有什么能力？</p><p>2. 它有什么用处？</p><p>3. 能想到一些合适的场景么。</p><br><p>本周2/3.</p><br><p>本计划这周把编辑器改成markdown的，不过忘了带电脑回家，目测需要到8月中旬了。</p><br>
             * envelopePic :
             * fresh : true
             * id : 8723
             * link : https://www.wanandroid.com/wenda/show/8723
             * niceDate : 13小时前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1564060179000
             * superChapterId : 440
             * superChapterName : 问答
             * tags : [{"name":"问答","url":"/article/list/0?cid=440"}]
             * title : 每日一问 听说过Handler中的IdleHandler吗？
             * type : 0
             * userId : 2
             * visible : 1
             * zan : 9
             */

            private String apkLink;
            private String author;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String envelopePic;
            private boolean fresh;
            private int id;
            private String link;
            private String niceDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<TagsBean> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean getCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean getFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<TagsBean> getTags() {
                return tags;
            }

            public void setTags(List<TagsBean> tags) {
                this.tags = tags;
            }

            public static class TagsBean extends BaseBean {
                /**
                 * name : 问答
                 * url : /article/list/0?cid=440
                 */

                private String name;
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
