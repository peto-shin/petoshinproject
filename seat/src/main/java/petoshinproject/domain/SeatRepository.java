package petoshinproject.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import petoshinproject.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "seats", path = "seats")
public interface SeatRepository
    extends PagingAndSortingRepository<Seat, Long> {}
