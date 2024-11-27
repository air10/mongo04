package com.louis.mango.admin.dao;

import java.util.List;

import com.louis.mango.admin.model.SysUser;

public interface SysUserMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_user
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_user
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int insert(SysUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_user
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int insertSelective(SysUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_user
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	SysUser selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_user
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int updateByPrimaryKeySelective(SysUser record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_user
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int updateByPrimaryKey(SysUser record);

	/**
     * 查询全部
     * @return
     */
    List<SysUser> findAll();
    
    List<SysUser> findPage();
}