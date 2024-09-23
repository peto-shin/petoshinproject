package petoshinproject.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petoshinproject.SeatselectionApplication;
import petoshinproject.domain.SeatCancelled;
import petoshinproject.domain.SelectionSeat;

@Entity
@Table(name = "SeatSelection_table")
@Data
//<<< DDD / Aggregate Root
public class SeatSelection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String seatId;

    private String customerId;

    private String status;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        SelectionSeat selectionSeat = new SelectionSeat(this);
        selectionSeat.publishAfterCommit();

        SeatCancelled seatCancelled = new SeatCancelled(this);
        seatCancelled.publishAfterCommit();
    }

    public static SeatSelectionRepository repository() {
        SeatSelectionRepository seatSelectionRepository = SeatselectionApplication.applicationContext.getBean(
            SeatSelectionRepository.class
        );
        return seatSelectionRepository;
    }

    public void selection() {
        //implement business logic here:

        SelectionSeat selectionSeat = new SelectionSeat(this);
        selectionSeat.publishAfterCommit();
    }

    public void cencel() {
        //implement business logic here:

        SeatCancelled seatCancelled = new SeatCancelled(this);
        seatCancelled.publishAfterCommit();
    }
}
//>>> DDD / Aggregate Root
