package pl.mcx.lombok.academy.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class AccessDto {

    @Getter
    private int code;
}
