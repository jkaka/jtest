Javassist是一个开源的分析、编辑和创建Java字节码的类库。是由东京工业大学的数学和计算机科学系的 Shigeru Chiba （千叶 滋）所创建的。
它已加入了开放源代码JBoss 应用服务器项目,通过使用Javassist对字节码操作为JBoss实现动态AOP框架。javassist是jboss的一个子项目，其主要的优点，
在于简单，而且快速。直接使用java编码的形式，而不需要了解虚拟机指令，就能动态改变类的结构，或者动态生成类。


对比: 

hibernate用javassist是因为同一公司产品;spring在用cglib

据说，javassist是在某些测试上，性能慢于cglib。 整体来说应该差不远。

但cglib以停止开发多年。hibernate团队花了一年也无法联系cglib的开发人员