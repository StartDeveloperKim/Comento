package commento.demo.service;

import commento.demo.dao.RequestCode;
import commento.demo.dao.StatisticMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatisticServiceImpl implements StatisticService{

    private final StatisticMapper statisticMapper;


    @Override
    public Long getMonthAccessor(String date) {
        return statisticMapper.countMonthAccessor(date, RequestCode.ACCESS.getCode());
    }

    @Override
    public Long getDayAccessor(String date) {
        return statisticMapper.countDayAccessor(date, RequestCode.LOGIN.getCode());
    }

    @Override
    public Long getAvgDayLoginUser() {
        return statisticMapper.countAvgDayLoginUser(RequestCode.LOGIN.getCode());
    }

    @Override
    public Long getLoginUserExceptHoliday(String date) {
        return statisticMapper.countLoginUserExceptHoliday(date);
    }

    @Override
    public Long getMonthLoginUserDepartment(Long departmentId, String date) {
        return statisticMapper.countMonthLoginUserByDepartment(departmentId, date);
    }
}
