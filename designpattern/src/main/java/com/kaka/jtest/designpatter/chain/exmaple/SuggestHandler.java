package com.kaka.jtest.designpatter.chain.exmaple;

/**
 * 玩家建议处理器
 *
 * @author: jsk
 * @date: 2019/8/11 13:24
 */
public class SuggestHandler extends AbstractComplaintHandler {
    public SuggestHandler(AbstractComplaintHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handlerRequest(Complain complain) {
        System.out.println("【玩家建议】处理器开始处理...");
        if ("玩家建议".equals(complain.getType())) {
            if (complain.getMessage() == null || "".equals(complain.getMessage())) {
                System.out.println("建议为空,无需处理！");
                return;
            }
        } else {
            System.out.println("投诉类型不是【玩家建议】,交由后面的处理器处理！");
        }
        this.getNextHandler().handlerRequest(complain);
    }
}
