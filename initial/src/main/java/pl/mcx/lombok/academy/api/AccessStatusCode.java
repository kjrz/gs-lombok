package pl.mcx.lombok.academy.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter @Accessors(fluent = true)
public enum AccessStatusCode {
    GRANTED(0),
    DENIED(1);

    private final int value;
}
