package pl.uwm.edu.java.science.club.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Created by jakub on 24.04.17.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String message;
    private LocalDateTime sendTime;
}
