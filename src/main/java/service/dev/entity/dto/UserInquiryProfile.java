package service.dev.entity.dto;

import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

public interface UserInquiryProfile {

    long idx();

    String name();

    String id();

    String email();

    String mobile();

    LocalDateTime join_date();
}
