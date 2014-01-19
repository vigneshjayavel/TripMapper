
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
    "actualEnd",
    "actualStart",
    "alternateVias",
    "cost",
    "endLocation",
    "endTime",
    "itineraryItems",
    "routeRegion",
    "startLocation",
    "startTime",
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
    @JsonProperty("endLocation")
    private EndLocation endLocation;
    @JsonProperty("endTime")
    private String endTime;
    @JsonProperty("itineraryItems")
    private List<ItineraryItem> itineraryItems = new ArrayList<ItineraryItem>();
    @JsonProperty("routeRegion")
    private String routeRegion;
    @JsonProperty("startLocation")
    private StartLocation startLocation;
    @JsonProperty("startTime")
    private String startTime;
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

    @JsonProperty("endLocation")
    public EndLocation getEndLocation() {
        return endLocation;
    }

    @JsonProperty("endLocation")
    public void setEndLocation(EndLocation endLocation) {
        this.endLocation = endLocation;
    }

    @JsonProperty("endTime")
    public String getEndTime() {
        return endTime;
    }

    @JsonProperty("endTime")
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    @JsonProperty("startLocation")
    public StartLocation getStartLocation() {
        return startLocation;
    }

    @JsonProperty("startLocation")
    public void setStartLocation(StartLocation startLocation) {
        this.startLocation = startLocation;
    }

    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
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
