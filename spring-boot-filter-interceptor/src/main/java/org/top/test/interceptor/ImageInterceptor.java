package org.top.test.interceptor;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.top.test.enums.ErrorCode;
import org.top.test.excepiton.ServerException;
import org.top.test.utils.OssTemplate;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
@Slf4j
public class ImageInterceptor implements HandlerInterceptor {

    @Resource
    private OssTemplate ossTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            MultipartFile file = new StandardServletMultipartResolver().resolveMultipart(request).getFile("file");
            // 添加水印
            if (file != null) {
                addWatermark(file,request,response);
                return true; // 继续请求处理
            }else{
            throw new ServerException(ErrorCode.IMAGE_ERROR);
            }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 生成指定url对应的二维码到文件，宽和高都是300像素  最后的路径是二维码储存的路径
        String path = (String) request.getAttribute("path");
        System.out.println(path);
        QrCodeUtil.generate(path, 300, 300, FileUtil.file("D:\\demo\\springdemo\\spring-boot-learning\\spring-boot-filter-interceptor\\src\\main\\resources\\qrCode\\qrcode.jpg"));

    }

    private void addWatermark(MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 将文件输入流转换为 Image 对象
        Image image = ImgUtil.read(file.getInputStream());

        //添加水印
        Image image1 = ImgUtil.pressText(image,
                "id:"+response.getHeader("userId")+" 昵称:" + response.getHeader("nickname"), Color.WHITE, // 文字
                new Font("Arial", Font.PLAIN, 20), // 指定字体为 Arial、普通样式、字体大小为 20
                0, // x坐标修正值
                0, // y坐标修正值
                0.8f // 透明度
        );

        // 将 Image 对象转换为流的形式
        InputStream inputStream = imageToInputStream(image1);

        // 上传处理后的图片到 OSS 或其他存储位置
        String path = ossTemplate.ossUpload2(inputStream, file.getOriginalFilename());

        request.setAttribute("path",path);
    }

    private InputStream imageToInputStream(Image image) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            // 将 Image 对象写入 ByteArrayOutputStream
            ImageIO.write((RenderedImage) image, "jpg", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将 ByteArrayOutputStream 转换为 ByteArrayInputStream

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

}