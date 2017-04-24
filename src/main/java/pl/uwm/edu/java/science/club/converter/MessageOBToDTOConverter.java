package pl.uwm.edu.java.science.club.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.uwm.edu.java.science.club.dto.MessageDTO;
import pl.uwm.edu.java.science.club.ob.MessageOB;

/**
 * Created by jakub on 24.04.17.
 */
@Component
    public class MessageOBToDTOConverter implements Converter<MessageOB,MessageDTO> {
    @Override
    public MessageDTO convert(MessageOB messageOB) {
        return MessageDTO
                .builder()
                .id(messageOB.getId())
                .firstName(messageOB.getFirstName())
                .lastName(messageOB.getLastName())
                .sendTime(messageOB.getSendTime())
                .message(messageOB.getMessage())
                .build();
    }
}
