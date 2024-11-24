package com.louis.mango.admin.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.louis.mango.admin.dao.SysUserMapper;
import com.louis.mango.admin.model.SysUser;
import com.louis.mango.admin.service.SysUserService;
import com.louis.mango.common.utils.DateTimeUtils;
import com.louis.mango.common.utils.PoiUtils;
import com.louis.mango.core.page.MybatisPageHelper;
import com.louis.mango.core.page.PageRequest;
import com.louis.mango.core.page.PageResult;

@Service
public class SysUserServiceImpl implements SysUserService {
    
	@Autowired
	private SysUserMapper sysUserMapper;
	
    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }
    
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysUserMapper);
    }
    
    
    @Transactional
   	@Override
   	public int save(SysUser record) {
   		Long id = null;
   		if(record.getId() == null || record.getId() == 0) {
   			// 新增用户
   			sysUserMapper.insertSelective(record);
   			id = record.getId();
   		} else {
   			// 更新用户信息
   			sysUserMapper.updateByPrimaryKeySelective(record);
   		}
//   		// 更新用户角色
//   		if(id != null && id == 0) {
//   			return 1;
//   		}
//   		if(id != null) {
//   			for(SysUserRole sysUserRole:record.getUserRoles()) {
//   				sysUserRole.setUserId(id);
//   			}
//   		} else {
//   			sysUserRoleMapper.deleteByUserId(record.getId());
//   		}
//   		for(SysUserRole sysUserRole:record.getUserRoles()) {
//   			sysUserRoleMapper.insertSelective(sysUserRole);
//   		}
   		return 1;
   	}

   	@Override
   	public int delete(SysUser record) {
   		return sysUserMapper.deleteByPrimaryKey(record.getId());
   	}

   	@Override
   	public int delete(List<SysUser> records) {
   		for(SysUser record:records) {
   			delete(record);
   		}
   		return 1;
   	}

   	@Override
   	public SysUser findById(Long id) {
   		return sysUserMapper.selectByPrimaryKey(id);
   	}
    
}