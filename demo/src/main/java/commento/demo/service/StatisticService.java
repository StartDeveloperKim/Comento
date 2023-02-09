package commento.demo.service;

public interface StatisticService {

    Long getMonthAccessor(String date);
    Long getDayAccessor(String date);

    Long getAvgDayLoginUser();

    Long getLoginUserExceptHoliday(String date);

    Long getMonthLoginUserDepartment(Long departmentId, String date);

}
