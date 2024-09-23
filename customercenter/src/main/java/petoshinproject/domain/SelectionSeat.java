package petoshinproject.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import petoshinproject.infra.AbstractEvent;

@Data
public class SelectionSeat extends AbstractEvent {

    private Long id;
    private String seatId;
    private String customerId;
    private String status;
    private Integer qty;
}
