package com.farhad.example.ddd_hexagonal_spring_data.domain.model.invoice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Invoice {

    @EqualsAndHashCode.Include
    private Long id;
    private String number;

    private List<LineItem> lineItems = new ArrayList<>();

    public Invoice(@NonNull @NotEmpty String number) {
        this.number = number;
    }

    public Invoice(@NonNull Long id, @NonNull @NotEmpty String number) {
        this.id = id;
        this.number = number;
    }

    public void addItem(@NonNull LineItem item) {
        lineItems.add(item);
    }
}
