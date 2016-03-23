package pl.mcx.lombok.academy.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such employee")
public final class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(final String message) {
        super(message);
    }
}
