package com.louis.mango.admin.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.common.utils.FileUtils;
import com.louis.mango.core.http.HttpResult;
import com.louis.mango.core.page.PageRequest;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    
    @GetMapping(value="/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }
     
    @PostMapping(value="/findPage")
   	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
   		return HttpResult.ok(sysUserService.findPage(pageRequest));
   	}
    
    @PostMapping(value="/exportExcelUser")
	public void exportExcelUser(@RequestBody PageRequest pageRequest,HttpServletResponse res) {
    	File file=sysUserService.createUserExcelFile(pageRequest);
    	FileUtils.downloadFile(res, file, file.getName());
	}
    
}