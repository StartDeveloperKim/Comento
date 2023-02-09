package commento.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatisticResponse {

    private final Long count;
    private final String error;
}
