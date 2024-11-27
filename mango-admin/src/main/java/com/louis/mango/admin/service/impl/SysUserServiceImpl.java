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
   	
   	@Override
	public File createUserExcelFile(PageRequest pageRequest) {
		PageResult pageResult = findPage(pageRequest);
		return createUserExcelFile(pageResult.getContent());
	}
   	
   	public static File createUserExcelFile(List<?> records) {
		if (records == null) {
			records = new ArrayList<>();
		}
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row0 = sheet.createRow(0);
		int columnIndex = 0;
		row0.createCell(columnIndex).setCellValue("No");
		row0.createCell(++columnIndex).setCellValue("ID");
		row0.createCell(++columnIndex).setCellValue("用户名");
		row0.createCell(++columnIndex).setCellValue("昵称");
		row0.createCell(++columnIndex).setCellValue("机构");
		row0.createCell(++columnIndex).setCellValue("角色");
		row0.createCell(++columnIndex).setCellValue("邮箱");
		row0.createCell(++columnIndex).setCellValue("手机号");
		row0.createCell(++columnIndex).setCellValue("状态");
		row0.createCell(++columnIndex).setCellValue("头像");
		row0.createCell(++columnIndex).setCellValue("创建人");
		row0.createCell(++columnIndex).setCellValue("创建时间");
		row0.createCell(++columnIndex).setCellValue("最后更新人");
		row0.createCell(++columnIndex).setCellValue("最后更新时间");
		for (int i = 0; i < records.size(); i++) {
			SysUser user = (SysUser) records.get(i);
			Row row = sheet.createRow(i + 1);
			for (int j = 0; j < columnIndex + 1; j++) {
				row.createCell(j);
			}
			columnIndex = 0;
			row.getCell(columnIndex).setCellValue(i + 1);
			row.getCell(++columnIndex).setCellValue(user.getId());
			row.getCell(++columnIndex).setCellValue(user.getName());
			row.getCell(++columnIndex).setCellValue(user.getNickName());
			row.getCell(++columnIndex).setCellValue(user.getDeptName());
			row.getCell(++columnIndex).setCellValue(user.getRoleNames());
			row.getCell(++columnIndex).setCellValue(user.getEmail());
			row.getCell(++columnIndex).setCellValue(user.getStatus());
			row.getCell(++columnIndex).setCellValue(user.getAvatar());
			row.getCell(++columnIndex).setCellValue(user.getCreateBy());
			row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getCreateTime()));
			row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());
			row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getLastUpdateTime()));
		}
		return PoiUtils.createExcelFile(workbook, "download_user");
	}
    
}