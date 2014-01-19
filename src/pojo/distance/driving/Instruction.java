
package pojo.distance.driving;

import java.util.HashMap;
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
    "formattedText",
    "maneuverType",
    "text"
})
public class Instruction {

    @JsonProperty("formattedText")
    private Object formattedText;
    @JsonProperty("maneuverType")
    private String maneuverType;
    @JsonProperty("text")
    private String text;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("formattedText")
    public Object getFormattedText() {
        return formattedText;
    }

    @JsonProperty("formattedText")
    public void setFormattedText(Object formattedText) {
        this.formattedText = formattedText;
    }

    @JsonProperty("maneuverType")
    public String getManeuverType() {
        return maneuverType;
    }

    @JsonProperty("maneuverType")
    public void setManeuverType(String maneuverType) {
        this.maneuverType = maneuverType;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
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
