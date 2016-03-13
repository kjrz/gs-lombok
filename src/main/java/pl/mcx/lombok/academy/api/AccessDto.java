package pl.mcx.lombok.academy.api;

public final class AccessDto {

    private int code;

    public AccessDto() {
    }

    public AccessDto(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(final int code) {
        this.code = code;
    }
}
