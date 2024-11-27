package com.louis.mango.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.louis.mango.admin.model.SysDict;

public interface SysDictMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_dict
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_dict
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int insert(SysDict record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_dict
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int insertSelective(SysDict record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_dict
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	SysDict selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_dict
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int updateByPrimaryKeySelective(SysDict record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table mango..sys_dict
	 * @mbg.generated  Sun Nov 24 23:22:54 CST 2024
	 */
	int updateByPrimaryKey(SysDict record);
	
    List<SysDict> findPage();
    
    List<SysDict> findPageByLabel(@Param(value="label") String label);

    List<SysDict> findByLable(@Param(value="label") String label);
}