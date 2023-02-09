package commento.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

@Mapper
public interface StatisticMapper {

    @Select("select count(*) as totCnt from statistics.requestinfo ri where left(ri.createDate, 2) = #{year}")
    HashMap<String, Object> selectYearLogin(@Param("year") Long year);

    @Select("select count(*) as totalCnt " +
            "from statistics.requestinfo ri " +
            "where left(ri.createDate, 6) = #{date} and ri.requestCode = #{requestCode}")
    Long countMonthAccessor(@Param("date") String date, @Param("requestCode") String requestCode);

    @Select("select count(*) as totalCnt " +
            "from statistics.requestinfo ri " +
            "where left(ri.createDate, 6) = #{date} and ri.requestCode = #{requestCode}")
    Long countDayAccessor(@Param("date") String date, @Param("requestCode") String requestCode);

    @Select("select avg(countTable.totalCnt) as avgCnt " +
            "from (" +
            " select count(*) as totalCnt " +
            " from statistics.requestinfo ri " +
            " where ri.requestCode = #{requestCode} " +
            " group by left(ri.createDate, 6) " +
            ") as countTable")
    Long countAvgDayLoginUser(@Param("requestCode") String requestCode);

    @Select("select count(*) as totalCnt " +
            "from statistics.requestinfo as r " +
            "left outer join statistics.holiday as h " +
            "on left(r.createDate, 6) = h.holiday_date " +
            "where h.id is null and left(r.createDate, 4) = #{date}")
    Long countLoginUserExceptHoliday(@Param("date") String date);

    @Select("select count(*) as totalCnt " +
            "from statistics.user as u " +
            "join statistics.requestinfo as r on u.userID = r.userID " +
            "where u.HR_ORGAN = #{departmentId} and left(r.createDate, 4) = #{date}")
    Long countMonthLoginUserByDepartment(@Param("departmentId") Long departmentId,
                                         @Param("date") String date);
}
