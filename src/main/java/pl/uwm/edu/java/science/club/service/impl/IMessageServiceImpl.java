package pl.uwm.edu.java.science.club.service.impl;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.uwm.edu.java.science.club.converter.MessageDTOToOBConverter;
import pl.uwm.edu.java.science.club.converter.MessageOBToDTOConverter;
import pl.uwm.edu.java.science.club.dto.MessageDTO;
import pl.uwm.edu.java.science.club.ob.MessageOB;
import pl.uwm.edu.java.science.club.repository.IMessageRepository;
import pl.uwm.edu.java.science.club.service.IMessageService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jakub on 24.04.17.
 */
@Service
@Transactional
public class IMessageServiceImpl implements IMessageService {

    @Setter(onMethod = @__(@Autowired))
    private IMessageRepository iMessageRepository;

    @Autowired
    private MessageDTOToOBConverter messageDTOToOBConverter;

    private MessageOBToDTOConverter messageOBToDTOConverter;

    @Autowired
    private void setMessageOBToDTOConverter(MessageOBToDTOConverter messageOBToDTOConverter) {
        this.messageOBToDTOConverter = messageOBToDTOConverter;
    }

    @Override
    public MessageDTO saveMessage(MessageDTO messageDTO) {
        MessageOB convertedOB = this.messageDTOToOBConverter.convert(messageDTO);
        MessageOB saved = this.iMessageRepository.save(convertedOB);
        return this.messageOBToDTOConverter.convert(saved);
    }

    @Override
    public List<MessageDTO> getMessages() {
        List<MessageOB> all = this.iMessageRepository.findAll();
        List<MessageDTO> collect = all.stream()
                .map(messageOB -> messageOBToDTOConverter.convert(messageOB))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public Boolean removeMessageById(String id) {
        this.iMessageRepository.delete(id);
        return true;
    }
}
