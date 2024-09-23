package petoshinproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import petoshinproject.infra.AbstractEvent;

@Data
public class ReservationComp extends AbstractEvent {

    private Long id;
    private String constomerId;
    private String orderId;
}
