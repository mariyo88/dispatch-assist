package com.firstcode.dispatchassist.controller;

import com.firstcode.dispatchassist.model.User;
import com.firstcode.dispatchassist.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    private final UserService service;

    public ImageController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register/process/image")
    public String uploadImage(Model model, @RequestParam("id") Long id, @RequestParam("avatar") MultipartFile file) {
        User user = service.findById(id);
        try {
            Byte[] bytes = new Byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()) {
                bytes[i++] = b;
            }
            user.setAvatar(bytes);
            service.saveImage(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/profile";
    }

    @GetMapping("/image")
    public void renderImageFromDB(HttpServletResponse response, Authentication authentication) throws IOException {

        User recipeCommand = service.findByUserName(authentication.getName());

        if (recipeCommand.getAvatar() != null) {
            byte[] byteArray = new byte[recipeCommand.getAvatar().length];
            int i = 0;

            for (Byte wrappedByte : recipeCommand.getAvatar()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
