package com.readbook.mapper;

import com.readbook.pojo.RbReservation;
import com.readbook.pojo.RbReservationExample;
import com.readbook.pojo.RbReservationKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;

public interface RbReservationMapper {
	int countByExample(RbReservationExample example);

    int deleteByExample(RbReservationExample example);

    int deleteByPrimaryKey(String reservationId);

    int insert(RbReservation record);

    int insertSelective(RbReservation record);

    List<RbReservation> selectByExample(RbReservationExample example);

    RbReservation selectByPrimaryKey(String reservationId);

    int updateByExampleSelective(@Param("record") RbReservation record, @Param("example") RbReservationExample example);

    int updateByExample(@Param("record") RbReservation record, @Param("example") RbReservationExample example);

    int updateByPrimaryKeySelective(RbReservation record);

    int updateByPrimaryKey(RbReservation record);
    
	List<RbReservation> getReservationsByRankby(@Param("rankby")String rankby);

	List<RbReservation> checkIfOrdered(String userId, String bookId);

	List<RbReservation> getRbservationsByCondition(String userId, int state,
			int stu_num, int page_size);

	void updateSuccessCheckState(@Param("reservationId")String reservationId);

	String checkIsTwoBook(@Param("userId")String userId);

	String getStateById(@Param("reservationId")String reservationId);

	void updateStateToThree(@Param("reservationId")String reservationId);

	void updateStateToFive(@Param("reservationId")String reservationId);

	List<RbReservation> getAllRbservations(String userId, int stu_num,
			int page_size);

	int getTotalCount(@Param("randby")int randby);

	List<RbReservation> getReservationList(@Param("randby")int randby, @Param("index")int index, @Param("count")int count);

	List<RbReservation> getBeforeResturnReservation();

	void updateRemind(int i, String id);
}