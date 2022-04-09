package cc.gaojie.domain;

/**
 * @author gaojie  gao4433@qq.com
 * @Description 帐户实体类
 * @date 2022/4/10 0:17
 * @since 1.8
 */
public class Account {
    private String name;
    private double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
