package esperar.stompv2.domain.chat.service;

import esperar.stompv2.domain.chat.ChatMessage;
import esperar.stompv2.domain.chat.dto.ChatDto;
import esperar.stompv2.domain.chat.repository.ChatMessageRepository;
import esperar.stompv2.domain.room.ChatRoom;
import esperar.stompv2.domain.room.repository.ChatRoomRepository;
import esperar.stompv2.domain.user.User;
import esperar.stompv2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void sendMessage(ChatDto.SendMessageRequest request) {
        ChatRoom chatRoom = chatRoomRepository.findById(request.getChatRoomId())
                .orElseThrow(NoSuchElementException::new);

        User sender = userRepository.findById(request.getSenderId())
                .orElseThrow(() -> new NoSuchElementException("Sender Not Found"));

        User receiver = userRepository.findById(request.getReceiverId())
                .orElseThrow(() -> new NoSuchElementException("Receiver Not Found"));

        ChatMessage chatMessage = ChatMessage.of(request.getMessage(), LocalDateTime.now(), sender, receiver, chatRoom);
        chatMessageRepository.save(chatMessage);
    }

}
