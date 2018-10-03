package com.readbook.mapper;

import com.readbook.pojo.RbBook;
import com.readbook.pojo.RbBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbBookMapper {
    int countByExample(RbBookExample example);

    int deleteByExample(RbBookExample example);

    int deleteByPrimaryKey(String isbn);

    int insert(RbBook record);

    int insertSelective(RbBook record);

    List<RbBook> selectByExampleWithBLOBs(RbBookExample example);

    List<RbBook> selectByExample(RbBookExample example);

    RbBook selectByPrimaryKey(String isbn);

    int updateByExampleSelective(@Param("record") RbBook record, @Param("example") RbBookExample example);

    int updateByExampleWithBLOBs(@Param("record") RbBook record, @Param("example") RbBookExample example);

    int updateByExample(@Param("record") RbBook record, @Param("example") RbBookExample example);

    int updateByPrimaryKeySelective(RbBook record);

    int updateByPrimaryKeyWithBLOBs(RbBook record);

    int updateByPrimaryKey(RbBook record);

	List<RbBook> searchBookByKey(String key, int start_num, int page_size);

	List<RbBook> getBooksByCondition(int randby, int start_num, int page_size);

	void minusBookById(@Param("bookId")String bookId);

	String checkIsStock(@Param("bookId")String bookId);

	void updateReadCntInc(String bookId);

	String getBookNameById(@Param("bookId")String bookId);

	void updteStockInc(@Param("bookId")String bookId);

	String selectStockById(@Param("isbn")String isbn);

	void deleteBookById(@Param("isbn")String isbn);

	void addBookById(@Param("isbn")String isbn);

	int getTotalCount();
}