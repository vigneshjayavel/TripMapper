
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
    "compassDirection",
    "details",
    "exit",
    "iconType",
    "instruction",
    "maneuverPoint",
    "sideOfStreet",
    "time",
    "tollZone",
    "transitStopId",
    "transitTerminus",
    "travelDistance",
    "travelDuration",
    "travelMode",
    "tripId"
})
public class ChildItineraryItem {

    @JsonProperty("compassDirection")
    private String compassDirection;
    @JsonProperty("details")
    private List<Detail_> details = new ArrayList<Detail_>();
    @JsonProperty("exit")
    private String exit;
    @JsonProperty("iconType")
    private String iconType;
    @JsonProperty("instruction")
    private Instruction_ instruction;
    @JsonProperty("maneuverPoint")
    private ManeuverPoint_ maneuverPoint;
    @JsonProperty("sideOfStreet")
    private String sideOfStreet;
    @JsonProperty("time")
    private String time;
    @JsonProperty("tollZone")
    private String tollZone;
    @JsonProperty("transitStopId")
    private Integer transitStopId;
    @JsonProperty("transitTerminus")
    private String transitTerminus;
    @JsonProperty("travelDistance")
    private Integer travelDistance;
    @JsonProperty("travelDuration")
    private Integer travelDuration;
    @JsonProperty("travelMode")
    private String travelMode;
    @JsonProperty("tripId")
    private Integer tripId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("compassDirection")
    public String getCompassDirection() {
        return compassDirection;
    }

    @JsonProperty("compassDirection")
    public void setCompassDirection(String compassDirection) {
        this.compassDirection = compassDirection;
    }

    @JsonProperty("details")
    public List<Detail_> getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(List<Detail_> details) {
        this.details = details;
    }

    @JsonProperty("exit")
    public String getExit() {
        return exit;
    }

    @JsonProperty("exit")
    public void setExit(String exit) {
        this.exit = exit;
    }

    @JsonProperty("iconType")
    public String getIconType() {
        return iconType;
    }

    @JsonProperty("iconType")
    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    @JsonProperty("instruction")
    public Instruction_ getInstruction() {
        return instruction;
    }

    @JsonProperty("instruction")
    public void setInstruction(Instruction_ instruction) {
        this.instruction = instruction;
    }

    @JsonProperty("maneuverPoint")
    public ManeuverPoint_ getManeuverPoint() {
        return maneuverPoint;
    }

    @JsonProperty("maneuverPoint")
    public void setManeuverPoint(ManeuverPoint_ maneuverPoint) {
        this.maneuverPoint = maneuverPoint;
    }

    @JsonProperty("sideOfStreet")
    public String getSideOfStreet() {
        return sideOfStreet;
    }

    @JsonProperty("sideOfStreet")
    public void setSideOfStreet(String sideOfStreet) {
        this.sideOfStreet = sideOfStreet;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("tollZone")
    public String getTollZone() {
        return tollZone;
    }

    @JsonProperty("tollZone")
    public void setTollZone(String tollZone) {
        this.tollZone = tollZone;
    }

    @JsonProperty("transitStopId")
    public Integer getTransitStopId() {
        return transitStopId;
    }

    @JsonProperty("transitStopId")
    public void setTransitStopId(Integer transitStopId) {
        this.transitStopId = transitStopId;
    }

    @JsonProperty("transitTerminus")
    public String getTransitTerminus() {
        return transitTerminus;
    }

    @JsonProperty("transitTerminus")
    public void setTransitTerminus(String transitTerminus) {
        this.transitTerminus = transitTerminus;
    }

    @JsonProperty("travelDistance")
    public Integer getTravelDistance() {
        return travelDistance;
    }

    @JsonProperty("travelDistance")
    public void setTravelDistance(Integer travelDistance) {
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

    @JsonProperty("travelMode")
    public String getTravelMode() {
        return travelMode;
    }

    @JsonProperty("travelMode")
    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    @JsonProperty("tripId")
    public Integer getTripId() {
        return tripId;
    }

    @JsonProperty("tripId")
    public void setTripId(Integer tripId) {
        this.tripId = tripId;
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
