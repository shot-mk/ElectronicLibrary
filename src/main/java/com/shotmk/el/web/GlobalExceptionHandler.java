package com.shotmk.el.web;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public RedirectView handleMyException(MaxUploadSizeExceededException ex,
                                          HttpServletRequest request,
                                          HttpServletResponse response) throws IOException {
        String redirect = "../admin";
        RedirectView rw = new RedirectView(redirect);
        List<String> errorMsgs = new ArrayList<>();
        errorMsgs.add("File is too big. File size must be less then 20Mb.");
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        if (outputFlashMap != null) {
            outputFlashMap.put("errorMsgs", errorMsgs);
        }
        return rw;
    }

}