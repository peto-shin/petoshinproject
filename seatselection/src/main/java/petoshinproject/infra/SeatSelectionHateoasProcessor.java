package petoshinproject.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import petoshinproject.domain.*;

@Component
public class SeatSelectionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<SeatSelection>> {

    @Override
    public EntityModel<SeatSelection> process(
        EntityModel<SeatSelection> model
    ) {
        return model;
    }
}
