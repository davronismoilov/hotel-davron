package uz.pdp.hotel.payload;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse {
    String message;
    boolean success;
    Object data;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
