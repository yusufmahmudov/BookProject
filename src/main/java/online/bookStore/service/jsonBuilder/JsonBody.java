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
    private List<String> destination_addresses;
    private List<String> origin_addresses;
    private List<JsonRow> rows;
    private String status;

    private String error_message;

    @Override
    public String toString() {
        return "{" +
                " destination_address: " + destination_addresses + ",\n" +
                " origin_address: " + origin_addresses + ",\n" +
                " rows: " + rows + ",\n" +
                " status: " + status + ",\n" +
                " error_message: " + error_message + "\n" +
                "}";
    }
}
