package command;

import java.util.Set;

public class OrderCommand implements Command {

    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef seniorChef, Order order) {
        this.receiver = seniorChef;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单：");
        Set<String> keys = order.getFoodDic().keySet();
        for (String key : keys) {
            receiver.makeFood(order.getFoodDic().get(key),key);
        }
        try {
            Thread.sleep(100);//停顿一下 模拟做饭的过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(order.getDiningTable() + "桌的饭弄好了");
    }
}
