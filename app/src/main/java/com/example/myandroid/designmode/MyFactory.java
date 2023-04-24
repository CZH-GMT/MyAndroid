package com.example.myandroid.designmode;

/**
 * 工厂模式和策略模式
 */
public class MyFactory {

    private interface call {
        void callName();
    }

    private static class MaYun implements call {
        @Override
        public void callName() {
            System.out.println("马云");
        }
    }

    private static class MaHuaTeng implements call {
        @Override
        public void callName() {
            System.out.println("马化腾");
        }
    }

    private static class YangShuJin implements call {
        @Override
        public void callName() {
            System.out.println("杨树金");
        }
    }


    /**
     * 工厂模式，主要体现在创建对象上多个实现传参确定最终创建
     * @param i
     * @return
     */
    public static call createCall(Integer i) {
        switch (i) {
            case 1:
                return new MaYun();
            case 2:
                return new MaHuaTeng();
            case 3:
                return new YangShuJin();
        }
        return null;
    }


    public static void main(String[] args) {
        call call = MyFactory.createCall(1);
        call.callName();
        System.out.println("-----------------工厂");
        //策略
        CallStrategy callStrategy = new CallStrategy(1);
        callStrategy.run();
    }

    /**
     * 策略模式 主要体现的是过程
     */
    static class CallStrategy {
        private call call;
        private int type;

        public CallStrategy(int type) {
            switch (type) {
                case 1:
                    call = new MaYun();
                    break;
                case 2:
                    call = new MaHuaTeng();
                    break;
                case 3:
                    call = new YangShuJin();
            }
        }

        public void setCall(MyFactory.call call) {
            this.call = call;
        }

        public void run() {
            call.callName();
        }


    }
}
