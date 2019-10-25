package com.kaka.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @author jiashuangkai
 * @version 1.0
 * @since 2019-10-23 12:23
 */
public class RetryUtil {
	private static final Logger LOG = LoggerFactory.getLogger(RetryUtil.class);

	private static final long INITIAL_BACKOFF = 500;
	private static final long MAX_BACKOFF = 5000;
	private static final int MAX_ATTEMPTS = 20;

	private RetryUtil() {
	}

	private static void waitForMs(long sleepMs) {
		try {
			Thread.sleep(sleepMs);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	static <T> T call(Callable<T> callable, String errorMsg, String retryMsg, String retryNumber) throws Exception {
		int counter = 0;
		long backoff = INITIAL_BACKOFF;
		do {
			try {
				return callable.call();
			} catch (Exception e1) {
				if (counter >= MAX_ATTEMPTS) {
					System.out.println("超过最大重试次数！");
					throw e1;
				}
				LOG.error("{}, retry {}/{}", errorMsg, counter, MAX_ATTEMPTS, e1);
				counter++;
			}
			waitForMs(backoff);
			backoff = Math.min(backoff * 2, MAX_BACKOFF);
		} while (true);
	}
}
