package esperar.stompv2.domain.chat.dto;

import esperar.stompv2.domain.chat.ChatMessage;
import esperar.stompv2.domain.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

public class ChatDto {

    @Getter
    public static class SendMessageRequest {
        private String message;
        private UUID senderId;
        private UUID receiverId;
        private Long chatRoomId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Response {
        private String message;
        private UserDto.Response sender;
        private LocalDateTime sendTime;

        public static Response of(ChatMessage message) {
            return Response.builder()
                    .message(message.getMessage())
                    .sender(UserDto.Response.of(message.getSender()))
                    .sendTime(message.getSendTime())
                    .build();
        }
    }

}
