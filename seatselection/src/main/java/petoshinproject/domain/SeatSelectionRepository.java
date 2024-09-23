package petoshinproject.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petoshinproject.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "seatSelections",
    path = "seatSelections"
)
public interface SeatSelectionRepository
    extends PagingAndSortingRepository<SeatSelection, Long> {}
