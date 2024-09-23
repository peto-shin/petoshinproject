package petoshinproject.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import petoshinproject.SeatApplication;

@Entity
@Table(name = "Seat_table")
@Data
//<<< DDD / Aggregate Root
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer seatQty;

    @PostPersist
    public void onPostPersist() {}

    public static SeatRepository repository() {
        SeatRepository seatRepository = SeatApplication.applicationContext.getBean(
            SeatRepository.class
        );
        return seatRepository;
    }

    public void addSeat() {
        //implement business logic here:

    }

    //<<< Clean Arch / Port Method
    public static void decreaseSeat(SelectionSeat selectionSeat) {
        //implement business logic here:

        /** Example 1:  new item 
        Seat seat = new Seat();
        repository().save(seat);

        */

        /** Example 2:  finding and process
        
        repository().findById(selectionSeat.get???()).ifPresent(seat->{
            
            seat // do something
            repository().save(seat);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseSeat(SeatCancelled seatCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Seat seat = new Seat();
        repository().save(seat);

        */

        /** Example 2:  finding and process
        
        repository().findById(seatCancelled.get???()).ifPresent(seat->{
            
            seat // do something
            repository().save(seat);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
