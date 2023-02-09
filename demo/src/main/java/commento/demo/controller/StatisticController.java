package commento.demo.controller;

import commento.demo.dto.StatisticResponse;
import commento.demo.service.StatisticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/{requestCriteria}")
    public ResponseEntity<StatisticResponse> getAccessorCount(@PathVariable("requestCriteria") String criteria,
                                                              @RequestParam String date) {

        log.info("criteria : {}, date : {}", criteria, date);

        if (criteria.equals("month")) {
            return ResponseEntity.ok()
                    .body(new StatisticResponse(statisticService.getMonthAccessor(date), null));
        } else if (criteria.equals("day")) {
            return ResponseEntity.ok()
                    .body(new StatisticResponse(statisticService.getDayAccessor(date), null));
        }

        return ResponseEntity.badRequest()
                .body(new StatisticResponse(0L, "잘못된 요청입니다."));
    }

    @GetMapping("/login")
    public ResponseEntity<StatisticResponse> getLoginRequestCount(@RequestParam(name = "criteria") String criteria,
                                                                  @RequestParam(name = "date") String date) {

        log.info("criteria : {}, date : {}", criteria, date);

        if (criteria.equals("avg")) {
            return ResponseEntity.ok()
                    .body(new StatisticResponse(statisticService.getAvgDayLoginUser(), null));
        } else if (criteria.equals("except-holiday")) {
            return ResponseEntity.ok()
                    .body(new StatisticResponse(statisticService.getLoginUserExceptHoliday(date), null));
        }

        return ResponseEntity.badRequest()
                .body(new StatisticResponse(0L, "잘못된 요청입니다."));
    }

    @GetMapping("/department")
    public ResponseEntity<StatisticResponse> getLoginRequestCountByDepartment(@RequestParam("id") Long id,
                                                                              @RequestParam("criteria") String criteria,
                                                                              @RequestParam("date") String date) {
        log.info("id : {} criteria : {}, date : {}", id, criteria, date);
        if (criteria.equals("month")) {
            return ResponseEntity.ok()
                    .body(new StatisticResponse(statisticService.getMonthLoginUserDepartment(id, date), null));
        }

        return ResponseEntity.badRequest()
                .body(new StatisticResponse(0L, "잘못된 요청입니다."));
    }
}
