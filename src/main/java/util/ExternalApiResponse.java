package util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.UsuarioDTOInput;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalApiResponse {
    private List<UsuarioDTOInput> results;

    public List<UsuarioDTOInput> getResults() {
        return results;
    }

    public void setResults(List<UsuarioDTOInput> results) {
        this.results = results;
    }
}
