package rpc.controller.view.models;

import rpc.controller.view.models.params.ParamModel;

public class EmcContext {
    /**
     * 区块请求序列号
     */
    private String chainSeq;

    /**
     * 请求节点号
     */
    private String peerNo;

    /**
     * 算力请求参数
     * AI promots
     */
    private ParamModel paramModel;

    public String getChainSeq() {
        return chainSeq;
    }

    public void setChainSeq(String chainSeq) {
        this.chainSeq = chainSeq;
    }

    public String getPeerNo() {
        return peerNo;
    }

    public void setPeerNo(String peerNo) {
        this.peerNo = peerNo;
    }

    public ParamModel getParamModel() {
        return paramModel;
    }

    public void setParamModel(ParamModel paramModel) {
        this.paramModel = paramModel;
    }


}
