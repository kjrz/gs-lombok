package pl.mcx.lombok.academy.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.mcx.lombok.academy.service.DoorService;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping(value = "/door/{doorId}/access/{employeeId}")
public final class DoorController {

    private static final String LOCATION_TEMPLATE = "/door/%s/access/%s";

    private final DoorService doorService;

    @Autowired
    public DoorController(final DoorService doorService) {
        this.doorService = doorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public AccessDto getAccess(@PathVariable final Long doorId, @PathVariable final Long employeeId) {
        LOG.info("GET request: doorId={}, employeeId={}", doorId, employeeId);

        final boolean hasAccess = doorService.hasAccess(doorId, employeeId);

        return new AccessDto(hasAccess ? AccessStatusCode.GRANTED.value() : AccessStatusCode.DENIED.value());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void postAccess(@PathVariable final Long doorId, @PathVariable final Long employeeId,
                           @RequestBody final AccessDto accessDto, final HttpServletResponse response) {
        LOG.info("PUT request: doorId={}, employeeId={}, access={}", doorId, employeeId, accessDto.getCode());

        if (AccessStatusCode.GRANTED.value() == accessDto.getCode()) {
            doorService.grantAccess(doorId, employeeId);
        }
        if (AccessStatusCode.DENIED.value() == accessDto.getCode()) {
            doorService.denyAccess(doorId, employeeId);
        }

        response.setHeader(HttpHeaders.LOCATION, String.format(LOCATION_TEMPLATE, doorId, employeeId));
    }
}
