package com.kaka.jtest.git;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 17:34
 */
public class DiffTest {
	/**
	 * git diff：此命令比较的是工作目录(Working tree)和暂存区域快照(index)之间的差异
	 * 		本地修改的文件，需要使用"git add ."来添加到暂存区(新建的文件，idea可能会自动添加到stage)
	 * git diff --cached：查看已经暂存起来的文件(staged)和上次提交时的快照之间(HEAD)的差异
	 * git diff HEAD：显示工作版本(Working tree)和HEAD的差别
	 * git diff test：查看当前目录和另外一个分支的差别
	 * git diff HEAD^ HEAD：比较上次提交commit和上上次提交
	 * git diff SHA1 SHA2：比较两个历史版本之间的差异
	 *
	 * git diff --stat：查看简单的diff结果，不显示具体的修改内容
	 */
}
