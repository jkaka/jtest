package com.kaka.jtest.designpatter.chain.exmaple;

/**
 * @author: jsk
 * @date: 2019/8/11 13:46
 */
public class ComplainClient {
    public static void main(String[] args) {
        // 1.构造处理器链
        AbstractComplaintHandler artificialHandler = new ArtificialHandler(null);
        AbstractComplaintHandler suggestHandler = new SuggestHandler(artificialHandler);
        AbstractComplaintHandler badLanguageHandler = new BadLanguageHandler(suggestHandler);

        // 2.创建玩家的投诉,并交给处理器链处理
        Complain complain = new Complain("脏话", null);
        badLanguageHandler.handlerRequest(complain);

        complain = new Complain("玩家建议", null);
        badLanguageHandler.handlerRequest(complain);

        complain = new Complain("玩家建议", "我们队伍的提莫,不但故意送人头还骂人,请官方严肃处理。");
        badLanguageHandler.handlerRequest(complain);
    }
}
