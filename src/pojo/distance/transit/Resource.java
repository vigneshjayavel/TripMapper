
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
    "__type",
    "bbox",
    "id",
    "distanceUnit",
    "durationUnit",
    "routeLegs",
    "travelDistance",
    "travelDuration",
    "travelDurationTraffic"
})
public class Resource {

    @JsonProperty("__type")
    private String __type;
    @JsonProperty("bbox")
    private List<Double> bbox = new ArrayList<Double>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("distanceUnit")
    private String distanceUnit;
    @JsonProperty("durationUnit")
    private String durationUnit;
    @JsonProperty("routeLegs")
    private List<RouteLeg> routeLegs = new ArrayList<RouteLeg>();
    @JsonProperty("travelDistance")
    private Double travelDistance;
    @JsonProperty("travelDuration")
    private Integer travelDuration;
    @JsonProperty("travelDurationTraffic")
    private Integer travelDurationTraffic;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("__type")
    public String get__type() {
        return __type;
    }

    @JsonProperty("__type")
    public void set__type(String __type) {
        this.__type = __type;
    }

    @JsonProperty("bbox")
    public List<Double> getBbox() {
        return bbox;
    }

    @JsonProperty("bbox")
    public void setBbox(List<Double> bbox) {
        this.bbox = bbox;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("distanceUnit")
    public String getDistanceUnit() {
        return distanceUnit;
    }

    @JsonProperty("distanceUnit")
    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    @JsonProperty("durationUnit")
    public String getDurationUnit() {
        return durationUnit;
    }

    @JsonProperty("durationUnit")
    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    @JsonProperty("routeLegs")
    public List<RouteLeg> getRouteLegs() {
        return routeLegs;
    }

    @JsonProperty("routeLegs")
    public void setRouteLegs(List<RouteLeg> routeLegs) {
        this.routeLegs = routeLegs;
    }

    @JsonProperty("travelDistance")
    public Double getTravelDistance() {
        return travelDistance;
    }

    @JsonProperty("travelDistance")
    public void setTravelDistance(Double travelDistance) {
        this.travelDistance = travelDistance;
    }

    @JsonProperty("travelDuration")
    public Integer getTravelDuration() {
        return travelDuration;
    }

    @JsonProperty("travelDuration")
    public void setTravelDuration(Integer travelDuration) {
        this.travelDuration = travelDuration;
    }

    @JsonProperty("travelDurationTraffic")
    public Integer getTravelDurationTraffic() {
        return travelDurationTraffic;
    }

    @JsonProperty("travelDurationTraffic")
    public void setTravelDurationTraffic(Integer travelDurationTraffic) {
        this.travelDurationTraffic = travelDurationTraffic;
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
