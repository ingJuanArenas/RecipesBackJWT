package com.recipes.recipes_backend.config;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorMessage {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private String details;
}
