package commento.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

@Mapper
public interface StatisticMapper {

    @Select("select count(*) as totCnt from statistics.requestinfo ri where left(ri.createDate, 2) = #{year}")
    HashMap<String, Object> selectYearLogin(@Param("year") Long year);

    HashMap<String, Object> selectRequestInfo();
}
