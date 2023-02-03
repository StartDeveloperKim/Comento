package commento.demo.service;

import commento.demo.dao.StatisticMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
public class StatisticServiceImpl implements StatisticService{

    private final StatisticMapper statisticMapper;

    @Autowired
    public StatisticServiceImpl(StatisticMapper statisticMapper) {
        this.statisticMapper = statisticMapper;
    }

    @Override
    public HashMap<String, Object> yearLoginNum(Long year) {
        HashMap<String, Object> retVal = new HashMap<>();

        try {
            retVal = statisticMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
        } catch (Exception e) {
            log.error("에러 발생", e.getMessage());
            e.printStackTrace();
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }

        return retVal;
    }
}
