package commento.demo.controller;

import commento.demo.service.StatisticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SettingTest {

    private final StatisticService statisticService;

    public SettingTest(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @ResponseBody
    @GetMapping("/sqlyearStatistic")
    public Map<String, Object> sqlTest(@RequestParam("year") Long year) {
        return statisticService.yearLoginNum(year);
    }

    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("name", "devfunpj");
        List<String> resultList = new ArrayList<>();
        resultList.add("!!!HELLO WORLD!!!");
        resultList.add("설정 TEST!!");
        resultList.add("설정 TEST!!!!");
        resultList.add("설정 TEST!!!!!!");
        resultList.add("설정 TEST!!!!!!!!");
        mav.addObject("list", resultList);

        return mav;
    }
}
