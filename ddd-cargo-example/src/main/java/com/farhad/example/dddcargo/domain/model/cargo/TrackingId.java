package com.farhad.example.dddcargo.domain.model.cargo;

import lombok.Data;
import org.apache.commons.lang3.Validate;

@Data
final public class TrackingId {
    private final String id;

    public TrackingId(final String id) {
        Validate.notNull(id, "Tracking id must be valid :",id);
        this.id = id;
    }
}
