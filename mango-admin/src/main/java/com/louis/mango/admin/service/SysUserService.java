package com.louis.mango.admin.service;

import java.io.File;
import java.util.List;
import java.util.Set;

import com.louis.mango.admin.model.SysUser;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.service.CurdService;

public interface SysUserService extends CurdService<SysUser>{

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();
    /**
	 * 生成用户信息Excel文件
	 * @param pageRequest 要导出的分页查询参数
	 * @return
	 */
	File createUserExcelFile(PageRequest pageRequest);
}