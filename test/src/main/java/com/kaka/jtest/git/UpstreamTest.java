package com.kaka.jtest.git;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-25 20:13
 */
public class UpstreamTest {
	/**
	 * git remote -v      查看远程代码库状态。
	 * git remote add upstream https://github.com/***.git     设置fork库的上游代码库地址
	 * git pull upstream master-2.x    拉取上游分支最新代码
	 * git fetch upstream   从上游仓库 fetch 分支和提交点，传送到本地，并会被存储在一个本地分支 upstream/master
	 * git checkout master     切换到本地主分支
	 * git merge upstream/master    把 upstream/master 分支合并到本地 master 上
	 */
}
