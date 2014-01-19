
package pojo.distance.transit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "endPathIndices",
    "maneuverType",
    "mode",
    "roadType",
    "startPathIndices"
})
public class Detail {

    @JsonProperty("endPathIndices")
    private List<Integer> endPathIndices = new ArrayList<Integer>();
    @JsonProperty("maneuverType")
    private String maneuverType;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("roadType")
    private String roadType;
    @JsonProperty("startPathIndices")
    private List<Integer> startPathIndices = new ArrayList<Integer>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("endPathIndices")
    public List<Integer> getEndPathIndices() {
        return endPathIndices;
    }

    @JsonProperty("endPathIndices")
    public void setEndPathIndices(List<Integer> endPathIndices) {
        this.endPathIndices = endPathIndices;
    }

    @JsonProperty("maneuverType")
    public String getManeuverType() {
        return maneuverType;
    }

    @JsonProperty("maneuverType")
    public void setManeuverType(String maneuverType) {
        this.maneuverType = maneuverType;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("roadType")
    public String getRoadType() {
        return roadType;
    }

    @JsonProperty("roadType")
    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    @JsonProperty("startPathIndices")
    public List<Integer> getStartPathIndices() {
        return startPathIndices;
    }

    @JsonProperty("startPathIndices")
    public void setStartPathIndices(List<Integer> startPathIndices) {
        this.startPathIndices = startPathIndices;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
