package online.bookStore.service.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Element {
    private Distance distance;
    private Duration duration;
    private String status;
}
