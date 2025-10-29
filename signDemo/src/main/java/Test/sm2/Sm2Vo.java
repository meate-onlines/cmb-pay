package Test.sm2;

public class Sm2Vo {

    //标准公钥头
    private String sm2_h;
    //裸公钥X
    private String sm2_x;
    //裸公钥Y
    private String sm2_y;

    public Sm2Vo(String sm2_h,String sm2_x,String sm2_y){
        this.sm2_h = sm2_h;
        this.sm2_x = sm2_x;
        this.sm2_y = sm2_y;
    }

    public String getSm2_h() {
        return sm2_h;
    }

    public void setSm2_h(String sm2_h) {
        this.sm2_h = sm2_h;
    }

    public String getSm2_x() {
        return sm2_x;
    }

    public void setSm2_x(String sm2_x) {
        this.sm2_x = sm2_x;
    }

    public String getSm2_y() {
        return sm2_y;
    }

    public void setSm2_y(String sm2_y) {
        this.sm2_y = sm2_y;
    }
}
