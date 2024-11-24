package com.louis.mango.admin.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.louis.mango.admin.model.SysUser;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.service.CurdService;

public interface SysUserService {

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();
    


}