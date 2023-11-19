package esperar.stompv2.domain.chat.repository;

import esperar.stompv2.domain.chat.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
}
