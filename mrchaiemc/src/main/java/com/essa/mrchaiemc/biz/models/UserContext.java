package com.essa.mrchaiemc.biz.models;

public class UserContext {
    private String userId;

    private boolean hasLogin;

    private String currEmcChainSeq;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isHasLogin() {
        return hasLogin;
    }

    public void setHasLogin(boolean hasLogin) {
        this.hasLogin = hasLogin;
    }

    public String getCurrEmcChainSeq() {
        return currEmcChainSeq;
    }

    public void setCurrEmcChainSeq(String currEmcChainSeq) {
        this.currEmcChainSeq = currEmcChainSeq;
    }
}
