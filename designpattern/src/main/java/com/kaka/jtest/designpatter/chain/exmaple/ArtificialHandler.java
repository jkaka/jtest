package com.kaka.jtest.designpatter.chain.exmaple;

/**
 * 人工处理器
 *
 * @author: jsk
 * @date: 2019/8/11 13:24
 */
public class ArtificialHandler extends AbstractComplaintHandler {
    public ArtificialHandler(AbstractComplaintHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handlerRequest(Complain complain) {
        System.out.println("【人工】处理器处理玩家的投诉...");
        System.out.println("【人工】处理器处理结束");
    }
}
