package kz.itstep.rest2.exceptions.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomExceptionMessage {
    private LocalDateTime timestamp;
    private String message;
    private Integer code;
}
