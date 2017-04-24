package pl.uwm.edu.java.science.club.service;

import pl.uwm.edu.java.science.club.dto.MessageDTO;

import java.util.List;

/**
 * Created by jakub on 24.04.17.
 */
public interface IMessageService {
    MessageDTO saveMessage(MessageDTO messageDTO);
    List<MessageDTO> getMessages();
    Boolean removeMessageById(String id);
}
