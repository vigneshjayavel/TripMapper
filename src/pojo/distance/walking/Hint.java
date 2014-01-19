
package pojo.distance.walking;

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
    "hintType",
    "text"
})
public class Hint {

    @JsonProperty("hintType")
    private Object hintType;
    @JsonProperty("text")
    private String text;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hintType")
    public Object getHintType() {
        return hintType;
    }

    @JsonProperty("hintType")
    public void setHintType(Object hintType) {
        this.hintType = hintType;
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
