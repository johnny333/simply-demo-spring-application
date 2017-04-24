package pl.uwm.edu.java.science.club.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.uwm.edu.java.science.club.dto.MessageDTO;
import pl.uwm.edu.java.science.club.service.IMessageService;

import java.util.List;

/**
 * Created by jakub on 24.04.17.
 */
@RestController
@RequestMapping(value = "/message")
public class MessageRestController {
    private IMessageService iMessageService;

    @Autowired
    private MessageRestController(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<MessageDTO> save(@RequestBody MessageDTO messageDTO) {
        return ResponseEntity.ok(this.iMessageService.saveMessage(messageDTO));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<MessageDTO>> get() {
        return ResponseEntity.ok(this.iMessageService.getMessages());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(this.iMessageService.removeMessageById(id));
    }
}
