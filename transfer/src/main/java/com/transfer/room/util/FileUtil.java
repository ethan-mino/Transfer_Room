package com.transfer.room.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    public static String getUniqueFileName(MultipartFile file) {
        String originalFileName = file.getOriginalFilename();

        String [] filenameDotSplit = originalFileName.split("\\.");
        String baseName = filenameDotSplit[0];
        String extension = filenameDotSplit[1];

        String dateFormat = "yyMMdd-HHmmss";
        String dateFormatStr = new SimpleDateFormat(dateFormat).format(new Date());
        return baseName + "-" + dateFormatStr + "." + extension;
    }

    public static String saveFile(MultipartFile file, String saveDirPath) throws IOException {
        File saveDir = new File(saveDirPath);
        if (!saveDir.exists()) saveDir.mkdirs();

        String realFileName = getUniqueFileName(file);
        File saveFile = new File(saveDir, realFileName);
        file.transferTo(saveFile);
        return saveDir + File.separator + realFileName;
    }

    public static void sendFile(HttpServletResponse response, String contentType, String filePath){ // filePath는 파일명을 포함한 경로
        File file = new File(filePath);
        String fileName = FilenameUtils.getName(filePath);

        String encodedFileName = URLEncoder.encode(fileName).replaceAll("\\+", "%20");  // 한글 파일명을 사용하기 위해 encode
        long fileLength = file.length();

        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFileName + "\";");
        response.setHeader(HttpHeaders.TRANSFER_ENCODING, "binary");
        response.setHeader(HttpHeaders.CONTENT_TYPE, contentType);
        response.setHeader(HttpHeaders.CONTENT_LENGTH, Long.toString(fileLength));
        response.setHeader(HttpHeaders.PRAGMA, "no-cache;");
        response.setHeader(HttpHeaders.EXPIRES, "-1;");

        try(FileInputStream fis = new FileInputStream(filePath);    // 선언된 객체들에 대해서 try가 종료될 때 자동으로 자원을 해제해주는 기능 (fis.close(), out.close()하지 않아도 된다.)
            OutputStream out = response.getOutputStream()){
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while((readCount = fis.read(buffer)) != -1){
                out.write(buffer, 0, readCount);
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("file download Error");
        }
    }
}
