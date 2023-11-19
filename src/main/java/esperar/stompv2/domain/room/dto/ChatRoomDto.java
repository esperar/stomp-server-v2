package esperar.stompv2.domain.room.dto;


import esperar.stompv2.domain.room.ChatRoom;
import esperar.stompv2.domain.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

public class ChatRoomDto {

    @Getter
    @AllArgsConstructor
    public static class Request {
        private UUID user1Id;
        private UUID user2Id;
        private String roomName;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String roomName;
        private UserDto.Response user1;
        private UserDto.Response user2;

        public static Response of(ChatRoom chatRoom) {
            return Response.builder()
                    .id(chatRoom.getId())
                    .roomName(chatRoom.getRoomName())
                    .user1(chatRoom.getUser1() != null ? UserDto.Response.of(chatRoom.getUser1()) : null)
                    .user2(chatRoom.getUser2() != null ? UserDto.Response.of(chatRoom.getUser2()) : null)
                    .build();
        }
    }
}
