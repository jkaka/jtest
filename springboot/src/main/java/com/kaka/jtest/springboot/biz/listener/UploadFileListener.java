package com.kaka.jtest.springboot.biz.listener;

import com.sun.javaws.progress.Progress;
import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author jsk
 * @Date 2018/8/20 17:08
 */
@Component
public class UploadFileListener implements ProgressListener {

    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        //保存上传状态
        Progress status = new Progress();
        session.setAttribute("status", status);
    }

    @Override
    public void update(long pBytesRead, long pContentLength, int pItems) {
        System.out.println("-----------------------");
        System.out.println(pBytesRead);
        System.out.println(pContentLength);
        System.out.println(pItems);
    }
}
