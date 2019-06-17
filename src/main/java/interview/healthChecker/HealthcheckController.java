package interview.healthChecker;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@RestController
class HealthcheckController {

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
    public String healthcheck(@RequestParam(required = false) String format) {
        try {
            if ("short".equals(format)) {
                HealthResponse healthResponse = new HealthResponse("OK");
                return mapper.writeValueAsString(healthResponse);
            }

            if ("full".equals(format)) {
                HealthResponse healthResponse = new HealthResponse("OK", new Date());
                return mapper.writeValueAsString(healthResponse);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/healthcheck")
    public void healthcheckPut() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping(value = "/healthcheck")
    public void healthcheckPost() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }


    @DeleteMapping(value = "/healthcheck")
    public void healthcheckDelete() {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public class HealthResponse {
        public HealthResponse(String application, Date currentTime) {
            this.application = application;
            this.currentTime = currentTime;
        }

        public HealthResponse(String status) {
            this.status = status;
        }

        private String status;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        private Date currentTime;
        private String application;

        public String getStatus() {
            return status;
        }

        public Date getCurrentTime() {
            return currentTime;
        }

        public String getApplication() {
            return application;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        HealthcheckController healthcheckController = new HealthcheckController();
        HealthResponse healthResponse = healthcheckController.new HealthResponse("OK", new Date());
        String response = mapper.writeValueAsString(healthResponse);
        System.out.println(response);
    }
}