package esperar.stompv2.domain.room.service;

import esperar.stompv2.domain.room.ChatRoom;
import esperar.stompv2.domain.room.dto.ChatRoomDto;
import esperar.stompv2.domain.room.repository.ChatRoomRepository;
import esperar.stompv2.domain.user.User;
import esperar.stompv2.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public Long createChatRoom(ChatRoomDto.Request request) {

        User user1 = userRepository.findById(request.getUser1Id()).orElseThrow(NoSuchElementException::new);
        User user2 = userRepository.findById(request.getUser2Id()).orElseThrow(NoSuchElementException::new);

        if (user1.equals(user2)) {
            throw new RuntimeException("유저 혼자서 방을 만들 수 없습니다.");
        }

        ChatRoom chatRoom = ChatRoom.create(request.getRoomName(), user1, user2);
        return chatRoomRepository.save(chatRoom).getId();
    }
}
