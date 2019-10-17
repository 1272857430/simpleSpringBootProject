package cn.cjd.springboot.testModal.BaseTest.base;

/**
 * @author ponta
 * @date 2018/9/4
 * @email supreme@ponta.io
 */
public enum Mode {
    LOCAL("http://121.196.207.31:21550", "http://120.55.42.62:21200"),
    PRD("http://121.196.207.31:21550", "http://120.55.42.62:21200");

    private String payApiUrl;
    private String notifyUrl;

    Mode(String payApiUrl, String notifyUrl) {
        this.payApiUrl = payApiUrl;
        this.notifyUrl = notifyUrl;
    }

    public String getPayApiUrl() {
        return payApiUrl;
    }

    public void setPayApiUrl(String payApiUrl) {
        this.payApiUrl = payApiUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
