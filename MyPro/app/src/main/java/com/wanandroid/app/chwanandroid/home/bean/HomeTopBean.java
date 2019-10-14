package com.wanandroid.app.chwanandroid.home.bean;

import com.wanandroid.app.chwanandroid.base.basehttp.BaseBean;

import java.util.List;

/**
 * create time on  2019/7/25
 * function:
 */
public class HomeTopBean extends BaseBean {

    /**
     * data : [{"apkLink":"","author":"鸿洋","chapterId":361,"chapterName":"课程推荐","collect":false,"courseId":13,"desc":"","envelopePic":"","fresh":false,"id":8537,"link":"https://market.geekbang.org/activity/channelcoupon/15?utm_source=web&amp;utm_medium=wananzhuo&amp;utm_campaign=changweiliuliang&amp;utm_term=zhanghongyang003&amp;utm_content=0530","niceDate":"2019-07-14","origin":"","prefix":"","projectLink":"","publishTime":1563111162000,"superChapterId":249,"superChapterName":"干货资源","tags":[],"title":"跟极客时间申请了一波199优惠券免费送 每人仅能领取一次","type":1,"userId":-1,"visible":1,"zan":0},{"apkLink":"","author":"xiaoyang","chapterId":440,"chapterName":"官方","collect":false,"courseId":13,"desc":"<p>一次在把app module修改为lib module时发现，switch竟然要改成if else ，从而发现这个问题。<\/p><br><p>为什么呢？<\/p><br><p>有什么好的解决方案？<\/p>","envelopePic":"","fresh":true,"id":8735,"link":"https://www.wanandroid.com/wenda/show/8735","niceDate":"38分钟前","origin":"","prefix":"","projectLink":"","publishTime":1564060172000,"superChapterId":440,"superChapterName":"问答","tags":[{"name":"问答","url":"/article/list/0?cid=440"}],"title":"每日一问 为什么Android app module下的R.java中变量为final，而lib module中R.java中的变量非final呢？","type":1,"userId":2,"visible":1,"zan":0}]
     * errorCode : 0
     * errorMsg :
     */

    private int errorCode;
    private String errorMsg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends BaseBean {
        /**
         * apkLink :
         * author : 鸿洋
         * chapterId : 361
         * chapterName : 课程推荐
         * collect : false
         * courseId : 13
         * desc :
         * envelopePic :
         * fresh : false
         * id : 8537
         * link : https://market.geekbang.org/activity/channelcoupon/15?utm_source=web&amp;utm_medium=wananzhuo&amp;utm_campaign=changweiliuliang&amp;utm_term=zhanghongyang003&amp;utm_content=0530
         * niceDate : 2019-07-14
         * origin :
         * prefix :
         * projectLink :
         * publishTime : 1563111162000
         * superChapterId : 249
         * superChapterName : 干货资源
         * tags : []
         * title : 跟极客时间申请了一波199优惠券免费送 每人仅能领取一次
         * type : 1
         * userId : -1
         * visible : 1
         * zan : 0
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


        public static class TagsBean extends BaseBean{
            /**
             * "tags": [{
             * 			"name": "问答",
             * 			"url": "/article/list/0?cid=440"
             *                }],
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
