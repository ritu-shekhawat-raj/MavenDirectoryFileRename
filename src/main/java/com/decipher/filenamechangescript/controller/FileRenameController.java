package com.decipher.filenamechangescript.controller;

import com.decipher.filenamechangescript.service.FileRenameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@Controller
public class FileRenameController {

    private final FileRenameService fileRenameService;

    @Autowired
    public FileRenameController(FileRenameService fileRenameService) {
        this.fileRenameService = fileRenameService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("filesInDir", fileRenameService.getFilesInDirectory());
        return "home";
    }

    @GetMapping("/file-rename")
    public String renameFile(@RequestParam("projectName") String projectName) throws IOException {
        fileRenameService.getRenamedFile(projectName);
        return "file-rename";
    }
}
