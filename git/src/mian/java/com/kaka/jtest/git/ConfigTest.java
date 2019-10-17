package com.kaka.jtest.git;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-16 16:07
 */
public class ConfigTest {
	/**
	 * 不同操作系统，换行符不一致问题
	 * 背景：在各操作系统下，文本文件所使用的换行符是不一样的。UNIX/Linux 使用的是 0x0A（LF），早期的 Mac OS 使用的是0x0D（CR），
	 * 后来的 OS X 在更换内核后与 UNIX 保持一致了。但 DOS/Windows 一直使用 0x0D0A（CRLF）作为换行符。
	 *
	 * 查看当前idea使用的换行符，可以打开文件查看右下角的标志(CRLF/LF/CR)
	 * 设置idea换行符：setting->editor->code style-> Line separator
	 *
	 * 1. 提交时转换为LF，检出时转换为CRLF
	 * git config --global core.autocrlf true
	 *
	 * 2. 提交时转换为LF，检出时不转换
	 * git config --global core.autocrlf input
	 *
	 * 3. 提交检出均不转换
	 * git config --global core.autocrlf false
	 */
}
