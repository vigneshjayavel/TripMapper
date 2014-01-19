
package pojo.distance.transit;

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
    "abbreviatedName",
    "agencyId",
    "agencyName",
    "lineColor",
    "lineTextColor",
    "phoneNumber",
    "providerInfo",
    "uri",
    "verboseName",
    "version"
})
public class TransitLine {

    @JsonProperty("abbreviatedName")
    private String abbreviatedName;
    @JsonProperty("agencyId")
    private Integer agencyId;
    @JsonProperty("agencyName")
    private String agencyName;
    @JsonProperty("lineColor")
    private Integer lineColor;
    @JsonProperty("lineTextColor")
    private Integer lineTextColor;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("providerInfo")
    private String providerInfo;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("verboseName")
    private String verboseName;
    @JsonProperty("version")
    private String version;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("abbreviatedName")
    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    @JsonProperty("abbreviatedName")
    public void setAbbreviatedName(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }

    @JsonProperty("agencyId")
    public Integer getAgencyId() {
        return agencyId;
    }

    @JsonProperty("agencyId")
    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    @JsonProperty("agencyName")
    public String getAgencyName() {
        return agencyName;
    }

    @JsonProperty("agencyName")
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @JsonProperty("lineColor")
    public Integer getLineColor() {
        return lineColor;
    }

    @JsonProperty("lineColor")
    public void setLineColor(Integer lineColor) {
        this.lineColor = lineColor;
    }

    @JsonProperty("lineTextColor")
    public Integer getLineTextColor() {
        return lineTextColor;
    }

    @JsonProperty("lineTextColor")
    public void setLineTextColor(Integer lineTextColor) {
        this.lineTextColor = lineTextColor;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("providerInfo")
    public String getProviderInfo() {
        return providerInfo;
    }

    @JsonProperty("providerInfo")
    public void setProviderInfo(String providerInfo) {
        this.providerInfo = providerInfo;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("verboseName")
    public String getVerboseName() {
        return verboseName;
    }

    @JsonProperty("verboseName")
    public void setVerboseName(String verboseName) {
        this.verboseName = verboseName;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
