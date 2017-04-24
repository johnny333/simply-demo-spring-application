package pl.uwm.edu.java.science.club.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.uwm.edu.java.science.club.dto.MessageDTO;
import pl.uwm.edu.java.science.club.ob.MessageOB;

import java.time.LocalDateTime;

/**
 * Created by jakub on 24.04.17.
 */
@Component
public class MessageDTOToOBConverter implements Converter<MessageDTO, MessageOB> {
    @Override
    public MessageOB convert(MessageDTO messageDTO) {
        return MessageOB
                .builder()
                .id(messageDTO.getId())
                .firstName(messageDTO.getFirstName())
                .lastName(messageDTO.getLastName())
                .sendTime(LocalDateTime.now())
                .message(messageDTO.getMessage())
                .build();
    }
}
