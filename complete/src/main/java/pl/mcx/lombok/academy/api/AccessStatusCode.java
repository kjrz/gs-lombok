package pl.mcx.lombok.academy.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
public enum AccessStatusCode {
    GRANTED(0),
    DENIED(1);

    @Getter @Accessors(fluent = true)
    private final int value;
}
