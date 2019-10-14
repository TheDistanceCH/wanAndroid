package com.wanandroid.app.chwanandroid.mine.bean;

import com.wanandroid.app.chwanandroid.base.basehttp.BaseBean;

import java.util.List;

/**
 * create time on  2019/8/12
 * function:
 */
public class UserBean extends BaseBean {

    /**
     * data : {"admin":false,"chapterTops":[],"collectIds":[8537,8824,8823,8822,8812,8717,8832,8831,8830,8829,8811,8658,8547,8904,8895,8894,8893,8892,8891],"email":"","icon":"","id":27930,"nickname":"13400000000","password":"","token":"","type":0,"username":"13400000000"}
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

    public static class DataBean extends BaseBean {
        /**
         * admin : false
         * chapterTops : []
         * collectIds : [8537,8824,8823,8822,8812,8717,8832,8831,8830,8829,8811,8658,8547,8904,8895,8894,8893,8892,8891]
         * email :
         * icon :
         * id : 27930
         * nickname : 13400000000
         * password :
         * token :
         * type : 0
         * username : 13400000000
         */

        private boolean admin;
        private String email;
        private String icon;
        private int id;
        private String nickname;
        private String password;
        private String token;
        private int type;
        private String username;
        private List<?> chapterTops;
        private List<Integer> collectIds;
        private String publicName;

        public String getPublicName() {
            return publicName;
        }

        public void setPublicName(String publicName) {
            this.publicName = publicName;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<?> getChapterTops() {
            return chapterTops;
        }

        public void setChapterTops(List<?> chapterTops) {
            this.chapterTops = chapterTops;
        }

        public List<Integer> getCollectIds() {
            return collectIds;
        }

        public void setCollectIds(List<Integer> collectIds) {
            this.collectIds = collectIds;
        }
    }
}
