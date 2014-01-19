
package pojo.distance.walking;

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
    "tollZone",
    "towardsRoadName",
    "transitTerminus",
    "travelDistance",
    "travelDuration",
    "travelMode",
    "hints"
})
public class ItineraryItem {

    @JsonProperty("compassDirection")
    private String compassDirection;
    @JsonProperty("details")
    private List<Detail> details = new ArrayList<Detail>();
    @JsonProperty("exit")
    private String exit;
    @JsonProperty("iconType")
    private String iconType;
    @JsonProperty("instruction")
    private Instruction instruction;
    @JsonProperty("maneuverPoint")
    private ManeuverPoint maneuverPoint;
    @JsonProperty("sideOfStreet")
    private String sideOfStreet;
    @JsonProperty("tollZone")
    private String tollZone;
    @JsonProperty("towardsRoadName")
    private String towardsRoadName;
    @JsonProperty("transitTerminus")
    private String transitTerminus;
    @JsonProperty("travelDistance")
    private Integer travelDistance;
    @JsonProperty("travelDuration")
    private Integer travelDuration;
    @JsonProperty("travelMode")
    private String travelMode;
    @JsonProperty("hints")
    private List<Hint> hints = new ArrayList<Hint>();
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
    public List<Detail> getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(List<Detail> details) {
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
    public Instruction getInstruction() {
        return instruction;
    }

    @JsonProperty("instruction")
    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    @JsonProperty("maneuverPoint")
    public ManeuverPoint getManeuverPoint() {
        return maneuverPoint;
    }

    @JsonProperty("maneuverPoint")
    public void setManeuverPoint(ManeuverPoint maneuverPoint) {
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

    @JsonProperty("tollZone")
    public String getTollZone() {
        return tollZone;
    }

    @JsonProperty("tollZone")
    public void setTollZone(String tollZone) {
        this.tollZone = tollZone;
    }

    @JsonProperty("towardsRoadName")
    public String getTowardsRoadName() {
        return towardsRoadName;
    }

    @JsonProperty("towardsRoadName")
    public void setTowardsRoadName(String towardsRoadName) {
        this.towardsRoadName = towardsRoadName;
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

    @JsonProperty("hints")
    public List<Hint> getHints() {
        return hints;
    }

    @JsonProperty("hints")
    public void setHints(List<Hint> hints) {
        this.hints = hints;
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
