
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
    "maneuverType",
    "mode",
    "names",
    "roadType"
})
public class Detail_ {

    @JsonProperty("maneuverType")
    private String maneuverType;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("names")
    private List<String> names = new ArrayList<String>();
    @JsonProperty("roadType")
    private String roadType;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonProperty("names")
    public List<String> getNames() {
        return names;
    }

    @JsonProperty("names")
    public void setNames(List<String> names) {
        this.names = names;
    }

    @JsonProperty("roadType")
    public String getRoadType() {
        return roadType;
    }

    @JsonProperty("roadType")
    public void setRoadType(String roadType) {
        this.roadType = roadType;
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
