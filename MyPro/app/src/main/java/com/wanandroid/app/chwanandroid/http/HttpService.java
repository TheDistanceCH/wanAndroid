package com.wanandroid.app.chwanandroid.http;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * create time on  2019/7/16
 * function:  网络请求接口
 * <p>
 * 备注：规范调整：所有接口网络请求方法以find开头
 */
public interface HttpService {

    /**
     * 首页部分
     */

    //banner
    @GET("banner/json")
    Observable<String> findHomeBanner();

    //置顶文章
    @GET("article/top/json")
    Observable<String> findTopArticle();

    //文章列表
    @GET("article/list/{page}/json")
    Observable<String> findArticle(@Path("page") int page);


    /**
     * 搜索文章、常见网站部分
     */

    //常用网站
    @GET("friend/json")
    Observable<String> findUsuallyWebSize();

    //热词搜索
    @GET("hotkey/json")
    Observable<String> findHotKeySearch();


    /**
     * 微信公众号部分
     */

    //获取微信列表
    @GET("wxarticle/chapters/json")
    Observable<String> findWXTitleList();

    //查询某个公众号的历史数据
    @GET("wxarticle/list/{weixin}/{page}/json")
    Observable<String> findWXList(@Path("weixin") int weixin,
                                  @Path("page") int page);

    //搜索某个公众号下的含有xxx关键字的数据
    @GET("wxarticle/list/{weixin}/{page}/json")
    Observable<String> findWXSearchList(@Path("weixin") int weixin,
                                        @Path("page") int page,
                                        @Query("k") String s);

    //导航
    @GET("navi/json")
    Observable<String> findNavigation();


    //项目
    @GET("project/tree/json")
    Observable<String> findProjectTitle();

    //项目分类下的列表
    @GET("project/list/{page}/json")
    Observable<String> findProjectList(@Path("page") int page,
                                       @Query("cid") int cid);


    //登录
    @FormUrlEncoded
    @POST("user/login")
    Observable<String> findLogin(@Field("username") String username,
                                 @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("user/register")
    Observable<String> findRegist(@Field("username") String username,
                                  @Field("password") String password,
                                  @Field("repassword") String repassword);

    //退出
    @GET("user/logout/json")
    Observable<String> findExit();


    //收藏站内文章
    @FormUrlEncoded
    @POST("lg/collect/{id}/json")
    Observable<String> findCollectSiteOn(@Path("id") String id);


    //收藏站外文章
    @FormUrlEncoded
    @POST("lg/collect/add/json")
    Observable<String> findCollectSiteOut(@Field("title") String title,
                                          @Field("author") String author,
                                          @Field("link") String link);

}
