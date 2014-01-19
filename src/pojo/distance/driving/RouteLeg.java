
package pojo.distance.driving;

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
    "actualEnd",
    "actualStart",
    "alternateVias",
    "cost",
    "description",
    "itineraryItems",
    "routeRegion",
    "travelDistance",
    "travelDuration"
})
public class RouteLeg {

    @JsonProperty("actualEnd")
    private ActualEnd actualEnd;
    @JsonProperty("actualStart")
    private ActualStart actualStart;
    @JsonProperty("alternateVias")
    private List<Object> alternateVias = new ArrayList<Object>();
    @JsonProperty("cost")
    private Integer cost;
    @JsonProperty("description")
    private String description;
    @JsonProperty("itineraryItems")
    private List<ItineraryItem> itineraryItems = new ArrayList<ItineraryItem>();
    @JsonProperty("routeRegion")
    private String routeRegion;
    @JsonProperty("travelDistance")
    private Double travelDistance;
    @JsonProperty("travelDuration")
    private Integer travelDuration;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("actualEnd")
    public ActualEnd getActualEnd() {
        return actualEnd;
    }

    @JsonProperty("actualEnd")
    public void setActualEnd(ActualEnd actualEnd) {
        this.actualEnd = actualEnd;
    }

    @JsonProperty("actualStart")
    public ActualStart getActualStart() {
        return actualStart;
    }

    @JsonProperty("actualStart")
    public void setActualStart(ActualStart actualStart) {
        this.actualStart = actualStart;
    }

    @JsonProperty("alternateVias")
    public List<Object> getAlternateVias() {
        return alternateVias;
    }

    @JsonProperty("alternateVias")
    public void setAlternateVias(List<Object> alternateVias) {
        this.alternateVias = alternateVias;
    }

    @JsonProperty("cost")
    public Integer getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("itineraryItems")
    public List<ItineraryItem> getItineraryItems() {
        return itineraryItems;
    }

    @JsonProperty("itineraryItems")
    public void setItineraryItems(List<ItineraryItem> itineraryItems) {
        this.itineraryItems = itineraryItems;
    }

    @JsonProperty("routeRegion")
    public String getRouteRegion() {
        return routeRegion;
    }

    @JsonProperty("routeRegion")
    public void setRouteRegion(String routeRegion) {
        this.routeRegion = routeRegion;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
