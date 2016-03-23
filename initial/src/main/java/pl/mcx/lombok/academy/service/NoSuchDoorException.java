package pl.mcx.lombok.academy.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "No such door")
public final class NoSuchDoorException extends RuntimeException {

    public NoSuchDoorException(final String message) {
        super(message);
    }
}
