package online.bookStore.service.jsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonBody {
    private List<String> destination_address;
    private List<String> origin_address;
    private List<JsonRow> jsonRows;
    private String status;
}
