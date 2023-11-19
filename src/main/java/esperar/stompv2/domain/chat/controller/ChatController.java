package esperar.stompv2.domain.chat.controller;

import esperar.stompv2.domain.room.dto.ChatRoomDto;
import esperar.stompv2.domain.room.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRoomService chatRoomService;

    @PostMapping("/room")
    public ResponseEntity<Void> createChatRoom(@RequestBody ChatRoomDto.Request request) {
        // 에러 핸들러를 두지 않고있기 때문에 현재 try catch로 컨트롤러에서 에러 핸들링
        // TODO: 에러 핸들러 만들기
        try {
            chatRoomService.createChatRoom(request);
        } catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
