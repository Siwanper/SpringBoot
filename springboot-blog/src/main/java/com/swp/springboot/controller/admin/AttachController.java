package com.swp.springboot.controller.admin;

import com.swp.springboot.constant.WebConst;
import com.swp.springboot.controller.AbstractController;
import com.swp.springboot.dto.Types;
import com.swp.springboot.exception.TipException;
import com.swp.springboot.modal.bo.RestResponseBo;
import com.swp.springboot.modal.vo.AttachVo;
import com.swp.springboot.modal.vo.UserVo;
import com.swp.springboot.service.IAttachService;
import com.swp.springboot.util.MyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 附件上传
 *
 * @version 1.0.0
 * @outhor ios
 * @create 2018-11-03 9:19 AM
 */
@Controller
@RequestMapping("admin/attach")
public class AttachController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(AttachController.class);

    private static final String CLASSPATH = MyUtils.getUploadFilePath();

    @Resource
    private IAttachService attachService;

    /**
     * 上传附件
     *
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo upload(HttpServletRequest request, @RequestParam("file") MultipartFile[] multipartFiles){
        UserVo userVo = this.user(request);
        Integer uid = userVo.getUid();
        // 记录上传成功的文件信息
        List<AttachVo> attachVoList = new ArrayList<>();

        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String filename = multipartFile.getOriginalFilename();
                logger.info("path : " + CLASSPATH + " filename : " + filename + " ; size : " + multipartFile.getSize());
                if (multipartFile.getSize() <= WebConst.MAX_FILE_SIZE) {
                    // 获取文件相对路径名，并文件目录
                    String fkey = MyUtils.getFileKey(filename);
                    // 判断文件是否是图片
                    String ftype = MyUtils.isImage(multipartFile.getInputStream()) ? Types.IMAGE.getType() : Types.FILE.getType();
                    File file = new File(CLASSPATH + fkey);
                    FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
                    attachService.save(filename, fkey, ftype, uid);
                    AttachVo attachVo = new AttachVo();
                    attachVo.setFkey(fkey);
                    attachVoList.add(attachVo);
                }
            }
        } catch (IOException e) {
            return RestResponseBo.fail("文件上传失败");
        }
        return RestResponseBo.ok(attachVoList);
    }

}
