1. **设置config**
    * 配置开发者名称：git config --global user.name "jkaka"
    * 配置开发者邮箱：git config --global user.email "395159947@qq.com"
    
        不带--global参数，默认是给单独的代码库设置config
2. **查看config**
    * 查看系统config：git config --system --list

    * 查看当前用户（global）配置：git config --global  --list
 
    * 查看当前仓库配置信息：git config --local  --list

3. **生成ssh公钥**：ssh-keygen -t rsa -C "395159947@qq.com"
